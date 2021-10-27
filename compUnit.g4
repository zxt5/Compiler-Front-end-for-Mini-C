// compUnit.g4
grammar compUnit;

compUnit : funcDef ;
funcDef  : FuncType Ident '(' ')' block ;
FuncType : 'int' ;
Ident    : 'main' ;
block    : '{' stmt '}' ;
stmt     : 'return' exp ';' ;
exp      : addExp;
addExp   : addExp UnaryOp mulExp | mulExp;
mulExp   : unaryExp | mulExp Op2 unaryExp ;
unaryExp : primaryExp | UnaryOp unaryExp ;
primaryExp : '(' exp ')' | Number ;
UnaryOp  : '+' | '-' ;
Op2      : '*' | '/' | '%' ;

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
