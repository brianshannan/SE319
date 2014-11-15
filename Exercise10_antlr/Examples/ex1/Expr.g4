/**
 * This example parses complex expressions in multiple lines 
 * 
 */
grammar Expr;		

// PARSER RULES
start:	(expr NEWLINE)* ;
expr:	expr ('*'|'/') expr
    |	expr ('+'|'-') expr
    |	INT
    |	'(' expr ')'
    ;

// LEXER RULES
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
