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

//class Constant {
//    String name;
//    Register register;
//    String type;
//
//    public Constant(String name,Register register) {
//        this.name = name;
//        this.register = register;
//    }
//}



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
    public boolean isGlobal = false;
    public String cur_while_head;
    public String cur_while_end;
//    List<Identifier> Identifier_list = new ArrayList<>();  // 变量表
//    List<Constant> Constant_list = new ArrayList<>();      // 常量表
//    Identifier_list cur_identifier_list = null;
    List<Identifier> cur_identifier_list = null;
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
            int len = list.size();
            for(int j = 0; j < len ; j++) {
                if(list.get(j).name.equals(name)) {
                    return list.get(i).value;
                }
            }
        }
        return -1;
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
//            @a = dso_local global i32 5
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
    public String visitConstDecl(compUnitParser.ConstDeclContext ctx) {
        this.isConst = true;
        int n = ctx.constDef().size();
        for(int i=0 ; i<n ; i++) {
//            String name = ctx.constDef(i).getText();
            visitConstDef(ctx.constDef(i));
        }
        this.isConst = false;
        return null;
    }

    @Override
    public String visitConstDef(compUnitParser.ConstDefContext ctx) {
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
            if(ret instanceof Register) {
                Register ret1 = (Register) ret;
                ans += "store i32 " + ret1.name + " , " + "i32* " + curReg + "\n";
            }
        }
        else if(ctx.Return() != null) {      // 'return' Exp ';'
            Object reg = visitExp(ctx.exp());
            if(reg instanceof Register) {
                Register reg1 = (Register) reg;
                ans += "ret " + reg1.type + " "+ reg1.name + "\n";
            }
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
                    Object ret = visitStmt(ctx.stmt().get(0));
                    if(ret != null) {
                        ans += "br label %" + block_next + "\n\n";
                    }
                    else return null;

                    ans += "\n" + block_next + ":\n";
                }
                else {   // if ... else ...
                    String block_stmt = newBlock();
                    String block_else = newBlock();
                    String block_next = newBlock();
                    ans += "br i1 " + reg_cond1.name + " , label %" + block_stmt + " , label %" + block_else + "\n";
                    ans += block_stmt + ":\n";
                    visitStmt(ctx.stmt().get(0));
                    ans += "br label %" + block_next + "\n";
                    ans += "\n" + block_else + ":\n";
                    Object ret = visitStmt(ctx.stmt().get(1));
                    if(ret != null)
                        ans += "br label %" + block_next + "\n";
                    else return null;
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
                ans += "\n" + while_head + ":\n";
            }
        }
        else if(ctx.Continue() != null) {      // Continue
            ans += "br label %" + cur_while_head + "\n";
            return 1;
        }
        else if(ctx.Break() != null) {        // break
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
            Object lor_reg = visitLorExp(ctx.lorExp());
            Object land_reg = visitLandExp(ctx.landExp());
            if( lor_reg instanceof Register && land_reg instanceof Register ) {
                Register lor_reg1 = (Register) lor_reg;
                Register land_reg1 = (Register) land_reg;
                Register cur_reg = Allocate("i1");
                ans += cur_reg.name + " = " + "or " + "i1 " + lor_reg1.name + " , " + land_reg1.name + "\n";
                return cur_reg;
            }

        }
        else {
            return visitLandExp(ctx.landExp());
        }
        return null;
    }

    @Override
    public Object visitLandExp(compUnitParser.LandExpContext ctx) {
        if(ctx.landExp() != null) {      // LAndExp '&&' EqExp
            Object land_reg = visitLandExp(ctx.landExp());
            Object eq_reg = visitEqExp(ctx.eqExp());
            if(land_reg instanceof Register && eq_reg instanceof Register) {
                Register land_reg1 = (Register) land_reg;
                Register eq_reg1 = (Register) eq_reg;
                Register cur_reg = Allocate("i1");
                ans += cur_reg.name + " = " + "and " + "i1 " + land_reg1.name + " , " + eq_reg1.name + "\n";
                return cur_reg;
            }
        }
        else {
            return visitEqExp(ctx.eqExp());
        }
        return null;
    }

    @Override
    public Object visitEqExp(compUnitParser.EqExpContext ctx) {
        if(ctx.eqExp() != null) {    // EqExp ('==' | '!=') RelExp
            Object eq_reg = visitEqExp(ctx.eqExp());
            Object rel_reg = visitRelExp(ctx.relExp());
            if(eq_reg instanceof Register && rel_reg instanceof Register) {
                Register eq_reg1 = (Register) eq_reg;
                Register rel_reg1 = (Register) rel_reg;
                Register cur_reg = Allocate("i1");
                //            %14 = icmp eq i32 %13, 10
                if(eq_reg1.type.equals("i1")) {
                    Register temp1 = Allocate("i32");
                    ans += temp1.name + " = " + "zext i1 " + eq_reg1.name + " to i32\n";
                    eq_reg1 = temp1;
                }
                if(rel_reg1.type.equals("i1")) {
                    Register temp2 = Allocate("i32");
                    ans += temp2.name + " = " + "zext i1 " + rel_reg1.name + " to i32\n";
                    rel_reg1 = temp2;
                }
                ans += cur_reg.name + " = " + "icmp " + getOp(ctx.Equal().getText()) + " i32 " + eq_reg1.name + " , " + rel_reg1.name + "\n";
                return cur_reg;
            }
        }
        else {
            return visitRelExp(ctx.relExp());
        }
        return null;
    }

    @Override
    public Object visitRelExp(compUnitParser.RelExpContext ctx) {
        if(ctx.relExp() != null) {   // RelExp ('<' | '>' | '<=' | '>=') AddExp
            Object rel_reg = visitRelExp(ctx.relExp());
            Object add_reg = visitAddExp(ctx.addExp());
            String L,R;
            if(rel_reg instanceof Register ) {
                Register rel_reg1 = (Register) rel_reg;
                if(rel_reg1.type.equals("i1")) {
                    Register temp1 = Allocate("i32");
                    ans += temp1.name + " = " + "zext i1 " + rel_reg1.name + " to i32\n";
                    rel_reg1 = temp1;
                }
                L = rel_reg1.name;
            }
            else {
                Integer rel_reg1 = (Integer) rel_reg;
                L = rel_reg1.toString();
            }

            if(add_reg instanceof Register) {
                Register add_reg1 = (Register) add_reg;
                if(add_reg1.type.equals("i1")) {
                    Register temp2 = Allocate("i32");
                    ans += temp2.name + " = " + "zext i1 " + add_reg1.name + " to i32\n";
                    add_reg1 = temp2;
                }
                R = add_reg1.name;
            }
            else {
                Integer add_reg1 = (Integer) add_reg;
                R = add_reg1.toString();
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
        if(isConst || isGlobal) {  // 正在给常量赋值
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
        else {   // 正在给变量赋值
            if(ctx.addExp()==null) {
                return visitMulExp(ctx.mulExp());
            }
            else {
                Object l = visitAddExp(ctx.addExp());
                Object r = visitMulExp(ctx.mulExp());
                Register reg = Allocate("i32");
                if(l instanceof Register && r instanceof Register) {
                    Register l1 = (Register) l;
                    Register r1 = (Register) r;
                    ans += reg.name + " = " + getOp(ctx.unaryOp().getText()) + l1.name + " , " + r1.name + "\n";
                    return reg;
                }
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
//                    System.out.println(ret);
                    return ret;
                }
            }
        }
        else {  // 变量
            if( ctx.mulExp()==null ) {
                return visitUnaryExp(ctx.unaryExp());
            }
            else {
                Object l = visitMulExp(ctx.mulExp());
                Object r = visitUnaryExp(ctx.unaryExp());
                Register reg = Allocate("i32");
                if(l instanceof Register && r instanceof Register) {
                    Register L = (Register) l;
                    Register R = (Register) r;
                    ans += reg.name + " = " + getOp(ctx.calOp().getText()) + L.name + " , " + R.name + "\n";
                    return reg;
                }
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
                            r = temp;
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
                    Register reg = Allocate("i32");
                    ans += reg.name + " = alloca i32\n";
//                ans += reg.name + " = load i32, i32 " + getNumber(ctx.Number().getText()) + "\n";
                    ans += "store i32 " + getNumber(ctx.Number().getText()) + " , " + "i32* " + reg.name + "\n";
                    Register temp = Allocate("i32");
                    ans += temp.name + " = load i32, i32* " + reg.name + "\n";
                    return temp;
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
