package tests;

import org.junit.Assert;
import org.junit.Test;

import converters.XmlToJson;


public class XmlToJsonTest {

    @Test
    public void complicated() {
        XmlToJson xtj = new XmlToJson(
                "<?xml version='1.0' ?><people one='two'><student thing='something'><name>John</name><course>Computer Technology</course><semester>6</semester><scheme>E</scheme></student><student><name>Foo</name><course>Industrial Electronics</course><semester>6</semester><scheme>E</scheme></student></people>");
        xtj.convertXmlToJson();
    }

    @Test
    public void basicFormats() {
        XmlToJson xtj;
        String[] input = new String[] {
                "<ab/>",
                "<a></a>",
                "<a>b</a>",
                "<a b='c'/>",
                "<a b='c'></a>",
                "<a b='c'>d</a>",
                "<a><b>c</b><d>e</d></a>",
                "<a><b>c</b><b>d</b></a>",
                "<a>b<c>d</c></a>"
        };

        String[] expected = new String[] {
                "{'a': null}",
                "{'a': null}",
                "{'a': {'#text': 'b'}}",
                "{'a': {'@b': 'c'}}",
                "{'a': {'@b': 'c'}}",
                "{'a': {'@b': 'c', '#text': 'd'}}",
                "{'a': {'b': {'#text': 'c'}, 'd': {'#text': 'e'}}",
                "{'a': {'b': [{'#text': 'c'}, {'#text': 'd'}]}}",
                "{'a': {'#text': 'b', 'c': {'#text': d'}}}"
        };

        for(int i = 0; i < input.length; i++) {
            xtj = new XmlToJson(input[i]);
            Assert.assertEquals(expected[i], xtj.convertXmlToJson());
        }
    }
}
