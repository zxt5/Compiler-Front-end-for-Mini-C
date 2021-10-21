import java.util.Locale;

public class Visitor extends compUnitBaseVisitor<Void> {
    public String ans = "";
    @Override
    public Void visitCompUnit(compUnitParser.CompUnitContext ctx) {
        return super.visitCompUnit(ctx);
    }
    @Override
    public Void visitFuncDef(compUnitParser.FuncDefContext ctx) {
        if(ctx.FuncType().getText().equals("int")){
            ans += "define dso_local";
        }
        if(ctx.Ident().getText().equals("main")){
            ans += "i32 @main";
        }
        ans += "()";
        visit(ctx.block());
        return null;
    }

    @Override
    public Void visitBlock(compUnitParser.BlockContext ctx) {
        ans += "{";
        visit(ctx.stmt());
        ans += "}";
        return null;
    }

    @Override
    public Void visitStmt(compUnitParser.StmtContext ctx) {
        ans += "ret i32 ";
        int val = 0;
        String num = ctx.Number().getText();
        if (num.charAt(0)=='0'){
            if(num.charAt(1)=='x'||num.charAt(1)=='X') {
                num = num.toLowerCase();
                for (int i = 2; i < num.length(); i++) {
                    if (num.charAt(i) >= '0' && num.charAt(i) <= '9') {
                        val += 16 * val + num.charAt(i) - 48;
                    } else {
                        val += 16 * val + num.charAt(i) - 'a' + 10;
                    }
                    ans += val;
                }
            }
            else {
                for( int i = 1 ; i < num.length() ; i++ ) {
                    val += 8 * val + num.charAt(i) - 48;
                }
                ans += val;
            }
        }
        else {
            ans += ctx.Number().getText();
        }
        return null;
    }
}
