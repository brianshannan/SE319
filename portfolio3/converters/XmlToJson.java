package converters;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import converters.XmlToJsonParser.StartContext;

public class XmlToJson {
    private XmlToJsonLexer lexer;
    private XmlToJsonParser parser;
    
    public XmlToJson(String xml) {
        this.lexer = new XmlToJsonLexer(new ANTLRInputStream(xml));
        this.parser = new XmlToJsonParser(new CommonTokenStream(lexer));
        this.parser.setBuildParseTree(true);
    }

    public String convertXmlToJson() {
        StartContext tree = parser.start();

        return null;
    }
}
