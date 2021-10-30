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


public class Visitor extends compUnitBaseVisitor<Object> {
    public String ans = "";
    int cnt = 0; // count register
    List<Identifier> Identifier_list = new ArrayList<>();
    List<Constant> Constant_list = new ArrayList<>();

    public String Allocate() {
        return "%"+(++cnt);
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
        int val = 0;
        if (num.charAt(0)=='0'){
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
        int n = Identifier_list.size();
        int  m = Constant_list.size();
        for(int i = 0; i < n ; i++) {
            if(Identifier_list.get(i).name.equals(name)) return true;
        }
        for(int i=0 ; i<m ; i++) {
            if(Constant_list.get(i).name.equals(name)) return true;
        }
        return false;
    }

    public String getRegister(String name) {
        int n = Identifier_list.size();
        int  m = Constant_list.size();
        for(int i = 0; i < n ; i++) {
            if(Identifier_list.get(i).name.equals(name))
                return Identifier_list.get(i).register;
        }
        for(int i=0 ; i<m ; i++) {
            if(Constant_list.get(i).name.equals(name)) return Constant_list.get(i).register;
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
        if(ctx.Type().getText().equals("int")){
            ans += "define dso_local ";
        }
        if(ctx.IdentMain().getText().equals("main")){
            ans += "i32 @main";
        }
        ans += "()";
        visitBlock(ctx.block());
        return null;
    }

    @Override
    public String visitDecl(compUnitParser.DeclContext ctx) {
        if(ctx.constDecl()==null) return visitVarDecl(ctx.varDecl());
        else return visitConstDecl(ctx.constDecl());
    }


    @Override
    public String visitConstDecl(compUnitParser.ConstDeclContext ctx) {
        int n = ctx.constDef().size();
        for(int i=0 ; i<n ; i++) {
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
    public String visitVarDecl(compUnitParser.VarDeclContext ctx) {
        int n = ctx.varDef().size();
        for(int i=0 ; i<n ; i++) {
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
    public String visitConstInitVal(compUnitParser.ConstInitValContext ctx) {
        return visitConstExp(ctx.constExp());
    }

    @Override
    public String visitConstExp(compUnitParser.ConstExpContext ctx) {
        return visitAddExp(ctx.addExp());
    }

    @Override
    public String visitInitVal(compUnitParser.InitValContext ctx) {
        return visitExp(ctx.exp());
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
    public String visitStmt(compUnitParser.StmtContext ctx) {
        if(ctx.lVal() == null) {
            if(ctx.Return() !=null) {
                String reg = visitExp(ctx.exp());
                ans += "ret i32 " + reg;
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
    public String visitLVal(compUnitParser.LValContext ctx) {
        String name = ctx.Ident().getText();
        if(!isDefined(name)) {
//            for(int i=0;i<Identifier_list.size();i++) {
//                System.out.println(Identifier_list.get(i).name);
//            }
//            System.out.println(name);
            System.exit(-2);
        }
        return getRegister(name);
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

    public String visitUnaryExp(compUnitParser.UnaryExpContext ctx) {
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



}
