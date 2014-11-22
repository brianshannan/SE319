package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import converters.XmlToJson;


public class XmlToJsonTest {
    XmlToJson xtj;

    @Before
    public void setUp() {
        xtj = new XmlToJson();
    }

    @Test
    public void basicFormats() {
        String[] input = new String[] {
                "<a/>",
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
            Assert.assertEquals(expected[i], xtj.convertXmlToJson(input[i]));
        }
    }
}
