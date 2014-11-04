README
-----------------------------------------------------------------
You have to carry out two steps before you can run the analyzer:
1) Generate a lexical analyzer (from the lexical analysis rule
specified in the lex file by typing:
lex <<filename.l>>   // replace <<filename.l>> with your file name

A lex.yy.c file will be generated.

2) Compile the lexical analyzer 
cc lex.yy.c -o <<MYRUNFILE>> // replace <<MYRUNFILE>>> 


Now, you can run the analyzer by typing
./<<MYRUNFILE>> on the command line. Then type in inputs


Here are the examples.
-----------------------------------------------------------------
01_empty.l An empty lex file - just prints the input
02_stopStart.l  - recognizes stop and start in input
03_numberWord.l - recognizes regular expressions
04_filename.l   - more complex example
05_microwave.l - microwave
06_tokens.l    - prints out token type and token value
07_romans.l    - adds two roman numerals and prints the result
08_histograph.l - shows histograph of number of words of different lengths
09_caeser-cipher.l - as per name
-----------------------------------------------------------------
