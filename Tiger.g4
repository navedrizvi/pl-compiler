grammar Tiger;

/*
 * Parser
 */
main: PROGRAM ID END;


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
OPENPAR: '(';
CLOSEPAR: ')';
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