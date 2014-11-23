// Generated from XmlToJsonParser.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XmlToJsonParser}.
 */
public interface XmlToJsonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XmlToJsonParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(@NotNull XmlToJsonParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlToJsonParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(@NotNull XmlToJsonParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlToJsonParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(@NotNull XmlToJsonParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlToJsonParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(@NotNull XmlToJsonParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlToJsonParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull XmlToJsonParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlToJsonParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull XmlToJsonParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlToJsonParser#xml_dec}.
	 * @param ctx the parse tree
	 */
	void enterXml_dec(@NotNull XmlToJsonParser.Xml_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlToJsonParser#xml_dec}.
	 * @param ctx the parse tree
	 */
	void exitXml_dec(@NotNull XmlToJsonParser.Xml_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link XmlToJsonParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull XmlToJsonParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XmlToJsonParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull XmlToJsonParser.AttributeContext ctx);
}