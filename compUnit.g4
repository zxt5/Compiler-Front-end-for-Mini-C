// compUnit.g4
grammar compUnit;

compUnit     : funcDef ;
funcDef      : Type IdentMain '(' ')' block ;
Type        : 'int' ;
IdentMain    : 'main' ;
decl         : constDecl | varDecl ;
constDecl    : 'const' Type constDef (',' constDef )* ';' ;
constDef     : Ident '=' constInitVal ;
constInitVal : constExp ;
constExp     : addExp ;
varDecl      : Type varDef (',' varDef )* ';' ;
varDef       : Ident | Ident '=' initVal ;
initVal      : exp ;
block        : '{' (blockItem )* '}' ;
blockItem    : decl | stmt ;
stmt         : lVal '=' exp ';' | (exp)? ';' | Return exp ';' ;
exp          : addExp ;
lVal         : Ident ;
primaryExp   : '(' exp ')' | lVal | Number ;
addExp       : mulExp | addExp unaryOp mulExp ;
mulExp       : unaryExp | mulExp calOp unaryExp ;
unaryExp     : primaryExp | Ident '(' (funcRParams)? ')' | unaryOp unaryExp ;
funcRParams  : exp (',' exp )* ;
unaryOp      : '+' | '-' ;
calOp        : '*' | '/' | '%' ;
Return       : 'return' ;

Ident    : Nondigit (Nondigit|Digit)* ;


Nondigit : '_' | 'a'..'z' | 'A'..'Z' ;
Number             : Decimal_const | Octal_const | Hexadecimal_const ;
Decimal_const      : Nonzero_digit (Nonzero_digit|'0')*;
Octal_const        : '0' Octal_digit*;
Hexadecimal_const  : Hexadecimal_prefix Hexadecimal_digit*;
Hexadecimal_prefix : '0x' | '0X' ;
Nonzero_digit      : '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;
Octal_digit        : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' ;
Digit              : '0' | Nonzero_digit ;
Hexadecimal_digit  : '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'
                      | 'a' | 'b' | 'c' | 'd' | 'e' | 'f'
                      | 'A' | 'B' | 'C' | 'D' | 'E' | 'F' ;
WHITE_SPACE: ['\t'|'\n'|' '|'\r'] -> skip; // -> skip 表示解析时跳过该规则


