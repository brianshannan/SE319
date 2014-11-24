parser grammar XmlToJsonParser;

options {
    tokenVocab = XmlToJsonLexer;
}

// xml documents might have a declaration and then they have content
start: xml_dec? content;

// xml declaration has an xml declaration open tag, attributes, then a close
xml_dec: XML_DEC_OPEN attribute* XML_DEC_CLOSE;

// content can be an element, text, or a comment, can be multiple
content: (element | text | COMMENT)*;

// <name attrs>content</name> or <name attr/>
element : '<' NAME attribute* '>' content '</' NAME '>'
        | '<' NAME attribute* '/>';

// name="thing"
attribute: NAME '=' ATTR_DATA;
text: TEXT;
