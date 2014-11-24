package converters;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.antlr.v4.runtime.misc.NotNull;

public class XmlToJsonConverter extends XmlToJsonParserBaseListener {

    Map<String, Object> json;
    Stack<Map<String, Object>> elemStack = new Stack<Map<String, Object>>();

    public String getResult() {
        // TODO
        return json.toString();
    }

    @Override
    public void enterStart(@NotNull XmlToJsonParser.StartContext ctx) {
        System.out.println(ctx.getText());
        json = new HashMap<String, Object>();
    }


    @Override
    public void enterElement(@NotNull XmlToJsonParser.ElementContext ctx) {
        System.out.println(ctx.getText());
        System.out.println(ctx.NAME());
    }

}
