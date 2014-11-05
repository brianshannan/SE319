%{

#include <stdio.h>

%}

ws                  [ \t]
name_start          [a-zA-Z]
name_char           [a-zA-Z0-9]
name                {name_start}{name_char}*
data                .
attr                ({ws}{name}=\"{data}*\")
empty_elem          <{name}{attr}*\/>
open_elem           <{name}{attr}*>
close_elem          <\/{name}>

%%

{empty_elem}        printf("empty_elem: %s", yytext);

%%

int main() {
    yylex();
}

int yywrap() {
    return 1;
}
