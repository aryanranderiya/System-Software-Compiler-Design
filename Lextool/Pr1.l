%{ %}

%%

([a-zA-Z]|_).([a-zA-Z0-9]*) {printf("%s is an Identifier\n", yytext)}


%%