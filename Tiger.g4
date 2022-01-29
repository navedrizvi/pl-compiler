grammar Tiger;

/*
 * Parser
 */
main: PROGRAM ID LET decl_seg BEGIN funct_list END;
decl_seg: type_decl_list var_decl_list;
type_decl_list: type_decl type_decl_list |  /* epsilon */ ;
var_decl_list: var_decl var_decl_list |  /* epsilon */ ;
funct_list: funct funct_list |  /* epsilon */ ;
type_decl: TYPE ID TASSIGN type SEMICOLON;
type: base_type | ARRAY OPENBRACK INTLIT CLOSEBRACK OF base_type | ID;
base_type: INT | FLOAT;
var_decl: storage_class id_list COLON type optional_init SEMICOLON;
storage_class: VAR | STATIC;
id_list: ID | ID COMMA id_list;
optional_init: ASSIGN constant |  /* epsilon */ ;
funct: FUNCTION ID OPENPAREN param_list CLOSEPAREN return_type BEGIN stat_seq END;
param_list: param param_list_tail |  /* epsilon */ ;
param_list_tail: COMMA param param_list_tail |  /* epsilon */ ;
return_type: COLON type |  /* epsilon */ ;
param: ID COLON type;
stat_seq: stat | stat stat_seq;
stat: value ASSIGN expr SEMICOLON
    | IF expr THEN stat_seq ENDIF SEMICOLON
    | IF expr THEN stat_seq ELSE stat_seq ENDIF SEMICOLON
    | WHILE expr DO stat_seq ENDDO SEMICOLON
    | FOR ID ASSIGN expr TO expr DO stat_seq ENDDO SEMICOLON
    | opt_prefix ID OPENPAREN expr_list CLOSEPAREN SEMICOLON
    | BREAK SEMICOLON
    | RETURN opt_return SEMICOLON
    | LET decl_seg BEGIN stat_seq END
    ;
opt_return: expr |  /* epsilon */ ;
opt_prefix: value ASSIGN |  /* epsilon */ ;
expr: constant
    | value
    | OPENPAREN expr CLOSEPAREN
    | <assoc=right> expr POW expr
    | expr (MULT | DIV) expr
    | expr (PLUS | MINUS) expr
    | expr (EQUAL | NEQUAL | LESS | GREAT | LESSEQ | GREATEQ) expr
    | expr AND expr
    | expr OR expr
    ;
constant: INTLIT | FLOATLIT;
expr_list: expr expr_list_tail |  /* epsilon */ ;
expr_list_tail: COMMA expr expr_list_tail |  /* epsilon */ ;
value: ID value_tail;
value_tail: OPENBRACK expr CLOSEBRACK |  /* epsilon */ ;

/*
 * Lexer
 */

// Keywords
ARRAY: 'array';
BEGIN: 'begin';
BREAK: 'break';
DO: 'do';
ELSE: 'else';
END: 'end';
ENDDO: 'enddo';
ENDIF: 'endif';
FLOAT: 'float';
FOR: 'for';
FUNCTION: 'function';
IF: 'if';
INT: 'int';
LET: 'let';
OF: 'of';
PROGRAM: 'program';
RETURN: 'return';
STATIC: 'static';
THEN: 'then';
TO: 'to';
TYPE: 'type';
VAR: 'var';
WHILE: 'while';

// Punctuation
COMMA: ',';
DOT: '.';
COLON: ':';
SEMICOLON: ';';
OPENPAREN: '(';
CLOSEPAREN: ')';
OPENBRACK: '[';
CLOSEBRACK: ']';
OPENCURLY: '{';
CLOSECURLY: '}';

// Binary operators
POW: '**';
MULT: '*';
DIV: '/';
PLUS: '+';
MINUS: '-';
EQUAL: '==';
NEQUAL: '!=';
LESS: '<';
GREAT: '>';
LESSEQ: '<=';
GREATEQ: '>=';
AND: '&';
OR: '|';

// Assignment operators
ASSIGN: ':=';
TASSIGN: '=';

// User-defined values
INTLIT: ZERO | (NON_ZERO_DIGIT DIGIT*)  ;
FLOATLIT: INTLIT+ '.' DIGIT* ;

ID : [a-zA-Z][a-zA-Z0-9_]*;
COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */
WS : [ \r\t\n]+ -> skip ; // Skip whitespace

// fragments
fragment ZERO: '0';
fragment DIGIT: [0-9];
fragment NON_ZERO_DIGIT: [1-9];