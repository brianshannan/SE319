package converters;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.TerminalNode;

public class XmlToJsonConverter extends XmlToJsonParserBaseListener {

    public Map<String, Object> json;
    public Stack<ElementContainer> elemStack = new Stack<ElementContainer>();

    public String getResult() {
        // TODO
        return json.toString();
    }

    @Override
    public void enterStart(@NotNull XmlToJsonParser.StartContext ctx) {
        json = new HashMap<String, Object>();
        ElementContainer ec = new ElementContainer();
        json.put(null, ec);
        elemStack.push(ec);
    }


    @Override
    public void enterElement(@NotNull XmlToJsonParser.ElementContext ctx) {
        List<TerminalNode> names = ctx.NAME();
        if(names.size() != 2) {
            throw new IllegalArgumentException("Improper number of element tags: " + names);
        }
        if(!names.get(0).getText().equals(names.get(1).getText())) {
            throw new IllegalArgumentException("Unmatched tags: " + names.get(0) + " and " + names.get(1));
        }

        ElementContainer ec = new ElementContainer();
        elemStack.peek().addElem(ctx.NAME(0).getText(), ec);
        elemStack.push(ec);
    }

    @Override
    public void exitText(@NotNull XmlToJsonParser.TextContext ctx) {
        elemStack.pop();
    }

    @Override
    public void enterAttribute(@NotNull XmlToJsonParser.AttributeContext ctx) {
        elemStack.peek().addAttr(ctx.NAME().getText(), ctx.ATTR_DATA().getText());
    }

    @Override
    public void enterText(@NotNull XmlToJsonParser.TextContext ctx) {
        elemStack.peek().addText(ctx.TEXT().getText());
    }
}
