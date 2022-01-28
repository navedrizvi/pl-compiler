grammar Tiger;

/*
 * Parser
 */
main: PROGRAM ID LET decl_seg BEGIN funct_list END;
decl_seg: type_decl_list var_decl_list;
type_decl_list: type_decl type_decl_list | ;
var_decl_list: var_decl var_decl_list | ;
funct_list: funct funct_list | ;
type_decl: TYPE ID TASSIGN type SEMICOLON;
type: base_type | ARRAY OPENBRACK INTLIT CLOSEBRACK OF base_type | ID;
base_type: INT | FLOAT;
var_decl: storage_class id_list COLON type optional_init SEMICOLON;
storage_class: VAR | STATIC;
id_list: ID | ID COMMA id_list;
optional_init: ASSIGN constant | ;
funct: FUNCTION ID OPENPAREN param_list CLOSEPAREN return_type BEGIN stat_seq END;
param_list: param param_list_tail | ;
param_list_tail: COMMA param param_list_tail | ;
return_type: COLON type | ;
param: ID COLON type;
// Naved's part start
stat_seq: stat | stat stat_seq;
stat: BREAK SEMICOLON;
constant: INTLIT | FLOATLIT;
// end



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
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
POW: '**';
EQUAL: '==';
NEQUAL: '!=';
LESS: '<';
GREAT: '>';
LESSEQ: '<=';
GREATED: '>=';
AND: '&';
OR: '|';

// Assignment operators
ASSIGN: ':=';
TASSIGN: '=';

// User-defined values
INTLIT: ZERO | (NON_ZERO_DIGIT DIGIT*)  ;
FLOATLIT: (ZERO | NON_ZERO_DIGIT+)? '.'  DIGIT* ;
ID : [a-zA-Z][a-zA-Z0-9_]+ ;
COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */
WS : [ \r\t\n]+ -> skip ; // Skip whitespace

// fragments
fragment ZERO: '0';
fragment DIGIT: [0-9];
fragment NON_ZERO_DIGIT: [1-9];