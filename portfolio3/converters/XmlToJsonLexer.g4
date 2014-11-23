lexer grammar XmlToJsonLexer;

WS                      : [ \t\r\n]+ -> skip;

XML_DEC_OPEN            : '<?xml' -> pushMode(IN_ELEMENT);
XML_BEG_OPEN            : '<' -> pushMode(IN_ELEMENT);
XML_END_OPEN            : '</' -> pushMode(IN_ELEMENT);

TEXT                    : ~[&<>]+;

mode IN_ELEMENT;

XML_DEC_CLOSE           : '?>' -> popMode;
XML_CLOSE               : '>' -> popMode;
XML_EMPTY_CLOSE         : '/>' -> popMode;

fragment NAME_START     : [a-zA-Z];
fragment NAME_CHAR      : [a-zA-Z0-9._-];
NAME                    : NAME_START NAME_CHAR*;

// Can have opposite quote in attribute data
ATTR_DATA               : '"' ~[&<>"]* '"'
                        | '\'' ~[&<>']* '\'';
EQUALS                  : '=';
COMMENT                 : '<!--' .*? '-->';
