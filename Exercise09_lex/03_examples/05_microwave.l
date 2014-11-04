/*
** This shows how a typical parser may use the analyzer.
** Since we have a "RETURN statement" in the actions part of the rules,
** the analyzer stops after recognizing a word. We have a loop in the
** main to continue analyzing,
**
*/

%{
#include <stdio.h>
#include "y.tab.h"
%}
%%
[0-9]+                  return NUMBER;
heat                    return TOKHEAT;
on|off                  return STATE;
target                  return TOKTARGET;
temperature             return TOKTEMPERATURE;
\n                      /* ignore end of line */;
[ \t]+                  /* ignore whitespace */;
%%
int yywrap(){ return 1;}
int main(){ 
 while(yywrap()) { 
   int state = yylex();
   printf("State %d\n", state);
 }
}
