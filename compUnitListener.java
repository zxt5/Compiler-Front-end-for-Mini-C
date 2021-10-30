// Generated from compUnit.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link compUnitParser}.
 */
public interface compUnitListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link compUnitParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompUnit(compUnitParser.CompUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#compUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompUnit(compUnitParser.CompUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(compUnitParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(compUnitParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(compUnitParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(compUnitParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstDecl(compUnitParser.ConstDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#constDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstDecl(compUnitParser.ConstDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#constDef}.
	 * @param ctx the parse tree
	 */
	void enterConstDef(compUnitParser.ConstDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#constDef}.
	 * @param ctx the parse tree
	 */
	void exitConstDef(compUnitParser.ConstDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void enterConstInitVal(compUnitParser.ConstInitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#constInitVal}.
	 * @param ctx the parse tree
	 */
	void exitConstInitVal(compUnitParser.ConstInitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#constExp}.
	 * @param ctx the parse tree
	 */
	void enterConstExp(compUnitParser.ConstExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#constExp}.
	 * @param ctx the parse tree
	 */
	void exitConstExp(compUnitParser.ConstExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(compUnitParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(compUnitParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(compUnitParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(compUnitParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#initVal}.
	 * @param ctx the parse tree
	 */
	void enterInitVal(compUnitParser.InitValContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#initVal}.
	 * @param ctx the parse tree
	 */
	void exitInitVal(compUnitParser.InitValContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(compUnitParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(compUnitParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void enterBlockItem(compUnitParser.BlockItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#blockItem}.
	 * @param ctx the parse tree
	 */
	void exitBlockItem(compUnitParser.BlockItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(compUnitParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(compUnitParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(compUnitParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(compUnitParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#lVal}.
	 * @param ctx the parse tree
	 */
	void enterLVal(compUnitParser.LValContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#lVal}.
	 * @param ctx the parse tree
	 */
	void exitLVal(compUnitParser.LValContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(compUnitParser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(compUnitParser.PrimaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#addExp}.
	 * @param ctx the parse tree
	 */
	void enterAddExp(compUnitParser.AddExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#addExp}.
	 * @param ctx the parse tree
	 */
	void exitAddExp(compUnitParser.AddExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void enterMulExp(compUnitParser.MulExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#mulExp}.
	 * @param ctx the parse tree
	 */
	void exitMulExp(compUnitParser.MulExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(compUnitParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(compUnitParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncRParams(compUnitParser.FuncRParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#funcRParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncRParams(compUnitParser.FuncRParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOp(compUnitParser.UnaryOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#unaryOp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOp(compUnitParser.UnaryOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link compUnitParser#calOp}.
	 * @param ctx the parse tree
	 */
	void enterCalOp(compUnitParser.CalOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#calOp}.
	 * @param ctx the parse tree
	 */
	void exitCalOp(compUnitParser.CalOpContext ctx);
}