// Generated from SimpleBoolean.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleBooleanParser}.
 */
public interface SimpleBooleanListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(@NotNull SimpleBooleanParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(@NotNull SimpleBooleanParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull SimpleBooleanParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull SimpleBooleanParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#notexpression}.
	 * @param ctx the parse tree
	 */
	void enterNotexpression(@NotNull SimpleBooleanParser.NotexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#notexpression}.
	 * @param ctx the parse tree
	 */
	void exitNotexpression(@NotNull SimpleBooleanParser.NotexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#andexpression}.
	 * @param ctx the parse tree
	 */
	void enterAndexpression(@NotNull SimpleBooleanParser.AndexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#andexpression}.
	 * @param ctx the parse tree
	 */
	void exitAndexpression(@NotNull SimpleBooleanParser.AndexpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleBooleanParser#orexpression}.
	 * @param ctx the parse tree
	 */
	void enterOrexpression(@NotNull SimpleBooleanParser.OrexpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleBooleanParser#orexpression}.
	 * @param ctx the parse tree
	 */
	void exitOrexpression(@NotNull SimpleBooleanParser.OrexpressionContext ctx);
}