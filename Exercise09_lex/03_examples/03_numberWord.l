/*
** This is another simple example.
** This is used to detect numbers and words.
** Note that yytext is used to print what was matched and yyleng is used
** to number of characters in the matched string
*/

%{
#include <stdio.h>
%}

%%
[0123456789]+		printf("NUMBER %s\n", yytext);
[a-zA-Z][a-zA-Z0-9]*	printf("WORD %s\n", yytext);
%%

int yywrap(){ return 1;}
int main(){ yylex(); }
