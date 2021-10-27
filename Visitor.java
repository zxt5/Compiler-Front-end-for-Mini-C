import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Visitor extends compUnitBaseVisitor<Object> {
    public String ans = "";
    int cnt = 0;

    public String getRegister() {
        return "%x"+(cnt++);
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

    @Override
    public Object visitCompUnit(compUnitParser.CompUnitContext ctx) {
//         return super.visitCompUnit(ctx);
                return visitFuncDef(ctx.funcDef());

    }

    @Override
    public Void visitFuncDef(compUnitParser.FuncDefContext ctx) {
        if(ctx.FuncType().getText().equals("int")){
            ans += "define dso_local ";
        }
        if(ctx.Ident().getText().equals("main")){
            ans += "i32 @main";
        }
        ans += "()";
//        visit(ctx.block());
        visitBlock(ctx.block());
        return null;
    }

    @Override
    public Void visitBlock(compUnitParser.BlockContext ctx) {
        ans += "{\n";
//        visit(ctx.stmt());
        visitStmt(ctx.stmt());
        ans += "\n}";
        return null;
    }

    @Override
    public Void visitStmt(compUnitParser.StmtContext ctx) {
        String ret = visitExp(ctx.exp());
        ans += "ret i32 ";
        ans += ret;
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
            String reg = getRegister();
            ans += reg;
            ans += " = ";
            ans += getOp(ctx.UnaryOp().getText());
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
            String reg = getRegister();
            ans += reg + " = " + getOp(ctx.Op2().getText()) + l + " , " + r + "\n";
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
            String reg = getRegister();
            ans += reg + " = " + getOp(ctx.UnaryOp().getText()) + l + " , " + r + "\n";
            return reg;
        }
    }

    @Override
    public String visitPrimaryExp(compUnitParser.PrimaryExpContext ctx) {
        if(ctx.exp() == null)
            return getNumber(ctx.Number().getText());
        else
            return visitExp(ctx.exp());
    }

}
