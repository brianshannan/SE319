grammar XmlToJson;

// Lexer rules
WS                      : [ \t\r\n]+ -> skip;
fragment TEXT_CHAR      : [^&<>];
TEXT                    : TEXT_CHAR+;

XML_DEC_OPEN            : '<?xml';
XML_DEC_CLOSE           : '?>';

XML_BEG_OPEN            : '<';
XML_END_OPEN            : '</';
XML_CLOSE               : '>';
XML_EMPTY_CLOSE         : '/>';

fragment NAME_START     : [a-zA-Z];
fragment NAME_CHAR      : [a-zA-Z0-9];
NAME                    : NAME_START NAME_CHAR*;

// Can have opposite quote in attribute data
ATTR_DATA               : '"' [^&<>"] '"'
                        | '\'' [^&<>'] '\'';
EQUALS                  : '=';

COMMENT                 : '<!--' .*? '-->';


// Parser rules

// xml documents might have a declaration and then they have content
start: xml_dec? content;

// xml declaration has an xml declaration open tag, attributes, then a close
xml_dec: XML_DEC_OPEN attribute* XML_DEC_CLOSE;

// content can be an element, text, or a comment, can be multiple
content: (element | TEXT | COMMENT)*;

// <name attrs>content</name> or <name attr/>
element : XML_BEG_OPEN NAME attribute* XML_CLOSE content XML_END_OPEN NAME XML_CLOSE
        | XML_BEG_OPEN NAME attribute* XML_EMPTY_CLOSE;

// FIX
attribute: NAME EQUALS ATTR_DATA;
