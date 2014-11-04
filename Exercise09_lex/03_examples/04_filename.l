/**
** Here is a more complex example.It recognizes several tokens.
** In addition, it uses a declaration in the definitions SECTION that it
** reuses in the rules SECTION.
*/

%{
#include <stdio.h>
%}

START_LETTER  [a-zA-Z]

%%
{START_LETTER}[a-zA-Z0-9]*     printf("WORD ");
[a-zA-Z0-9\/.-]+        printf("FILENAME ");
\"                      printf("QUOTE ");
\{                      printf("OBRACE ");
\}                      printf("EBRACE ");
;                       printf("SEMICOLON ");
\n                      printf("\n");
[ \t]+                  /* ignore whitespace */;


%%
int yywrap(){ return 1;}
int main(){ yylex();
}
