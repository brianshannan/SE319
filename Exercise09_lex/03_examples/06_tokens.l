/*
** This shows how a typical parser may use the analyzer.
** Here we extend what the analyzer does. Not only does it return the 
** TOKEN TYPE (like NUMBER, STATE etc), it also returns a token value
** which is printed in main
**
*/
%{
#include <stdio.h>
#include "y.tab.h"
int yylval;
%}
%%
[0-9]+                  yylval=atoi(yytext); return NUMBER;
heat                    return TOKHEAT;
on|off                  yylval=!strcmp(yytext,"on"); return STATE;
target                  return TOKTARGET;
temperature             return TOKTEMPERATURE;
\n                      /* ignore end of line */;
[ \t]+                  /* ignore whitespace */;
%%
int yywrap(){
return 1;}
int main(){ 
 while(yywrap()) { 
   int state = yylex();
   printf("TOKEN TYPE is %d, TOKEN VALUE is %s\n", state, yytext);
 }
}
