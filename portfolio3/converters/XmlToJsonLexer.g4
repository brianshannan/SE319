lexer grammar XmlToJsonLexer;

fragment WS             : [ \t\r\n];
MULT_WS                 : WS+ -> skip;

COMMENT                 : '<!--' .*? '-->';

// When an element is started, enter it
XML_DEC_OPEN            : '<?xml' -> pushMode(IN_ELEMENT);
XML_BEG_OPEN            : '<' -> pushMode(IN_ELEMENT);
XML_END_OPEN            : '</' -> pushMode(IN_ELEMENT);

// TODO Handle escape codes and such?
TEXT                    : ~[&<>]+;

// Use a mode to preven TEXT from matching everything when it shouldn't,
// represents being in an element
mode IN_ELEMENT;
ELEM_WS                 : WS+ -> skip;

// When the element is closed, exit
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
