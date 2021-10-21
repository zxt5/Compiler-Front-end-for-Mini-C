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
	 * Visit a parse tree produced by {@link compUnitParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(compUnitParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link compUnitParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(compUnitParser.StmtContext ctx);
}