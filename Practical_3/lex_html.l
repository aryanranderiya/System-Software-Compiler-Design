%{
// Program to identify HTML tags
#include<stdio.h>
%}

%%

\<([a-zA-Z]+)\>\s*[^<]\s*\<\/[a-zA-Z]+>        { fprintf(yyout, "HTML Tag: %s\n", yytext); } 
%%

int main()
{
       yyin = fopen("index.html", "r");  
       yyout = fopen("output1.txt", "w");
       yylex();
       return 0;
}
int yywrap() {
    return 1;
}
