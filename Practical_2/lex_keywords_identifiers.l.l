%{
    // Program to identify keywords, identifiers, and numbers
    #include <stdio.h>
    int keyCount = 0;
    int identifierCount = 0;
    int numberCount = 0;
    int yywrap() {
        return 1;
    }
%}

letter [a-zA-Z]
digit [0-9]

%%
"int"|"for"|"if"|"else"|"void"|"while"|"switch"|"float"|"char"  { keyCount++; printf("%s is a Keyword\n", yytext); }
                                     
[a-zA-Z_][a-zA-Z0-9_]*                                    { identifierCount++; printf("%s is a identifier\n", yytext);}

[\n\t ]                                                          ;  // Ignore newlines, tabs, and spaces
    
-?(([0-9]+(\.[0-9]*)?)|(\.[0-9]+))([eE][-+]?[0-9]+)?            { numberCount++; printf("%s is a Number\n", yytext); }

.                                                                { ECHO; printf(" Others\n"); }  // Echo any other character
%%

int main() {
    yylex();
    printf("\n%d - Keywords \n%d - Identifiers \n%d - Numbers\n", keyCount, identifierCount, numberCount);
    return 0;
}
