// compUnit.g4
grammar compUnit;

//compUnit     : (decl)* funcDef ;
compUnit     : compUnit decl
             | compUnit funcDef
             | decl
             | funcDef ; // [changed]
Int          : 'int' ;
Void         : 'void' ;
//funcDef      : Type IdentMain '(' ')' block ;
funcDef      : type Ident '(' (funcFParams)? ')' block ; // [changed]
type         : 'int' | 'void' ;
//IdentMain    : 'main' ;
funcFParams  : funcFParam ( ',' funcFParam )* ; // [new]
funcFParam   : Int Ident ( '[' ']' dimension )? ; // [new]
dimension     : ( '[' exp ']' )* ;
//BType        : 'int' ;
decl         : constDecl | varDecl ;

constDecl    : 'const' type constDef (',' constDef )* ';' ;
constDef     : Ident ('[' constExp']')* '=' constInitVal ;
constInitVal : constExp
             | '{' (constInitVal ( ',' constInitVal )* )? '}' ;
constExp     : addExp ;

varDecl      : type varDef (',' varDef )* ';' ;
varDef       : Ident ('[' constExp ']')*
             | Ident ('[' constExp ']')* '=' initVal ;
initVal      : exp
             | '{' ( initVal (',' initVal )* )? '}' ;


block        : '{' (blockItem )* '}' ;
blockItem    : decl | stmt ;

condition    : lorExp ;

stmt         : lVal '=' exp ';'
             | (exp)? ';'
             | Return (exp)? ';'  // Changed
             | If '(' condition ')' stmt ('else' stmt)?
             | block
             | While '(' condition ')' stmt
             | Break
             | Continue ;

If           : 'if' ;
While        : 'while' ;
Break        : 'break' ;
Continue     : 'continue' ;

Or           : '||' ;
And          : '&&' ;
Cmp          : '<' | '>' | '<=' | '>=' ;
Equal       : '==' | '!=' ;

lorExp       : landExp
             | lorExp Or landExp ;
relExp       : addExp
             | relExp Cmp addExp ;
eqExp        : relExp
             | eqExp Equal relExp ;
landExp      : eqExp
             | landExp And eqExp ;



exp          : addExp ;
lVal         : Ident ('[' exp ']')* ;   // Changed
primaryExp   : '(' exp ')' | lVal | Number ;

addExp       : mulExp | addExp unaryOp mulExp ;

mulExp       : unaryExp | mulExp calOp unaryExp ;
unaryExp     : primaryExp | Ident '(' (funcRParams)? ')' | unaryOp unaryExp ;
funcRParams  : exp (',' exp )* ;
unaryOp      : '+' | '-' | '!';   // 保证'!'只出现在cond中
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


