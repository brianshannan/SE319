%{

#include <stdio.h>
#include "y.tab.h"

extern int yylex();
extern FILE *yyin;
// TODO
//      Format print stuff so it looks right/better

%}

ws                              [ \t]
nl                              (\r|\n|\r\n)
quot                            [\'\"]
name_start                      [a-zA-Z_]
name_char                       [a-zA-Z0-9_.:]
name                            {name_start}{name_char}*
data                            [^<>&]
attr                            {name}={quot}{data}*{quot}
text                            {data}+

xml_dec_open                    <\?xml
xml_dec_close                   \?>
xml_dec_attr_data               [^ <>\'\"?]
xml_dec_attr                    {name}={xml_dec_attr_data}+

%x elem_dec
%x data
%x elem_close
%x xml_dec

%%

<*><                                return ELEM_START;
<elem_dec>{name}/({ws}{attr})*>     return ELEM_NAME_NON_EMPTY;
<elem_dec>{name}/({ws}{attr})*\/>   return ELEM_NAME_EMPTY;
<elem_dec>{attr}                    return ATTR;
<elem_dec,elem_close>>              return ELEM_END;
<data>{text}                        return TEXT;
<data><\/                           return ELEM_CLOSE;
<elem_close>{name}                  return ELEM_CLOSE_NAME;
<*>{xml_dec_open}                   return XML_DEC_OPEN;
<xml_dec>{xml_dec_attr}             return XML_DEC_ATTR;
<xml_dec>{xml_dec_close}            return XML_DEC_CLOSE;

.                                   |
{nl}                                ;

%%

void applyFilter (int token) {
    char currentOpen[100];
    switch(token) {
        case ELEM_START:
            printf("starting element\n");
            BEGIN elem_dec;
            break;
        case ELEM_NAME_NON_EMPTY:
            strcpy(currentOpen, yytext);
            printf("non-empty element: %s\n", yytext);
            break;
        case ELEM_NAME_EMPTY:
            printf("empty element: %s\n", yytext);
            break;
        case ATTR:
            printf("attribute: %s\n", yytext);
            break;
        case ELEM_END:
            BEGIN data;
            printf("ending element\n");
            break;
        case TEXT:
            printf("text: %s\n", yytext);
            break;
        case ELEM_CLOSE:
            BEGIN elem_close;
            break;
        case ELEM_CLOSE_NAME:
            if (strcmp(currentOpen,yytext) != 0){
                printf("%s is not properly closed!!!\n", currentOpen);
            }
            printf("closing element: %s\n", yytext);
            break;
        case XML_DEC_OPEN:
            printf("xml declaration open\n");
            BEGIN xml_dec;
            break;
        case XML_DEC_CLOSE:
            printf("xml declaration close\n");
            BEGIN 0;
            break;
        case XML_DEC_ATTR:
            printf("xml declaration attribute: %s\n", yytext);
            break;
    }
}

int yywrap(){
    return 1;
}

int main(int argc, char** argv) {
    if (argc != 2) {
        printf("Usage: %s filename\n", argv[0]);
        exit(1);
    }

    char *fileName = argv[1];
    printf("%s", fileName);
    yyin = fopen(fileName, "r");
    if (!yyin) {
        printf("File not found");
        exit(1);
    } else {
        int token;
        while((token = yylex()) != 0) {
            applyFilter(token);
        }
    }
    return 0;
}
