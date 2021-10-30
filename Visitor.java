import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Identifier {
    String name;
    String register;
    String type;

    public Identifier(String name,String register) {
        this.name = name;
        this.register = register;
    }
}

class Constant {
    String name;
    String register;
    String type;

    public Constant(String name,String register) {
        this.name = name;
        this.register = register;
    }
}

class Function {
    String name;
    String returnType; // int  void String ...
    List<String> parameter_list = new ArrayList<>();

    public Function(String name) {
        this.name = name;
    }
    public Function(String name,String returnType) {
        this.name = name;
        this.returnType = returnType;
    }
    public Function(String name,String returnType,List<String> parameter_list) {
        this.name = name;
        this.returnType = returnType;
        this.parameter_list = parameter_list;
    }
}

class Register {
    String name;
    String type;

    public Register(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Register(String name) {
        this.name = name;
    }
}

public class Visitor extends compUnitBaseVisitor<Object> {
    public String ans = "";
    int cnt = 0; // count register
    List<Identifier> Identifier_list = new ArrayList<>();  // 变量表
    List<Constant> Constant_list = new ArrayList<>();      // 常量表
    List<Function> Function_list = new ArrayList<>();      // 函数表
    List<Register> Register_list = new ArrayList<>();      // 寄存器表

    public void init() {
        // 初始化函数表
        Function_list.add(new Function("getint","i32"));
        Function_list.add(new Function("getch","i32"));
        Function_list.add(new Function("putint","void"));
        Function_list.add(new Function("getch","void"));

        ans += "declare i32 @getint()\n";
        ans += "declare i32 @getch()\n";
        ans += "declare void @putint(i32)";
        ans += "declare void @putch(i32)\n";
    }

    // 分配寄存器
    public String Allocate() {
        String name = "%"+(++cnt);
        Register reg = new Register(name,"i32");
        Register_list.add(reg);
        return name;
    }

    public String getOp(String s) {
        if( s.equals("+") ) return "add i32 ";
        if( s.equals("-") ) return "sub i32 ";
        if( s.equals("*") ) return "mul i32 ";
        if( s.equals("/") ) return "sdiv i32 ";
        if( s.equals("%") ) return "srem i32 ";
        return null;
    }

    public String getNumber(String num) {
//        System.out.println(num);
        int val = 0;
        if (num.charAt(0)=='0'&&num.length()>1){
            if(num.charAt(1)=='x'||num.charAt(1)=='X') {
                num = num.toLowerCase();
                for (int i = 2; i < num.length(); i++) {
                    if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
                        val = 16 * val + (int)num.charAt(i) - 48;
                    } else {
                        val = 16 * val + ((int)num.charAt(i) - 'a') + 10;
                    }
                }
            }
            else {
                for( int i = 1 ; i < num.length() ; i++ ) {
                    val = 8 * val + (int)num.charAt(i) - 48;
                }
            }
            return Integer.toString(val);
        }
        else {
            return num;
        }
    }

    public boolean isDefined(String name) {
        for (Identifier identifier : Identifier_list) {
            if (identifier.name.equals(name)) return true;
        }
        for (Constant constant : Constant_list) {
            if (constant.name.equals(name)) return true;
        }
        return false;
    }

    public boolean Function_is_defined(String name) {
        for (Function function : Function_list) {
            if (function.name.equals(name)) return true;
        }
        return false;
    }

    public String getRegister(String name) {
        for (Identifier identifier : Identifier_list) {
            if (identifier.name.equals(name))
                return identifier.register;
        }
        for (Constant constant : Constant_list) {
            if (constant.name.equals(name)) return constant.register;
        }
        return null;
    }

    @Override
    public Object visitCompUnit(compUnitParser.CompUnitContext ctx) {
//        return super.visitCompUnit(ctx);
        return visitFuncDef(ctx.funcDef());
    }

    @Override
    public Void visitFuncDef(compUnitParser.FuncDefContext ctx) {
        ans += "define dso_local i32 @main()";
        visitBlock(ctx.block());
        return null;
    }

    @Override
    public Void visitBlock(compUnitParser.BlockContext ctx) {
        ans += "{\n";
        int n = ctx.blockItem().size();
        for(int i=0 ; i<n ; i++) {
            visitBlockItem(ctx.blockItem(i));
        }
        ans += "\n}";
        return null;
    }

    @Override
    public String visitBlockItem(compUnitParser.BlockItemContext ctx) {
        if(ctx.decl() == null) {
            visitStmt(ctx.stmt());
        }
        else {
            visitDecl(ctx.decl());
        }
        return null;
    }

    @Override
    public String visitDecl(compUnitParser.DeclContext ctx) {
        if(ctx.constDecl()==null)  visitVarDecl(ctx.varDecl());
        else visitConstDecl(ctx.constDecl());
        return null;
    }

    @Override
    public String visitVarDecl(compUnitParser.VarDeclContext ctx) {
        int n = ctx.varDef().size();
        for(int i=0 ; i<n ; i++) {
            String name = ctx.varDef(i).getText();
            if(isDefined(name)) System.exit(1);
            visitVarDef(ctx.varDef(i));
        }
        return null;
    }

    @Override
    public String visitVarDef(compUnitParser.VarDefContext ctx) {
        String reg = Allocate();
        ans += reg + " = alloca i32\n";
        String name = ctx.Ident().getText();
        // 加入变量池
        Identifier identifier = new Identifier(name,reg);
        Identifier_list.add(identifier);

        if(ctx.initVal()!=null) {
            String ret = visitInitVal(ctx.initVal());
            ans += "store i32 " + ret + " , " + "i32* " + reg + "\n" ;
        }
        return null;
    }

    @Override
    public String visitInitVal(compUnitParser.InitValContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public String visitConstDecl(compUnitParser.ConstDeclContext ctx) {
        int n = ctx.constDef().size();
        for(int i=0 ; i<n ; i++) {
            String name = ctx.constDef(i).getText();
            if(isDefined(name)) System.exit(2);
            visitConstDef(ctx.constDef(i));
        }
        return null;
    }

    @Override
    public String visitConstDef(compUnitParser.ConstDefContext ctx) {
        String reg = Allocate();
        ans += reg + " = alloca i32\n";
        String name = ctx.Ident().getText();
        // 加入常量池
        Constant constant = new Constant(name,reg);
        Constant_list.add(constant);
        String ret = visitConstInitVal(ctx.constInitVal());
        ans += "store i32 " + ret + " , " + "i32* " + reg + "\n" ;
        return null;
    }

    @Override
    public String visitConstInitVal(compUnitParser.ConstInitValContext ctx) {
        return visitConstExp(ctx.constExp());
    }

    @Override
    public String visitConstExp(compUnitParser.ConstExpContext ctx) {
        return visitAddExp(ctx.addExp());
    }

    @Override
    public String visitStmt(compUnitParser.StmtContext ctx) {
        if(ctx.lVal() == null) {
            if(ctx.Return() !=null) {
                String reg = visitExp(ctx.exp());
                ans += "ret i32 " + reg + "\n";
            }
            else {
                visitExp(ctx.exp());
            }
        }
        else {
            String name = ctx.lVal().Ident().getText();
            if(!isDefined(name)) System.exit(-1); // 如果变量未定义，报错
            String curReg = getRegister(name);
            String ret = visitExp(ctx.exp());
            ans += "store i32 " + ret + " , " + "i32* " + curReg + "\n";
        }
        return null;
    }

    @Override
    public String visitExp(compUnitParser.ExpContext ctx) {
        return visitAddExp(ctx.addExp());
    }

    @Override
    public String visitAddExp(compUnitParser.AddExpContext ctx) {
        if(ctx.addExp()==null) {
            return visitMulExp(ctx.mulExp());
        }
        else {
            String l = visitAddExp(ctx.addExp());
            String r = visitMulExp(ctx.mulExp());
            String reg = Allocate();
            ans += reg;
            ans += " = ";
            ans += getOp(ctx.unaryOp().getText());
            ans += l;
            ans += " , ";
            ans += r;
            ans += "\n";
            return reg;
        }
    }

    @Override
    public String visitMulExp(compUnitParser.MulExpContext ctx) {
        if( ctx.mulExp()==null ) {
            return visitUnaryExp(ctx.unaryExp());
        }
        else {
            String l = visitMulExp(ctx.mulExp());
            String r = visitUnaryExp(ctx.unaryExp());
            String reg = Allocate();
            ans += reg + " = " + getOp(ctx.calOp().getText()) + l + " , " + r + "\n";
            return reg;
        }
    }

    @Override
    public String visitUnaryExp(compUnitParser.UnaryExpContext ctx) {
        if(ctx.Ident()!=null) {
            String name = ctx.Ident().getText();
            if(!Function_is_defined(name)) System.exit(-3); // 函数未定义，报错
            switch (name) {
                case "getint": {
                    if (ctx.funcRParams() != null) System.exit(-4);
                    String reg = Allocate();
                    ans += reg + " = call i32 @getint()\n";
                    return reg;
                }
                case "putint": {
                    if (ctx.funcRParams().exp().size() != 1) System.exit(-5);
                    String reg = visitExp(ctx.funcRParams().exp(0));
                    ans += "call void @putint(i32 " + reg + ")\n";
                    break;
                }
                case "getch": {
                    if (ctx.funcRParams() != null) System.exit(-6);
                    String reg = Allocate();
                    ans += reg + " = call i32 @getch()\n";
                    return reg;
                }
                case "putch": {
                    if (ctx.funcRParams().exp().size() != 1) System.exit(-7);
                    String reg = visitExp(ctx.funcRParams().exp(0));
                    ans += "call void @putch(i32 " + reg + ")\n";
                    break;
                }
                default:
                    break;
            }
        }
        else {
            if( ctx.unaryExp()==null ) {
                return visitPrimaryExp(ctx.primaryExp());
            }
            else {
                String l = "0";
                String r = visitUnaryExp(ctx.unaryExp());
                String reg = Allocate();
                ans += reg + " = " + getOp(ctx.unaryOp().getText()) + l + " , " + r + "\n";
                return reg;
            }
        }
        return null;
    }

    @Override
    public String visitFuncRParams(compUnitParser.FuncRParamsContext ctx) {
        int n = ctx.exp().size();
        for(int i=0 ; i<n ;i++) {
            visitExp(ctx.exp(i));
        }
        return null;
    }


    @Override
    public String visitLVal(compUnitParser.LValContext ctx) {
        String name = ctx.Ident().getText();
        if(!isDefined(name)) {
            System.exit(-2);
        }
        String reg = getRegister(name);
        String newReg = Allocate();
        ans += newReg + " = load i32, i32* " + reg + "\n";
        return newReg;
    }

    @Override
    public String visitPrimaryExp(compUnitParser.PrimaryExpContext ctx) {
        if(ctx.exp() == null) {
            if(ctx.lVal()==null) {
                return getNumber(ctx.Number().getText());
            }
            else {
                return visitLVal(ctx.lVal());
            }
        }
        else
            return visitExp(ctx.exp());
    }










}
