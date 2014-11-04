/*
** This is an implementation of Caeser Cipher which is a type of
** substitution cipher in which each letter in the plaintext is replaced
** by a letter some fixed number of positions down the alphabet.
**
** In this example, a letter is replaced by another letter three places
** down the alphabet.
*/


%%
[a-z]	{ char ch = yytext[0];
          ch += 3;
          if (ch > 'z') ch -= ('z'+1-'a');
          printf ("%c", ch);
        }
          
[A-Z]	{ char ch = yytext[0];
          ch += 3;
          if (ch > 'Z') ch -= ('Z'+1-'A');
          printf ("%c", ch);
        }
%%
int yywrap(){ return 1;}
int main(){ yylex(); }
