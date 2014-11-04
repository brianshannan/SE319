%{
    #include <stdio.h>

    int stack[100];
    int stack_pos = 0;
%}

ELEM_END <\/[a-zA-Z][a-zA-Z0-9]*>


%%

{ELEM_END} printf("end");

%%

int yywrap(){ return 1;}
int main(){ yylex(); }
