parser grammar XmlToJsonParser;

options {
    tokenVocab = XmlToJsonLexer;
}

// xml documents might have a declaration and then they have content
start: xml_dec? content;

// xml declaration has an xml declaration open tag, attributes, then a close
xml_dec: XML_DEC_OPEN attribute* XML_DEC_CLOSE;

// content can be an element, text, or a comment, can be multiple
content: (element | TEXT | COMMENT)*;

// <name attrs>content</name> or <name attr/>
element : XML_BEG_OPEN NAME attribute* XML_CLOSE content XML_END_OPEN NAME XML_CLOSE
        | XML_BEG_OPEN NAME attribute* XML_EMPTY_CLOSE;

// name="thing"
attribute: NAME EQUALS ATTR_DATA;
