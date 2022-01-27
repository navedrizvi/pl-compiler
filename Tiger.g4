grammar Tiger;

/*
 * Parser
 */
main: PROGRAM ID END;


/*
 * Lexer
 */

// Keywords
PROGRAM: 'program';
END: 'end';

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