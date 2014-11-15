// Generated from Count.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CountParser}.
 */
public interface CountListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CountParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull CountParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link CountParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull CountParser.StartContext ctx);
}