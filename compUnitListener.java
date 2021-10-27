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
	 * Enter a parse tree produced by {@link compUnitParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExp(compUnitParser.PrimaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link compUnitParser#primaryExp}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExp(compUnitParser.PrimaryExpContext ctx);
}