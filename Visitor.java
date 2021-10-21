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
            ans += "define dso_local ";
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
        int res=0;
        String s = ctx.Number().getText();
        if (s.charAt(0)=='0'){
            if(s.charAt(1)=='x'||s.charAt(1)=='X'){
                int len = s.length();
                s = s.toLowerCase();
                for (int i=2;i<len;i++){
                    if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
                        res=16*res+ (int) s.charAt(i)-48;
                    }
                    else if(s.charAt(i)>='a'&&s.charAt(i)<='z'){
                        res=16*res +10+ ((int) s.charAt(i)-'a');
                    }
                }
                ans+=res;
            }
            else {
                int len = s.length();
                for(int i=1;i<len;i++){
                    res=8*res+ (int) s.charAt(i)-48;
                }
                ans+=res;
            }
        }
        else {
            ans+=ctx.Number().getText();
        }
        return null;
    }
}
