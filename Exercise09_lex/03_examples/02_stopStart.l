
/* This is a more complicated example!
** The rules section matches the strings stop and start.
** If those words are found then the analyzer prints the appropriate
** message as in the rule.
** Otherwise, it just reprints other input as is.
*/ 
%{
#include <stdio.h>
%}

%%
stop	printf("Stop command received\n");
start	printf("Start command received\n");
%%

int yywrap(){ return 1;}
int main(){ yylex(); }
