// Generated from RPN.g4 by ANTLR 4.4

    import java.util.Stack;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RPNParser}.
 */
public interface RPNListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RPNParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(@NotNull RPNParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(@NotNull RPNParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPNParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull RPNParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull RPNParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPNParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull RPNParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull RPNParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPNParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void enterBin_op(@NotNull RPNParser.Bin_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#bin_op}.
	 * @param ctx the parse tree
	 */
	void exitBin_op(@NotNull RPNParser.Bin_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link RPNParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull RPNParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link RPNParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull RPNParser.LiteralContext ctx);
}