#include<iostream>
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
using namespace std;

// if 
// else	
// while	
// break		
// continue	
// return
// =	Assign	
// 分号	;	Semicolon	
// 左括号	(	LPar	
// 右括号	)	RPar	
// 左大括号	{	LBrace	
// 右大括号	}	RBrace	
// 加号	+	Plus	
// 乘号	*	Mult	
// 除号	/	Div	
// 小于号	<	Lt	
// 大于号	>	Gt	
// 等于号	==

FILE *file = NULL;
char s[100005];
char *flag = NULL;
int n = 0;
char tmp=' ', c;
char token[1100];
int flag_token = 0;
int num;
string symbol = "";

void clearToken()         { flag_token = 0;} ;  // 清空token字符数组
void getChar()            { tmp = *flag; flag++; };     // 读入一个字符存在char中
void catToken()           { token[flag_token++] = tmp; } ;    // 把当前char中的字符与token字符数组中的字符串连接
void retract()            { flag--; } ;     //将读字符指针后退一个字符
bool isSpace()            { return tmp==' '?true:false; };     // 空格
bool isNewline()          { return tmp=='\n'?true:false; };     // 换行符
bool isTab()              { return tmp=='\t'?true:false; };// Tab
bool isLetter()           { return islower(tmp)||isupper(tmp); };// 字母
bool isDigit()            { return tmp>='0' && tmp<='9'; };// 数字

bool isAssign()           { return tmp=='='?true:false; };  // =
bool isSemicolon()        { return tmp==';'?true:false; };  // ;
bool isLpar()             { return tmp=='('?true:false; };  // (
bool isRpar()             { return tmp==')'?true:false; };  // )
bool isLbrace()           { return tmp=='{'?true:false; };  // {
bool isRbrace()           { return tmp=='}'?true:false; };  // }
bool isPlus()             { return tmp=='+'?true:false; };  // +
bool isMult()             { return tmp=='*'?true:false; };  // *
bool isDiv()              { return tmp=='/'?true:false; };  // /
bool isLt()               { return tmp=='<'?true:false; };  // <
bool isGt()               { return tmp=='>'?true:false; };  // >
bool isUnderline()        { return tmp=='_'?true:false; };  // _
// bool isEq()               { return tmp=='<'?true:false; };  // ==



void reserver() {
    if(strcmp(token, "if")==0) symbol = "If";
    else if(strcmp(token, "else")==0) symbol = "Else";
    else if(strcmp(token, "break")==0) symbol = "Break";
    else if(strcmp(token, "continue")==0) symbol = "Continue";
    else if(strcmp(token, "while")==0) symbol = "While";
    else if(strcmp(token, "return")==0) symbol = "Return";
    else symbol = "Ident";
};    // 查找保留字，若返回值为0，则表示token中的字符串是一个标识符，否则为保留字编码，返回当前保留字的类编码

int transNum() { 
    return atoi(token);
};    // 将token中的字符串转换成整形数值，返回这个值

void error() {};      // 错误处理过程

void getSymbol() { 
    clearToken();
    while( isSpace()||isNewline()||isTab() ) getChar();
    if( isLetter() || isUnderline() ) {
        while( isLetter() || isDigit() || isUnderline() ) {
            catToken();
            getChar();
        }
        retract();
        token[flag_token] = '\0';
        reserver();
    }
    else if( isDigit() ) {
        while( isDigit() ) { catToken(); getChar(); };
        retract();
        token[flag_token] = '\0';
        num = transNum();
        symbol = "Number";
    }
    else if( isAssign() ) {
        getChar();
        if( isAssign() ) symbol = "Eq";
        else {
            retract();
            symbol = "Assign";
        }
    }
    else if( isSemicolon() ) { symbol = "Semicolon"; }
    else if( isLpar() ) { symbol = "LPar"; }
    else if( isRpar() ) { symbol = "RPar"; }
    else if( isLbrace() ) { symbol = "LBrace"; }
    else if( isRbrace() ) { symbol = "RBrace"; }
    else if( isPlus() ) { symbol = "Plus"; }
    else if( isMult() ) { symbol = "Mult"; }
    else if( isDiv() ) { symbol = "Div"; }
    else if( isLt() ) { symbol = "Lt"; }
    else if( isGt() ) { symbol = "Gt"; }
    else symbol = "Err";
    getChar();
};

int main(int argh, char *argv[]) {
//     file = fopen("test.txt","r");
    file = fopen(argv[1],"r");
    // 读取文件字符存入字符数组s
    while(1) {
        c = fgetc(file);
        if(c == EOF) break;
        else s[n++] = c;
    }
    s[n] = '\0';
    flag = s;
    while(tmp != '\0') {
        getSymbol();
        if(symbol == "Ident" || symbol == "Number") cout<<symbol<<'('<<token<<')'<<endl;
        else if(symbol == "Err") {
        	cout<<symbol<<endl;
        	return 0;
		}
        else cout<<symbol<<endl;
    }
}

