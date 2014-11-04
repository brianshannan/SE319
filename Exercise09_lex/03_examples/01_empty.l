/* There are THREE sections in any lex file.
** The first is the declaration section.
** The second is the rules section. A %% separates the top two sections.
** The third is user subroutines section. A %% separates the bottom two
** sections.
** Here is a minimal lex file. It has basically all sections empty.
** By default, it will just print whatever is input to it.
**
**
*/

%%

%%

/* These are needed to allow compilation on the pyrite machines */ 
int yywrap(){ return 1;}
int main(){ yylex(); }
