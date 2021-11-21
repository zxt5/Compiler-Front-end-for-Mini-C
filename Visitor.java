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
    boolean isConst;
    boolean isGlobal;
    int value;
    public Identifier(String name,Register register,boolean isConst,boolean isGlobal) {
        this.name = name;
        this.register = register;
        this.isConst = isConst;
        this.isGlobal = isGlobal;
    }

    public Identifier(String name,Register register,boolean isConst,boolean isGlobal,int value) {
        this.name = name;
        this.register = register;
        this.isConst = isConst;
        this.isGlobal = isGlobal;
        this.value = value;
    }
}

class Identifier_list {
    List<Identifier> list ;

    public Identifier_list() {
        this.list = new ArrayList<>();
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
    int cnt_block = 0;  // 块的数量
    public boolean isConst = false;  // 标记是否正在处理常量
    public boolean isGlobal = false;  // 标记是否正在处理全局变量
    public String cur_while_head;  // 标记当前while的开始，即条件判断
    public String cur_while_end;   // 标记当前while结束后的代码位置
    boolean is_break_or_continue = false;  // 标记访问的while循环中是否有break或continue
    List<Identifier> cur_identifier_list = null;  // 当前符号表
    List<Identifier_list> Identifier_table = new ArrayList<>(); // 符号表
    List<Function> Function_list = new ArrayList<>();     // 函数表
    List<Register> Register_list = new ArrayList<>();      // 寄存器表

    public void init() {
        // 初始化函数表
        Function_list.add(new Function("getint","i32"));
        Function_list.add(new Function("getch","i32"));
        Function_list.add(new Function("putint","void"));
        Function_list.add(new Function("putch","void"));

        // 初始化全局块
        Identifier_list cur = new Identifier_list();
        cur_identifier_list = cur.list;
        Identifier_table.add(cur);

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

    public int Calculate(int a, int b, String Op) {
        if(Op.equals("+"))  return a + b;
        if(Op.equals("-"))  return a - b;
        if(Op.equals("*"))  return a * b;
        if(Op.equals("/"))  return a / b;
        if(Op.equals("%"))  return a % b;
        if(Op.equals("==")) {
            if(a==b) return 1;
            else return 0;
        }
        if(Op.equals("<")) {
            if(a < b) return 1;
            else return 0;
        }
        if(Op.equals("<=")) {
            if(a <= b) return 1;
            else return 0;
        }
        if(Op.equals(" > ")) {
            if(a > b) return 1;
            else return 0;
        }
        if(Op.equals(" >= ")) {
            if(a >= b) return 1;
            else return 0;
        }
        return 0;
    }

    int getValue_byName(String name) {
        int size = Identifier_table.size();
        for(int i = size-1 ; i>=0 ; i--) {
            Identifier_list tmp = Identifier_table.get(i);
            List<Identifier> list = tmp.list;
            for (Identifier identifier : list) {
                if (identifier.name.equals(name)) {
                    return list.get(i).value;
                }
            }
        }
        return -1;
    }

    // 数制转换
    public String getNumber(String num) {
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


    // 判断变量在当前作用域是否定义
    public boolean isDefined_curField(String name) {
        int size = cur_identifier_list.size();
        for(int i = 0; i < size ; i++) {
            if(cur_identifier_list.get(i).name.equals(name)) return true;
        }
        return false;
    }

    // 判断变量在全部作用域是否定义
    public boolean isDefined_allField(String name) {
        int size = Identifier_table.size();
        for(int i = size-1 ; i>=0 ; i--) {
            Identifier_list tmp = Identifier_table.get(i);
            List<Identifier> list = tmp.list;
            int len = list.size();
            for(int j = 0; j < len ; j++) {
                if(list.get(j).name.equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 判断是否是常量
    public boolean isConstant(String name) {
        int size = Identifier_table.size();
        for(int i = size-1 ; i>=0 ; i--) {
            Identifier_list tmp = Identifier_table.get(i);
            List<Identifier> list = tmp.list;
            int len = list.size();
            for(int j = 0; j < len ; j++) {
                if(list.get(j).name.equals(name)) {
                    return list.get(j).isConst;
                }
            }
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
        int size = Identifier_table.size();
        for(int i = size-1 ; i>=0 ; i--) {
            Identifier_list tmp = Identifier_table.get(i);
            List<Identifier> list = tmp.list;
            int len = list.size();
            for(int j = 0; j < len ; j++) {
                if(list.get(j).name.equals(name)) return list.get(j).register.name;
            }
        }
        return null;
    }

    @Override
    public Object visitCompUnit(compUnitParser.CompUnitContext ctx) {
        if(ctx.decl()!=null) {
            isGlobal = true;
            int n = ctx.decl().size();
            for(int i=0;i<n;i++) {
                visitDecl(ctx.decl(i));
            }
            isGlobal = false;
        }
        visitFuncDef(ctx.funcDef());
        return null;
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
    public Void visitBlock(compUnitParser.BlockContext ctx) {   // '{' (blockItem )* '}'
        // create new Identifier_list and add it into Identifier_table
        Identifier_list cur = new Identifier_list();
        cur_identifier_list = cur.list;
        Identifier_table.add(cur);

        int n = ctx.blockItem().size();
        for(int i=0 ; i<n ; i++) {
            visitBlockItem(ctx.blockItem(i));
        }

        // remove Identifier_list from Identifier_table
        Identifier_table.remove(cur);
        if(Identifier_table.size()>0)
            cur_identifier_list = Identifier_table.get( Identifier_table.size() - 1 ).list;
        else
            cur_identifier_list = null;
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
            visitVarDef(ctx.varDef(i));
        }
        return null;
    }

    @Override
    public String visitVarDef(compUnitParser.VarDefContext ctx) {
        String name = ctx.Ident().getText();
        if(isDefined_curField(name)) System.exit(-1);
        if(isGlobal) {
            int val = 0;
            if(ctx.initVal()!=null) {
                Object ret = visitInitVal(ctx.initVal());
                if(ret instanceof Integer) val = (Integer)ret;
            }
            Register reg = new Register("@"+ name , "i32");
            Identifier identifier = new Identifier(name,reg,false,isGlobal,val);
            cur_identifier_list.add(identifier);
            ans += "@" + name + " = " + "dso_local global i32 " + val + "\n";
        }
        else {
            Register reg = Allocate("i32");
            ans += reg.name + " = alloca i32\n";
            // 加入变量池
            Identifier identifier = new Identifier(name,reg,false,isGlobal);
            cur_identifier_list.add(identifier);
            // 赋值
            if(ctx.initVal()!=null) {
                Object ret = visitInitVal(ctx.initVal());
                if(ret instanceof Register) {
                    Register ret1 = (Register) ret;
                    ans += "store i32 " + ret1.name + " , " + "i32* " + reg.name + "\n" ;
                }
            }
        }
        return null;
    }

    @Override
    public Object visitInitVal(compUnitParser.InitValContext ctx) {
        return visitExp(ctx.exp());
    }

    @Override
    public String visitConstDecl(compUnitParser.ConstDeclContext ctx) {   // constDecl  : 'const' Type constDef (',' constDef )* ';' ;
        this.isConst = true;
        int n = ctx.constDef().size();
        for(int i=0 ; i<n ; i++) {
            visitConstDef(ctx.constDef(i));
        }
        this.isConst = false;
        return null;
    }

    @Override
    public String visitConstDef(compUnitParser.ConstDefContext ctx) {    //  constDef  : Ident '=' constInitVal ;
        int val = 0;
        String name = ctx.Ident().getText();
        if(isDefined_curField(name)) System.exit(-2);
        Object ret = visitConstInitVal(ctx.constInitVal());
        if(ret instanceof Integer) {
            val = (Integer) ret;
        }
        // 加入常量池
        Identifier identifier = new Identifier(name,null,true,isGlobal,val);
        cur_identifier_list.add(identifier);
        return null;
    }

    @Override
    public Object visitConstInitVal(compUnitParser.ConstInitValContext ctx) {
        return visitConstExp(ctx.constExp());
    }

    @Override
    public Object visitConstExp(compUnitParser.ConstExpContext ctx) {
        return visitAddExp(ctx.addExp());
    }

    @Override
    public Object visitStmt(compUnitParser.StmtContext ctx) {
        if(ctx.lVal() != null) {             // LVal '=' Exp ';'
            String name = ctx.lVal().Ident().getText();
            if(!isDefined_allField(name)) System.exit(-3); // 如果变量未定义，报错
            if(isConstant(name)) System.exit(-4);
            String curReg = getRegister(name);
            Object ret = visitExp(ctx.exp());
            String R;
            if(ret instanceof Integer) { R = ((Integer) ret).toString(); }
            else {
                R = ((Register) ret).name;
            }
            ans += "store i32 " + R + " , " + "i32* " + curReg + "\n";
        }
        else if(ctx.Return() != null) {      // 'return' Exp ';'
            Object reg = visitExp(ctx.exp());
            String R;
            if(reg instanceof Integer) { R = ((Integer) reg).toString(); }
            else {
                R = ((Register) reg).name;
            }
            ans += "ret i32 " + R + "\n";
            Allocate("i32");  // return 后要分配一个寄存器占位
            return null;
        }
        else if(ctx.If() != null) {    // 'if' '(' Cond ')' Stmt [ 'else' Stmt ]
            int stmt_len = ctx.stmt().size();
            Object reg_cond = visitCondition(ctx.condition());
            if(reg_cond instanceof Register) {
                Register reg_cond1 = (Register) reg_cond;
                if(reg_cond1.type.equals("i32")) {
                    Register cur_reg = Allocate("i1");
                    ans += cur_reg.name + " = trunc i32 " + reg_cond1.name + " to i1\n";
                    reg_cond1 = cur_reg;
                }
                if(stmt_len == 1) {  // 只有if没有else
                    String block_stmt = newBlock();
                    String block_next = newBlock();
                    ans += "br i1 " + reg_cond1.name + " , label %" + block_stmt + " , label %" + block_next + "\n";
                    ans += "\n" + block_stmt + ":\n";
                    is_break_or_continue = false;

                    visitStmt(ctx.stmt().get(0));

                    if(!is_break_or_continue) {
                        ans += "br label %" + block_next + "\n";
                    }
                    is_break_or_continue = false;
                    ans += "\n" + block_next + ":\n";
                }
                else {   // if ... else ...
                    String block_stmt = newBlock();
                    String block_else = newBlock();
                    String block_next = newBlock();
                    ans += "br i1 " + reg_cond1.name + " , label %" + block_stmt + " , label %" + block_else + "\n";
                    ans += "\n" + block_stmt + ":\n";
                    is_break_or_continue = false;
                    visitStmt(ctx.stmt().get(0));
                    if(!is_break_or_continue)
                        ans += "br label %" + block_next + "\n";
                    is_break_or_continue = false;
                    ans += "\n" + block_else + ":\n";
                    visitStmt(ctx.stmt().get(1));
                    if(!is_break_or_continue)
                        ans += "br label %" + block_next + "\n";
                    is_break_or_continue = false;
                    ans += "\n" + block_next + ":\n";
                }
            }
        }
        else if(ctx.While()!=null) {  // While '(' condition ')' stmt
            String while_head = newBlock();
            ans += "br label %" + while_head + "\n";
            ans += "\n" + while_head + ":\n";
            cur_while_head = while_head;
            Object reg_cond = visitCondition(ctx.condition());
            if(reg_cond instanceof Register) {
                Register reg_cond1 = (Register) reg_cond;
                if (reg_cond1.type.equals("i32")) {
                    Register cur_reg = Allocate("i1");
                    ans += cur_reg.name + " = trunc i32 " + reg_cond1.name + " to i1\n";
                    reg_cond1 = cur_reg;
                }
                String while_begin = newBlock();
                String while_end = newBlock();
                cur_while_end = while_end;
                ans += "br i1 " + reg_cond1.name + " , label %" + while_begin + " , label %" + while_end + "\n";
                ans += "\n" + while_begin + ":\n";
                visitStmt(ctx.stmt().get(0));
                ans += "br label %" + while_head + "\n";
                ans += "\n" + while_end + ":\n";
            }
        }
        else if(ctx.Continue() != null) {      // Continue
            is_break_or_continue = true;
            ans += "br label %" + cur_while_head + "\n";
            return 1;
        }
        else if(ctx.Break() != null) {        // break
            is_break_or_continue = true;
            ans += "br label %" + cur_while_end + "\n";
            return 1;
        }
        else if(ctx.block() != null) {         // Block
            visitBlock(ctx.block());
        }
        else if(ctx.exp()!=null) {     // exp
            visitExp(ctx.exp());
        }
        return null;
    }

    @Override
    public Object visitCondition(compUnitParser.ConditionContext ctx) {
        return visitLorExp(ctx.lorExp());
    }

    @Override
    public Object visitLorExp(compUnitParser.LorExpContext ctx) {
        if(ctx.lorExp() != null) {    // LOrExp '||' LAndExp
            Object l = visitLorExp(ctx.lorExp());
            Object r = visitLandExp(ctx.landExp());
            String L,R;
            if( l instanceof Integer) {
                Register reg = Allocate("i1");
                ans += reg.name + " = " + "icmp " + "ne" + " i32 " + ((Integer) l).toString() + " , " +  "0" + "\n";
                L = reg.name;
            }
            else {
                L = ((Register) l).name;
            }
            if(r instanceof Integer) {
                Register reg = Allocate("i1");
                ans += reg.name + " = " + "icmp " + "ne" + " i32 " + ((Integer) r).toString() + " , " +  "0" + "\n";
                R = reg.name;
            }
            else {
                R = ((Register) r).name;
            }
            Register cur_reg = Allocate("i1");
            ans += cur_reg.name + " = " + "or " + "i1 " + L + " , " + R + "\n";
            return cur_reg;
        }
        else {    // landExp
            return visitLandExp(ctx.landExp());
        }
    }

    @Override
    public Object visitLandExp(compUnitParser.LandExpContext ctx) {
        if(ctx.landExp() != null) {      // LAndExp '&&' EqExp
            Object l = visitLandExp(ctx.landExp());
            Object r = visitEqExp(ctx.eqExp());
            String L , R;
            if(l instanceof Integer) {
                Register reg = Allocate("i1");
                ans += reg.name + " = " + "icmp " + "ne" + " i32 " + ((Integer) l).toString() + " , " +  "0" + "\n";
                L = reg.name;
            }
            else {
                L = ((Register) l).name;
            }
            if(r instanceof Integer) {
                Register reg = Allocate("i1");
                ans += reg.name + " = " + "icmp " + "ne" + " i32 " + ((Integer) r).toString() + " , " +  "0" + "\n";
                R = reg.name;
            }
            else {
                R = ((Register) r).name;
            }
            Register cur_reg = Allocate("i1");
            ans += cur_reg.name + " = " + "and " + "i1 " + L + " , " + R + "\n";
            return cur_reg;
        }
        else {   // eqExp
            return visitEqExp(ctx.eqExp());
        }
    }

    @Override
    public Object visitEqExp(compUnitParser.EqExpContext ctx) {
        if(ctx.eqExp() != null) {    // EqExp ('==' | '!=') RelExp
            Object l = visitEqExp(ctx.eqExp());
            Object r = visitRelExp(ctx.relExp());
            String L,R;
            if(l instanceof Integer)  { L = ((Integer) l).toString(); }
            else {
                Register l1 = (Register) l;
                if(l1.type.equals("i1")) {
                    Register temp1 = Allocate("i32");
                    ans += temp1.name + " = " + "zext i1 " + l1.name + " to i32\n";
                    l1 = temp1;
                }
                L = l1.name;
            }
            if(r instanceof Integer) {  R = ((Integer) r).toString();  }
            else {
                Register r1 = (Register) r;
                if(r1.type.equals("i1")) {
                    Register temp2 = Allocate("i32");
                    ans += temp2.name + " = " + "zext i1 " + r1.name + " to i32\n";
                    r1 = temp2;
                }
                R = r1.name;
            }
            Register cur_reg = Allocate("i1");
            ans += cur_reg.name + " = " + "icmp " + getOp(ctx.Equal().getText()) + " i32 " + L + " , " + R + "\n";
            return cur_reg;
        }
        else {
            return visitRelExp(ctx.relExp());
        }
    }

    @Override
    public Object visitRelExp(compUnitParser.RelExpContext ctx) {
        if(ctx.relExp() != null) {   // RelExp ('<' | '>' | '<=' | '>=') AddExp
            Object l = visitRelExp(ctx.relExp());
            Object r = visitAddExp(ctx.addExp());
            String L,R;
            if( l instanceof Integer ) L = ((Integer) l).toString();
            else {
                Register l1 = (Register) l ;
                if(l1.type.equals("i1")) {
                    Register temp1 = Allocate("i32");
                    ans += temp1.name + " = " + "zext i1 " + l1.name + " to i32\n";
                    l1 = temp1;
                }
                L = l1.name;
            }
            if( r instanceof Integer ) R = ((Integer) r).toString();
            else {
                Register r1 = (Register) r ;
                if(r1.type.equals("i1")) {
                    Register temp2 = Allocate("i32");
                    ans += temp2.name + " = " + "zext i1 " + r1.name + " to i32\n";
                    r1 = temp2;
                }
                R = r1.name;
            }
            Register cur_reg = Allocate("i1");
            String cmp = getOp(ctx.Cmp().getText());
            ans += cur_reg.name + " = " + "icmp " + cmp + " i32 " + L + " , " +  R + "\n";
            return cur_reg;
        }
        else {
            return visitAddExp(ctx.addExp());
        }
    }

    @Override
    public Object visitExp(compUnitParser.ExpContext ctx) {
        return visitAddExp(ctx.addExp());
    }

    @Override
    public Object visitAddExp(compUnitParser.AddExpContext ctx) {
        if(isConst || isGlobal) {  // 正在处理常量
            if(ctx.addExp()==null) {
                return visitMulExp(ctx.mulExp());
            }
            else {
                Object l = visitAddExp(ctx.addExp());
                Object r = visitMulExp(ctx.mulExp());
                if(l instanceof Integer && r instanceof Integer) {
                    Integer L = (Integer) l;
                    Integer R = (Integer) r;
                    String Op = ctx.unaryOp().getText();
                    int ret = Calculate( L , R , Op);
                    return ret;
                }
            }
        }
        else {
            if(ctx.addExp()==null) {
                return visitMulExp(ctx.mulExp());
            }
            else {
                Object l = visitAddExp(ctx.addExp());
                Object r = visitMulExp(ctx.mulExp());
                Register reg = Allocate("i32");
                String L , R;
                if( l instanceof Register)
                    L = ((Register) l).name;
                else
                    L = ((Integer) l).toString();

                if( r instanceof Register)
                    R = ((Register) r).name;
                else
                    R = ((Integer) r).toString();

                ans += reg.name + " = " + getOp(ctx.unaryOp().getText()) + L + " , " + R + "\n";
                return reg;
            }
        }
        return null;
    }

    @Override
    public Object visitMulExp(compUnitParser.MulExpContext ctx) {
        if(isConst || isGlobal) {  // 常量
            if( ctx.mulExp()==null ) {
                return visitUnaryExp(ctx.unaryExp());
            }
            else {
                Object l = visitMulExp(ctx.mulExp());
                Object r = visitUnaryExp(ctx.unaryExp());
                if(l instanceof Integer && r instanceof Integer) {
                    Integer L = (Integer) l;
                    Integer R = (Integer) r;
                    String Op = ctx.calOp().getText();
                    int ret = Calculate( L , R , Op);
                    return ret;
                }
            }
        }
        else {
            if( ctx.mulExp()==null ) {
                return visitUnaryExp(ctx.unaryExp());
            }
            else {
                Object l = visitMulExp(ctx.mulExp());
                Object r = visitUnaryExp(ctx.unaryExp());
                Register reg = Allocate("i32");
                String L,R;
                if(l instanceof Integer)  L = ((Integer) l).toString();
                else L = ((Register) l).name;
                if(r instanceof Integer)  R = ((Integer) r).toString();
                else R = ((Register) r).name;
                ans += reg.name + " = " + getOp(ctx.calOp().getText()) + L + " , " + R + "\n";
                return reg ;
            }
        }
        return null;
    }

    @Override
    public Object visitUnaryExp(compUnitParser.UnaryExpContext ctx) {
        if(isConst || isGlobal) {  // 常量
            if( ctx.unaryExp()==null ) {
                return visitPrimaryExp(ctx.primaryExp());
            }
            else {  // UnaryOp UnaryExp
                Object r = visitUnaryExp(ctx.unaryExp());
                String Op = getOp(ctx.unaryOp().getText());
                if( r instanceof Integer) {
                    Integer R = (Integer) r;
                    if(Op.equals("-")) R = -R;
                    return R;
                }
            }
        }
        else {   // 变量
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
                        Object reg = visitExp(ctx.funcRParams().exp(0));
                        if(reg instanceof Register) {
                            Register REG = (Register) reg;
                            ans += "call void @putint(i32 " + REG.name + ")\n";
                        }
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
                        Object reg = visitExp(ctx.funcRParams().exp(0));
                        if( reg instanceof Register ) {
                            Register REG = (Register) reg;
                            ans += "call void @putch(i32 " + REG.name + ")\n";
                        }
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
                    Object r = visitUnaryExp(ctx.unaryExp());
                    if(r instanceof Register) {
                        Register R = (Register) r;
                        if(R.type.equals("i1")) {
                            Register temp = Allocate("i32");
                            ans += temp.name + " = " + "zext i1 " + R.name + " to i32\n";
                            R = temp;
                        }
                        Register reg = Allocate();
                        if(ctx.unaryOp().getText().equals("!")) {
                            reg.type = "i1";
                        }
                        else {
                            reg.type = "i32";
                        }
                        ans += reg.name + " = " + getOp(ctx.unaryOp().getText()) + l + " , " + R.name + "\n";
                        return reg;
                    }
                }
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
    public Object visitLVal(compUnitParser.LValContext ctx) {
        String name = ctx.Ident().getText();
        if(!isDefined_allField(name)) {
            System.exit(-10);
        }
        if(!isConstant(name) && ( isConst || isGlobal)) {
            System.exit(-11);
        }
        if(isConstant(name)) {  // 常量返回int
            int val = getValue_byName(name);
            return val;
        }
        else {  // 变量返回寄存器
            String reg = getRegister(name);
            Register newReg = Allocate("i32");
            ans += newReg.name + " = load i32, i32* " + reg + "\n";
            return newReg;
        }

    }
    // primaryExp   : '(' exp ')' | lVal | Number ;
    @Override
    public Object visitPrimaryExp(compUnitParser.PrimaryExpContext ctx) {
        if(isConst || isGlobal) { // 常量
            if(ctx.exp() == null) {
                if(ctx.lVal() == null) {  // number
                    int number = Integer.parseInt( getNumber(ctx.Number().getText()) );
                    return number;
                }
                else {
                    String ret = ctx.lVal().Ident().getText(); // 变量名
                    if(!isConstant(ret)) System.exit(-77); // 检查是否是常量
                    // 需要根据常量名获取值
                    int val = getValue_byName(ret);
                    return val;
                }
            }
            else {
                return visitExp(ctx.exp());
            }
        }
        else {  // 变量
            if(ctx.exp() == null) {
                if(ctx.lVal()==null) {  // Number
//                    Register reg = Allocate("i32");
//                    ans += reg.name + " = alloca i32\n";
//                    ans += "store i32 " + getNumber(ctx.Number().getText()) + " , " + "i32* " + reg.name + "\n";
//                    Register temp = Allocate("i32");
//                    ans += temp.name + " = load i32, i32* " + reg.name + "\n";
//                    return temp;
                    int number = Integer.parseInt( getNumber(ctx.Number().getText()) );
                    return number;
                }
                else {
                    return visitLVal(ctx.lVal());
                }
            }
            else
                return visitExp(ctx.exp());
        }
    }

}
