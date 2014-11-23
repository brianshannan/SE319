package converters;

import org.antlr.v4.runtime.misc.NotNull;

public class XmlToJsonConverter extends XmlToJsonParserBaseListener {

    private String converted;

    public String getResult() {
        return converted;
    }

    @Override
    public void enterStart(@NotNull XmlToJsonParser.StartContext ctx) {
        System.out.println(ctx.getText());
    }

    @Override
    public void enterElement(@NotNull XmlToJsonParser.ElementContext ctx) {
        System.out.println(ctx.getText());
        System.out.println(ctx.NAME());

        System.out.println(ctx.NAME(0));
    }
}
