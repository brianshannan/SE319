%{

#include <stdio.h>
#include "y.tab.h"

// TODO
//      Format print stuff so it looks right/better
//      Detect tag that wasn't closed

%}

ws                              [ \t]
nl                              (\r|\n|\r\n)
quot                            [\'\"]
name_start                      [a-zA-Z_]
name_char                       [a-zA-Z0-9_.:]
name                            {name_start}{name_char}*
data                            [^<>&]
attr                            {name}={quot}{data}*{quot}
close_elem                      <\/{name}>
text                            >{data}+

xml_dec_open                    <\?xml
xml_dec_close                   \?>
xml_dec_attr_data               [^ <>\'\"]
xml_dec_attr                    {name}={xml_dec_attr_data}+

%x elem_dec
%x data
%x elem_close

%%

<*><                                return ELEM_START;
<elem_dec>{name}/({ws}{attr})*>     return ELEM_NAME_NON_EMPTY;
<elem_dec>{name}/({ws}{attr})*\/>   return ELEM_NAME_EMPTY;
<elem_dec>{attr}                    return ATTR;
<elem_dec,elem_close>>              return ELEM_END;
<data>{text}                        return TEXT;
<data><\/                           return ELEM_CLOSE;
<elem_close>{name}                  return ELEM_CLOSE_NAME;
{xml_dec_open}                      return XML_DEC_OPEN;
{xml_dec_close}                     return XML_DEC_CLOSE;
{xml_dec_attr}                      return XML_DEC_ATTR;

.                                   |
{nl}                                ;

%%

int main() {
    while(yywrap()) {
        int token = yylex();
        switch(token) {
            case ELEM_START:
                printf("starting element\n");
                BEGIN(elem_dec);
                break;
            case ELEM_NAME_NON_EMPTY:
                printf("non-empty element: %s\n", yytext);
                break;
            case ELEM_NAME_EMPTY:
                printf("empty element: %s\n", yytext);
                break;
            case ATTR:
                printf("attribute: %s\n", yytext);
                break;
            case ELEM_END:
                BEGIN 0;
                BEGIN data;
                break;
            case TEXT:
                printf("text: %s\n", yytext);
                break;
            case ELEM_CLOSE:
                BEGIN 0;
                BEGIN elem_close;
                break;
            case ELEM_CLOSE_NAME:
                printf("closing element: %s\n", yytext);
                break;

            case XML_DEC_OPEN:
                printf("xml declaration open\n");
                break;
            case XML_DEC_CLOSE:
                printf("xml declaration close\n");
                break;
            case XML_DEC_ATTR:
                printf("xml declaration attribute %s\n", yytext);
                break;
        }
    }
}

int yywrap() {
    return 1;
}
