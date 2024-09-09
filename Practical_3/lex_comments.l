%{
    // Program to identify keywords, identifiers, and numbers
    #include <stdio.h>
    int yywrap() {
        return 1;
    }
%}

%%
\/\/.*                            ;  // Match and discard single-line comments
\/\*([^*]|\*+[^/])*\*\/           ;  // Match and discard multi-line comments
.|\n                              { fprintf(yyout, "%s", yytext); } // Output everything else
%%

int main() {
    yyin = fopen("add.c", "r");
    yyout = fopen("output.txt", "w");
    yylex();
    fclose(yyin);
    fclose(yyout);
    return 0;
}
