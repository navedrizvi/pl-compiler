grammar Tiger;

/*
 * Parser
 */
main: PROGRAM ID LET decl_seg BEGIN funct_list END EOF;
decl_seg: type_decl_list var_decl_list;
type_decl_list: type_decl type_decl_list |  /* epsilon */;
var_decl_list: var_decl var_decl_list |  /* epsilon */;
funct_list: funct funct_list |  /* epsilon */;
type_decl: TYPE ID TASSIGN type SEMICOLON;
type: base_type                                      # TypeBaseType
    | ARRAY OPENBRACK INTLIT CLOSEBRACK OF base_type # TypeArray
    | ID                                             # TypeID
    ;
base_type: INT   # BaseTypeInt
         | FLOAT # BaseTypeFloat
         ;
var_decl: storage_class id_list COLON type optional_init SEMICOLON;
storage_class: VAR    # StorageClassVar
             | STATIC # StorageClassStatic
             ;
id_list: ID               # IdListId
       | ID COMMA id_list # IdList
       ;
optional_init: ASSIGN constant |  /* epsilon */ ;
funct: FUNCTION ID OPENPAREN param_list CLOSEPAREN return_type BEGIN stat_seq END;
param_list: param param_list_tail |  /* epsilon */ ;
param_list_tail: COMMA param param_list_tail |  /* epsilon */ ;
return_type: COLON type |  /* epsilon */ ;
param: ID COLON type;
stat_seq: stat          # StatSingle
        | stat stat_seq # StatSeq
        ;
stat: value ASSIGN expr SEMICOLON                            # StatAssign
    | IF expr THEN stat_seq ENDIF SEMICOLON                  # StatIf
    | IF expr THEN stat_seq ELSE stat_seq ENDIF SEMICOLON    # StatIfElse
    | WHILE expr DO stat_seq ENDDO SEMICOLON                 # StatWhile
    | FOR ID ASSIGN expr TO expr DO stat_seq ENDDO SEMICOLON # StatFor
    | opt_prefix ID OPENPAREN expr_list CLOSEPAREN SEMICOLON # StatFunctionCall
    | BREAK SEMICOLON                                        # StatBreak
    | RETURN opt_return SEMICOLON                            # StatReturn
    | LET decl_seg BEGIN stat_seq END                        # StatLet
    ;
opt_return: expr |  /* epsilon */ ;
opt_prefix: value ASSIGN |  /* epsilon */ ;
expr: constant # ExprConstant
    | value    # ExprValue
    | OPENPAREN expr CLOSEPAREN # ExprParen
    | <assoc=right> expr POW expr # ExprPow
    | expr (MULT | DIV) expr # ExprMultDiv
    | expr (PLUS | MINUS) expr # ExprAddSub
    | expr (EQUAL | NEQUAL | LESS | GREAT | LESSEQ | GREATEQ) expr # ExprComp
    | expr AND expr # ExprAnd
    | expr OR expr # ExporOr
    ;
constant: INTLIT # ConstantIntLit
        | FLOATLIT # ConstantFloatLit
        ;
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
FLOATLIT: INTLIT? '.' DIGIT* ;

ID : [a-zA-Z][a-zA-Z0-9_]*;
COMMENT : '/*' .*? '*/' -> skip ; // .*? matches anything until the first */
WS : [ \r\t\n]+ -> skip ; // Skip whitespace

// fragments
fragment ZERO: '0';
fragment DIGIT: [0-9];
fragment NON_ZERO_DIGIT: [1-9];