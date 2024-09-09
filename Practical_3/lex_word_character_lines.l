%{
// Program to count lines, words, and characters
#include<stdio.h>

int char_count = 0;
int word_count = 0;
int line_count = 0;
%}

%%
\n              { line_count++; char_count++; }  
[ \t]+          { char_count += yyleng; }        
[a-zA-Z]+       { word_count++; char_count += yyleng; } 
.               { char_count++; }                
%%

int main()
{
       yyin = fopen("add.c", "r");
       yylex();
       printf("Lines: %d\nWords: %d\nCharacters: %d\n", line_count, word_count, char_count);
       return 0;
}
int yywrap() {
    return 1;
}
