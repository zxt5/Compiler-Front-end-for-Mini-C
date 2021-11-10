import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Identifier {
    String name;
    Register register;
    String type;

    public Identifier(String name,Register register) {
        this.name = name;
        this.register = register;
    }
}

class Constant {
    String name;
    Register register;
    String type;

    public Constant(String name,Register register) {
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
    int cnt_block = 0;
    public boolean isConst = false;
    List<Identifier> Identifier_list = new ArrayList<>();  // 变量表
    List<Constant> Constant_list = new ArrayList<>();      // 常量表
    List<Function> Function_list = new ArrayList<>();      // 函数表
    List<Register> Register_list = new ArrayList<>();      // 寄存器表

    public void init() {
        // 初始化函数表
        Function_list.add(new Function("getint","i32"));
        Function_list.add(new Function("getch","i32"));
        Function_list.add(new Function("putint","void"));
        Function_list.add(new Function("putch","void"));

        ans += "declare i32 @getint()\n";
        ans += "declare i32 @getch()\n";
        ans += "declare void @putint(i32)\n";
        ans += "declare void @putch(i32)\n";
    }


    // 分配寄存器
    public Register Allocate(String type) {
        String name = "%"+(++cnt);
        Register reg = new Register(name,type);
        Register_list.add(reg);
        return reg;
    }

    public Register Allocate() {
        String name = "%"+(++cnt);
        Register reg = new Register(name);
        Register_list.add(reg);
        return reg;
    }

    // 分配 块
    public String newBlock() {
        return "block_" + (cnt_block++);
    }

    // 运算符转换成对应语法
    public String getOp(String s) {
        if( s.equals("+") ) return "add i32 ";
        if( s.equals("-") ) return "sub i32 ";
        if( s.equals("*") ) return "mul i32 ";
        if( s.equals("/") ) return "sdiv i32 ";
        if( s.equals("%") ) return "srem i32 ";
        if( s.equals("==") ) return "eq ";
        if( s.equals("!=") ) return "ne ";
        if( s.equals("<") ) return "slt ";
        if( s.equals("<=") ) return "sle ";
        if( s.equals(">") ) return "sgt ";
        if( s.equals(">=") ) return "sge ";
        if( s.equals("!") ) return "icmp eq i32 ";
        return null;
    }

    // 数制转换
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


    // 判断变量是否定义
    public boolean isDefined(String name) {
        for (Identifier identifier : Identifier_list) {
            if (identifier.name.equals(name)) return true;
        }
        for (Constant constant : Constant_list) {
            if (constant.name.equals(name)) return true;
        }
        return false;
    }

    // 判断是否是常量
    public boolean isConstant(String name) {
        for (Constant constant : Constant_list) {
            if (constant.name.equals(name)) return true;
        }
        return false;
    }

    // 判断函数是否定义
    public boolean Function_is_defined(String name) {
        for (Function function : Function_list) {
            if (function.name.equals(name)) return true;
        }
        return false;
    }

    // 获取变量的寄存器号
    public String getRegister(String name) {
        for (Identifier identifier : Identifier_list) {
            if (identifier.name.equals(name))
                return identifier.register.name;
        }
        for (Constant constant : Constant_list) {
            if (constant.name.equals(name)) return constant.register.name;
        }
        return null;
    }

    @Override
    public Object visitCompUnit(compUnitParser.CompUnitContext ctx) {
        return visitFuncDef(ctx.funcDef());
    }

    @Override
    public Void visitFuncDef(compUnitParser.FuncDefContext ctx) {
        ans += "define dso_local i32 @main()";
        ans += "{\n";
        visitBlock(ctx.block());
        ans += "\n}\n";
        return null;
    }

    @Override
    public Void visitBlock(compUnitParser.BlockContext ctx) {
//        ans += "{\n";
        int n = ctx.blockItem().size();
        for(int i=0 ; i<n ; i++) {
//            System.out.println("\n ** \n");
            visitBlockItem(ctx.blockItem(i));
        }
//        ans += "\n}";
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
            if(isDefined(name)) System.exit(-1);
            visitVarDef(ctx.varDef(i));
        }
        return null;
    }

    @Override
    public String visitVarDef(compUnitParser.VarDefContext ctx) {
        Register reg = Allocate("i32");
        ans += reg.name + " = alloca i32\n";
        String name = ctx.Ident().getText();
        // 加入变量池
        Identifier identifier = new Identifier(name,reg);
        Identifier_list.add(identifier);

        if(ctx.initVal()!=null) {
            Register ret = visitInitVal(ctx.initVal());
            ans += "store i32 " + ret.name + " , " + "i32* " + reg.name + "\n" ;
        }
        return null;
    }

    @Override
    public Register visitInitVal(compUnitParser.InitValContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public String visitConstDecl(compUnitParser.ConstDeclContext ctx) {
        this.isConst = true;
        int n = ctx.constDef().size();
        for(int i=0 ; i<n ; i++) {
            String name = ctx.constDef(i).getText();
            if(isDefined(name)) System.exit(-2);
            visitConstDef(ctx.constDef(i));
        }
        this.isConst = false;
        return null;
    }

    @Override
    public String visitConstDef(compUnitParser.ConstDefContext ctx) {
        Register reg = Allocate("i32");
        ans += reg + " = alloca i32\n";
        String name = ctx.Ident().getText();
        // 加入常量池
        Constant constant = new Constant(name,reg);
        Constant_list.add(constant);
        Register ret = visitConstInitVal(ctx.constInitVal());
        ans += "store i32 " + ret.name + " , " + "i32* " + reg.name + "\n" ;
        return null;
    }

    @Override
    public Register visitConstInitVal(compUnitParser.ConstInitValContext ctx) {
        return visitConstExp(ctx.constExp());
    }

    @Override
    public Register visitConstExp(compUnitParser.ConstExpContext ctx) {
        return visitAddExp(ctx.addExp());
    }

    @Override
    public Void visitStmt(compUnitParser.StmtContext ctx) {
        if(ctx.lVal() != null) {             // LVal '=' Exp ';'
            String name = ctx.lVal().Ident().getText();
            if(!isDefined(name)) System.exit(-3); // 如果变量未定义，报错
//            System.out.println(name);
            if(isConstant(name)) System.exit(-4);
            String curReg = getRegister(name);
            Register ret = visitExp(ctx.exp());
            ans += "store i32 " + ret.name + " , " + "i32* " + curReg + "\n";
        }
        else if(ctx.Return() != null) {      // 'return' Exp ';'
//             Allocate("i32");
            Register reg = visitExp(ctx.exp());
            ans += "ret " + reg.type + " "+ reg.name + "\n";
            return null;
        }
        else if(ctx.condition() != null) {    // 'if' '(' Cond ')' Stmt [ 'else' Stmt ]
            int stmt_len = ctx.stmt().size();
            Register reg_cond = visitCondition(ctx.condition());
            if(reg_cond.type.equals("i32")) {
                Register cur_reg = Allocate("i1");
                ans += cur_reg.name + " = trunc i32 " + reg_cond.name + " to i1\n";
                reg_cond = cur_reg;
            }

            if(stmt_len == 1) {  // 只有if没有else
                String block_stmt = newBlock();
                String block_next = newBlock();
                ans += "br i1 " + reg_cond.name + " , label %" + block_stmt + " , label %" + block_next + "\n";
                ans += block_stmt + ":\n";
                visitStmt(ctx.stmt().get(0));
                ans += "br label %" + block_next + "\n";
                ans += block_next + ":\n";
            }
            else {   // if ... else ...
                String block_stmt = newBlock();
                String block_else = newBlock();
                String block_next = newBlock();
                ans += "br i1 " + reg_cond.name + " , label %" + block_stmt + " , label %" + block_else + "\n";
                ans += block_stmt + ":\n";
                visitStmt(ctx.stmt().get(0));
                ans += "br label %" + block_next + "\n";
                ans += block_else + ":\n";
                visitStmt(ctx.stmt().get(1));
                ans += "br label %" + block_next + "\n";
                ans += block_next + ":\n";
            }
        }
        else if(ctx.block() != null) {         // Block
            visitBlock(ctx.block());
        }
        else if(ctx.exp()!=null) {
            visitExp(ctx.exp());
        }
        return null;
    }

    @Override
    public Register visitCondition(compUnitParser.ConditionContext ctx) {
        return visitLorExp(ctx.lorExp());
    }

    @Override
    public Register visitLorExp(compUnitParser.LorExpContext ctx) {
        if(ctx.lorExp() != null) {    // LOrExp '||' LAndExp
            Register lor_reg = visitLorExp(ctx.lorExp());
            Register land_reg = visitLandExp(ctx.landExp());
            Register cur_reg = Allocate("i1");
            ans += cur_reg.name + " = " + "or " + "i1 " + lor_reg.name + " , " + land_reg.name + "\n";
            return cur_reg;
        }
        else {
            return visitLandExp(ctx.landExp());
        }
    }

    @Override
    public Register visitLandExp(compUnitParser.LandExpContext ctx) {
        if(ctx.landExp() != null) {      // LAndExp '&&' EqExp
            Register land_reg = visitLandExp(ctx.landExp());
            Register eq_reg = visitEqExp(ctx.eqExp());
            Register cur_reg = Allocate("i1");
            ans += cur_reg.name + " = " + "and " + "i1 " + land_reg.name + " , " + eq_reg.name + "\n";
            return cur_reg;
        }
        else {
            return visitEqExp(ctx.eqExp());
        }
    }

    @Override
    public Register visitEqExp(compUnitParser.EqExpContext ctx) {
        if(ctx.eqExp() != null) {    // EqExp ('==' | '!=') RelExp
            Register eq_reg = visitEqExp(ctx.eqExp());
            Register rel_reg = visitRelExp(ctx.relExp());
            Register cur_reg = Allocate("i1");
//            %14 = icmp eq i32 %13, 10
            if(eq_reg.type.equals("i1")) {
                Register temp1 = Allocate("i32");
                ans += temp1.name + " = " + "zext i1 " + eq_reg.name + " to i32\n";
                eq_reg = temp1;
            }
            if(rel_reg.type.equals("i1")) {
                Register temp2 = Allocate("i32");
                ans += temp2.name + " = " + "zext i1 " + rel_reg.name + " to i32\n";
                rel_reg = temp2;
            }

            if(ctx.Equal().getText().equals("=="))
                ans += cur_reg.name + " = " + "icmp eq " + "i32 " + eq_reg.name + " , " + rel_reg.name + "\n";
            else
                ans += cur_reg.name + " = " + "icmp ne " + "i32 " + eq_reg.name + " , " + rel_reg.name + "\n";
//            String reg = Allocate();
//            ans += reg + " = " + "zext" + " i1 " + cur_reg + " to i32\n";
//            return reg;
            return cur_reg;
        }
        else {
            return visitRelExp(ctx.relExp());
        }
    }

    @Override
    public Register visitRelExp(compUnitParser.RelExpContext ctx) {
        if(ctx.relExp() != null) {   // RelExp ('<' | '>' | '<=' | '>=') AddExp
            Register rel_reg = visitRelExp(ctx.relExp());
            Register add_reg = visitAddExp(ctx.addExp());
            Register cur_reg = Allocate("i1");
            String cmp = getOp(ctx.Cmp().getText());
            if(rel_reg.type.equals("i1")) {
                Register temp1 = Allocate("i32");
                ans += temp1.name + " = " + "zext i1 " + rel_reg.name + " to i32\n";
                rel_reg = temp1;
            }
            if(add_reg.type.equals("i1")) {
                Register temp2 = Allocate("i32");
                ans += temp2.name + " = " + "zext i1 " + add_reg.name + " to i32\n";
                add_reg = temp2;
            }
            ans += cur_reg.name + " = " + "icmp " + cmp + " i32 " + rel_reg.name + " , " + add_reg.name + "\n";
            // %9 = zext i1 %7 to i32
//            String reg = Allocate();
//            ans += reg + " = " + "zext" + " i1 " + cur_reg + " to i32\n";
//            return reg;
            return cur_reg;
        }
        else {
            return visitAddExp(ctx.addExp());
        }
    }



    @Override
    public Register visitExp(compUnitParser.ExpContext ctx) {
        return visitAddExp(ctx.addExp());
    }

    @Override
    public Register visitAddExp(compUnitParser.AddExpContext ctx) {
        if(ctx.addExp()==null) {
            return visitMulExp(ctx.mulExp());
        }
        else {
            Register l = visitAddExp(ctx.addExp());
            Register r = visitMulExp(ctx.mulExp());
            Register reg = Allocate("i32");
            ans += reg.name + " = " + getOp(ctx.unaryOp().getText()) + l.name + " , " + r.name + "\n";
            return reg;
        }
    }

    @Override
    public Register visitMulExp(compUnitParser.MulExpContext ctx) {
        if( ctx.mulExp()==null ) {
            return visitUnaryExp(ctx.unaryExp());
        }
        else {
            Register l = visitMulExp(ctx.mulExp());
            Register r = visitUnaryExp(ctx.unaryExp());
            Register reg = Allocate("i32");
            ans += reg.name + " = " + getOp(ctx.calOp().getText()) + l.name + " , " + r.name + "\n";
            return reg;
        }
    }

    @Override
    public Register visitUnaryExp(compUnitParser.UnaryExpContext ctx) {
        if(ctx.Ident()!=null) {
            String name = ctx.Ident().getText();
            if(!Function_is_defined(name)) System.exit(-5); // 函数未定义，报错
            switch (name) {
                case "getint": {
                    if (ctx.funcRParams() != null) System.exit(-6);
                    Register reg = Allocate("i32");
                    ans += reg.name + " = call i32 @getint()\n";
                    return reg;
                }
                case "putint": {
                    if (ctx.funcRParams().exp().size() != 1) System.exit(-7);
                    Register reg = visitExp(ctx.funcRParams().exp(0));
                    ans += "call void @putint(i32 " + reg.name + ")\n";
                    break;
                }
                case "getch": {
                    if (ctx.funcRParams() != null) System.exit(-8);
                    Register reg = Allocate("i32");
                    ans += reg.name + " = call i32 @getch()\n";
                    return reg;
                }
                case "putch": {
                    if (ctx.funcRParams().exp().size() != 1) System.exit(-9);
                    Register reg = visitExp(ctx.funcRParams().exp(0));
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
                Register r = visitUnaryExp(ctx.unaryExp());
                if(r.type.equals("i1")) {
                    Register temp = Allocate("i32");
                    ans += temp.name + " = " + "zext i1 " + r.name + " to i32\n";
                    r = temp;
                }
                Register reg = Allocate();
                if(ctx.unaryOp().getText().equals("!")) {
                    reg.type = "i1";
                }
                else {
                    reg.type = "i32";
                }
                ans += reg.name + " = " + getOp(ctx.unaryOp().getText()) + l + " , " + r.name + "\n";
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
    public Register visitLVal(compUnitParser.LValContext ctx) {
        String name = ctx.Ident().getText();
        if(!isDefined(name)) {
            System.exit(-10);
        }
        if(!isConstant(name) && this.isConst) {
            System.exit(-11);
        }
        String reg = getRegister(name);
        Register newReg = Allocate("i32");
        ans += newReg.name + " = load i32, i32* " + reg + "\n";
        return newReg;
    }

    // primaryExp   : '(' exp ')' | lVal | Number ;
    @Override
    public Register visitPrimaryExp(compUnitParser.PrimaryExpContext ctx) {
        if(ctx.exp() == null) {
            if(ctx.lVal()==null) {  // Number
                Register reg = Allocate("i32");
                ans += reg.name + " = alloca i32\n";
//                ans += reg.name + " = load i32, i32 " + getNumber(ctx.Number().getText()) + "\n";
                ans += "store i32 " + getNumber(ctx.Number().getText()) + " , " + "i32* " + reg.name + "\n";
                Register temp = Allocate("i32");
                ans += temp.name + " = load i32, i32* " + reg.name + "\n";
                return temp;
//                 return reg;
            }
            else {
                return visitLVal(ctx.lVal());
            }
        }
        else
            return visitExp(ctx.exp());
    }


}
