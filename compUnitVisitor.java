// Generated from compUnit.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link compUnitParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface compUnitVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link compUnitParser#compUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompUnit(compUnitParser.CompUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(compUnitParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl(compUnitParser.DeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#constDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDecl(compUnitParser.ConstDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#constDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstDef(compUnitParser.ConstDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#constInitVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstInitVal(compUnitParser.ConstInitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#constExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstExp(compUnitParser.ConstExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(compUnitParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(compUnitParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#initVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitVal(compUnitParser.InitValContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(compUnitParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#blockItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockItem(compUnitParser.BlockItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(compUnitParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(compUnitParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#lVal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLVal(compUnitParser.LValContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#primaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExp(compUnitParser.PrimaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#addExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddExp(compUnitParser.AddExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#mulExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulExp(compUnitParser.MulExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#unaryExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExp(compUnitParser.UnaryExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#funcRParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncRParams(compUnitParser.FuncRParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#unaryOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryOp(compUnitParser.UnaryOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#calOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalOp(compUnitParser.CalOpContext ctx);
}