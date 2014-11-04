/*
** In this example, lex is being used to count the number of words of
** different lengths and then print out the results
** END input with ^D which is end of file here.
*/

  int len[100];
alpha     [a-z]
%%
{alpha}+   len[yyleng]++;
.     |
\n    ;

%%
int yywrap() {
  int i;
  for (i = 0; i < 100; i++) {
    printf("%4d   %10d\n",i, len[i]);
  }
  return 1;
}
int main(){ yylex(); }
