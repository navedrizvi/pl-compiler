// Generated from Tiger.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TigerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ARRAY=1, BEGIN=2, BREAK=3, DO=4, ELSE=5, END=6, ENDDO=7, ENDIF=8, FLOAT=9, 
		FOR=10, FUNCTION=11, IF=12, INT=13, LET=14, OF=15, PROGRAM=16, RETURN=17, 
		STATIC=18, THEN=19, TO=20, TYPE=21, VAR=22, WHILE=23, COMMA=24, DOT=25, 
		COLON=26, SEMICOLON=27, OPENPAREN=28, CLOSEPAREN=29, OPENBRACK=30, CLOSEBRACK=31, 
		OPENCURLY=32, CLOSECURLY=33, POW=34, MULT=35, DIV=36, PLUS=37, MINUS=38, 
		EQUAL=39, NEQUAL=40, LESS=41, GREAT=42, LESSEQ=43, GREATEQ=44, AND=45, 
		OR=46, ASSIGN=47, TASSIGN=48, INTLIT=49, FLOATLIT=50, ID=51, COMMENT=52, 
		WS=53;
	public static final int
		RULE_main = 0, RULE_decl_seg = 1, RULE_type_decl_list = 2, RULE_var_decl_list = 3, 
		RULE_funct_list = 4, RULE_type_decl = 5, RULE_type = 6, RULE_base_type = 7, 
		RULE_var_decl = 8, RULE_storage_class = 9, RULE_id_list = 10, RULE_optional_init = 11, 
		RULE_funct = 12, RULE_param_list = 13, RULE_param_list_tail = 14, RULE_return_type = 15, 
		RULE_param = 16, RULE_stat_seq = 17, RULE_stat = 18, RULE_opt_return = 19, 
		RULE_opt_prefix = 20, RULE_expr = 21, RULE_constant = 22, RULE_expr_list = 23, 
		RULE_expr_list_tail = 24, RULE_value = 25, RULE_value_tail = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "decl_seg", "type_decl_list", "var_decl_list", "funct_list", 
			"type_decl", "type", "base_type", "var_decl", "storage_class", "id_list", 
			"optional_init", "funct", "param_list", "param_list_tail", "return_type", 
			"param", "stat_seq", "stat", "opt_return", "opt_prefix", "expr", "constant", 
			"expr_list", "expr_list_tail", "value", "value_tail"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'array'", "'begin'", "'break'", "'do'", "'else'", "'end'", "'enddo'", 
			"'endif'", "'float'", "'for'", "'function'", "'if'", "'int'", "'let'", 
			"'of'", "'program'", "'return'", "'static'", "'then'", "'to'", "'type'", 
			"'var'", "'while'", "','", "'.'", "':'", "';'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'**'", "'*'", "'/'", "'+'", "'-'", "'=='", "'!='", 
			"'<'", "'>'", "'<='", "'>='", "'&'", "'|'", "':='", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ARRAY", "BEGIN", "BREAK", "DO", "ELSE", "END", "ENDDO", "ENDIF", 
			"FLOAT", "FOR", "FUNCTION", "IF", "INT", "LET", "OF", "PROGRAM", "RETURN", 
			"STATIC", "THEN", "TO", "TYPE", "VAR", "WHILE", "COMMA", "DOT", "COLON", 
			"SEMICOLON", "OPENPAREN", "CLOSEPAREN", "OPENBRACK", "CLOSEBRACK", "OPENCURLY", 
			"CLOSECURLY", "POW", "MULT", "DIV", "PLUS", "MINUS", "EQUAL", "NEQUAL", 
			"LESS", "GREAT", "LESSEQ", "GREATEQ", "AND", "OR", "ASSIGN", "TASSIGN", 
			"INTLIT", "FLOATLIT", "ID", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Tiger.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TigerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MainContext extends ParserRuleContext {
		public TerminalNode PROGRAM() { return getToken(TigerParser.PROGRAM, 0); }
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode LET() { return getToken(TigerParser.LET, 0); }
		public Decl_segContext decl_seg() {
			return getRuleContext(Decl_segContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(TigerParser.BEGIN, 0); }
		public Funct_listContext funct_list() {
			return getRuleContext(Funct_listContext.class,0);
		}
		public TerminalNode END() { return getToken(TigerParser.END, 0); }
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitMain(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(PROGRAM);
			setState(55);
			match(ID);
			setState(56);
			match(LET);
			setState(57);
			decl_seg();
			setState(58);
			match(BEGIN);
			setState(59);
			funct_list();
			setState(60);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Decl_segContext extends ParserRuleContext {
		public Type_decl_listContext type_decl_list() {
			return getRuleContext(Type_decl_listContext.class,0);
		}
		public Var_decl_listContext var_decl_list() {
			return getRuleContext(Var_decl_listContext.class,0);
		}
		public Decl_segContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_seg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterDecl_seg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitDecl_seg(this);
		}
	}

	public final Decl_segContext decl_seg() throws RecognitionException {
		Decl_segContext _localctx = new Decl_segContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl_seg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			type_decl_list();
			setState(63);
			var_decl_list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_decl_listContext extends ParserRuleContext {
		public Type_declContext type_decl() {
			return getRuleContext(Type_declContext.class,0);
		}
		public Type_decl_listContext type_decl_list() {
			return getRuleContext(Type_decl_listContext.class,0);
		}
		public Type_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterType_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitType_decl_list(this);
		}
	}

	public final Type_decl_listContext type_decl_list() throws RecognitionException {
		Type_decl_listContext _localctx = new Type_decl_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type_decl_list);
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				type_decl();
				setState(66);
				type_decl_list();
				}
				break;
			case BEGIN:
			case STATIC:
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_decl_listContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_decl_listContext var_decl_list() {
			return getRuleContext(Var_decl_listContext.class,0);
		}
		public Var_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterVar_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitVar_decl_list(this);
		}
	}

	public final Var_decl_listContext var_decl_list() throws RecognitionException {
		Var_decl_listContext _localctx = new Var_decl_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl_list);
		try {
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STATIC:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				var_decl();
				setState(72);
				var_decl_list();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Funct_listContext extends ParserRuleContext {
		public FunctContext funct() {
			return getRuleContext(FunctContext.class,0);
		}
		public Funct_listContext funct_list() {
			return getRuleContext(Funct_listContext.class,0);
		}
		public Funct_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funct_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterFunct_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitFunct_list(this);
		}
	}

	public final Funct_listContext funct_list() throws RecognitionException {
		Funct_listContext _localctx = new Funct_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funct_list);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				funct();
				setState(78);
				funct_list();
				}
				break;
			case END:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_declContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(TigerParser.TYPE, 0); }
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode TASSIGN() { return getToken(TigerParser.TASSIGN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public Type_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterType_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitType_decl(this);
		}
	}

	public final Type_declContext type_decl() throws RecognitionException {
		Type_declContext _localctx = new Type_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(TYPE);
			setState(84);
			match(ID);
			setState(85);
			match(TASSIGN);
			setState(86);
			type();
			setState(87);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TerminalNode ARRAY() { return getToken(TigerParser.ARRAY, 0); }
		public TerminalNode OPENBRACK() { return getToken(TigerParser.OPENBRACK, 0); }
		public TerminalNode INTLIT() { return getToken(TigerParser.INTLIT, 0); }
		public TerminalNode CLOSEBRACK() { return getToken(TigerParser.CLOSEBRACK, 0); }
		public TerminalNode OF() { return getToken(TigerParser.OF, 0); }
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				base_type();
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(ARRAY);
				setState(91);
				match(OPENBRACK);
				setState(92);
				match(INTLIT);
				setState(93);
				match(CLOSEBRACK);
				setState(94);
				match(OF);
				setState(95);
				base_type();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TigerParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(TigerParser.FLOAT, 0); }
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_base_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Storage_classContext storage_class() {
			return getRuleContext(Storage_classContext.class,0);
		}
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(TigerParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Optional_initContext optional_init() {
			return getRuleContext(Optional_initContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			storage_class();
			setState(102);
			id_list();
			setState(103);
			match(COLON);
			setState(104);
			type();
			setState(105);
			optional_init();
			setState(106);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Storage_classContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(TigerParser.VAR, 0); }
		public TerminalNode STATIC() { return getToken(TigerParser.STATIC, 0); }
		public Storage_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStorage_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStorage_class(this);
		}
	}

	public final Storage_classContext storage_class() throws RecognitionException {
		Storage_classContext _localctx = new Storage_classContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_storage_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !(_la==STATIC || _la==VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Id_listContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(TigerParser.COMMA, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterId_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitId_list(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_id_list);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(110);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(ID);
				setState(112);
				match(COMMA);
				setState(113);
				id_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Optional_initContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(TigerParser.ASSIGN, 0); }
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public Optional_initContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optional_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterOptional_init(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitOptional_init(this);
		}
	}

	public final Optional_initContext optional_init() throws RecognitionException {
		Optional_initContext _localctx = new Optional_initContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_optional_init);
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(ASSIGN);
				setState(117);
				constant();
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(TigerParser.FUNCTION, 0); }
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode OPENPAREN() { return getToken(TigerParser.OPENPAREN, 0); }
		public Param_listContext param_list() {
			return getRuleContext(Param_listContext.class,0);
		}
		public TerminalNode CLOSEPAREN() { return getToken(TigerParser.CLOSEPAREN, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(TigerParser.BEGIN, 0); }
		public Stat_seqContext stat_seq() {
			return getRuleContext(Stat_seqContext.class,0);
		}
		public TerminalNode END() { return getToken(TigerParser.END, 0); }
		public FunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterFunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitFunct(this);
		}
	}

	public final FunctContext funct() throws RecognitionException {
		FunctContext _localctx = new FunctContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(FUNCTION);
			setState(122);
			match(ID);
			setState(123);
			match(OPENPAREN);
			setState(124);
			param_list();
			setState(125);
			match(CLOSEPAREN);
			setState(126);
			return_type();
			setState(127);
			match(BEGIN);
			setState(128);
			stat_seq();
			setState(129);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_listContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Param_list_tailContext param_list_tail() {
			return getRuleContext(Param_list_tailContext.class,0);
		}
		public Param_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterParam_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitParam_list(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_param_list);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				param();
				setState(132);
				param_list_tail();
				}
				break;
			case CLOSEPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Param_list_tailContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(TigerParser.COMMA, 0); }
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Param_list_tailContext param_list_tail() {
			return getRuleContext(Param_list_tailContext.class,0);
		}
		public Param_list_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_list_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterParam_list_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitParam_list_tail(this);
		}
	}

	public final Param_list_tailContext param_list_tail() throws RecognitionException {
		Param_list_tailContext _localctx = new Param_list_tailContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param_list_tail);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(COMMA);
				setState(138);
				param();
				setState(139);
				param_list_tail();
				}
				break;
			case CLOSEPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_typeContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(TigerParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitReturn_type(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_return_type);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(COLON);
				setState(145);
				type();
				}
				break;
			case BEGIN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode COLON() { return getToken(TigerParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(ID);
			setState(150);
			match(COLON);
			setState(151);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stat_seqContext extends ParserRuleContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Stat_seqContext stat_seq() {
			return getRuleContext(Stat_seqContext.class,0);
		}
		public Stat_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStat_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStat_seq(this);
		}
	}

	public final Stat_seqContext stat_seq() throws RecognitionException {
		Stat_seqContext _localctx = new Stat_seqContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stat_seq);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				stat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				stat();
				setState(155);
				stat_seq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(TigerParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public TerminalNode IF() { return getToken(TigerParser.IF, 0); }
		public TerminalNode THEN() { return getToken(TigerParser.THEN, 0); }
		public List<Stat_seqContext> stat_seq() {
			return getRuleContexts(Stat_seqContext.class);
		}
		public Stat_seqContext stat_seq(int i) {
			return getRuleContext(Stat_seqContext.class,i);
		}
		public TerminalNode ENDIF() { return getToken(TigerParser.ENDIF, 0); }
		public TerminalNode ELSE() { return getToken(TigerParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(TigerParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(TigerParser.DO, 0); }
		public TerminalNode ENDDO() { return getToken(TigerParser.ENDDO, 0); }
		public TerminalNode FOR() { return getToken(TigerParser.FOR, 0); }
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode TO() { return getToken(TigerParser.TO, 0); }
		public Opt_prefixContext opt_prefix() {
			return getRuleContext(Opt_prefixContext.class,0);
		}
		public TerminalNode OPENPAREN() { return getToken(TigerParser.OPENPAREN, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode CLOSEPAREN() { return getToken(TigerParser.CLOSEPAREN, 0); }
		public TerminalNode BREAK() { return getToken(TigerParser.BREAK, 0); }
		public TerminalNode RETURN() { return getToken(TigerParser.RETURN, 0); }
		public Opt_returnContext opt_return() {
			return getRuleContext(Opt_returnContext.class,0);
		}
		public TerminalNode LET() { return getToken(TigerParser.LET, 0); }
		public Decl_segContext decl_seg() {
			return getRuleContext(Decl_segContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(TigerParser.BEGIN, 0); }
		public TerminalNode END() { return getToken(TigerParser.END, 0); }
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStat(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stat);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				value();
				setState(160);
				match(ASSIGN);
				setState(161);
				expr(0);
				setState(162);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(IF);
				setState(165);
				expr(0);
				setState(166);
				match(THEN);
				setState(167);
				stat_seq();
				setState(168);
				match(ENDIF);
				setState(169);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(IF);
				setState(172);
				expr(0);
				setState(173);
				match(THEN);
				setState(174);
				stat_seq();
				setState(175);
				match(ELSE);
				setState(176);
				stat_seq();
				setState(177);
				match(ENDIF);
				setState(178);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				match(WHILE);
				setState(181);
				expr(0);
				setState(182);
				match(DO);
				setState(183);
				stat_seq();
				setState(184);
				match(ENDDO);
				setState(185);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				match(FOR);
				setState(188);
				match(ID);
				setState(189);
				match(ASSIGN);
				setState(190);
				expr(0);
				setState(191);
				match(TO);
				setState(192);
				expr(0);
				setState(193);
				match(DO);
				setState(194);
				stat_seq();
				setState(195);
				match(ENDDO);
				setState(196);
				match(SEMICOLON);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(198);
				opt_prefix();
				setState(199);
				match(ID);
				setState(200);
				match(OPENPAREN);
				setState(201);
				expr_list();
				setState(202);
				match(CLOSEPAREN);
				setState(203);
				match(SEMICOLON);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(205);
				match(BREAK);
				setState(206);
				match(SEMICOLON);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(207);
				match(RETURN);
				setState(208);
				opt_return();
				setState(209);
				match(SEMICOLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(211);
				match(LET);
				setState(212);
				decl_seg();
				setState(213);
				match(BEGIN);
				setState(214);
				stat_seq();
				setState(215);
				match(END);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opt_returnContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Opt_returnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_return; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterOpt_return(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitOpt_return(this);
		}
	}

	public final Opt_returnContext opt_return() throws RecognitionException {
		Opt_returnContext _localctx = new Opt_returnContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_opt_return);
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENPAREN:
			case INTLIT:
			case FLOATLIT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(219);
				expr(0);
				}
				break;
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Opt_prefixContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(TigerParser.ASSIGN, 0); }
		public Opt_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opt_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterOpt_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitOpt_prefix(this);
		}
	}

	public final Opt_prefixContext opt_prefix() throws RecognitionException {
		Opt_prefixContext _localctx = new Opt_prefixContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_opt_prefix);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				value();
				setState(224);
				match(ASSIGN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode OPENPAREN() { return getToken(TigerParser.OPENPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSEPAREN() { return getToken(TigerParser.CLOSEPAREN, 0); }
		public TerminalNode POW() { return getToken(TigerParser.POW, 0); }
		public TerminalNode MULT() { return getToken(TigerParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(TigerParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(TigerParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TigerParser.MINUS, 0); }
		public TerminalNode EQUAL() { return getToken(TigerParser.EQUAL, 0); }
		public TerminalNode NEQUAL() { return getToken(TigerParser.NEQUAL, 0); }
		public TerminalNode LESS() { return getToken(TigerParser.LESS, 0); }
		public TerminalNode GREAT() { return getToken(TigerParser.GREAT, 0); }
		public TerminalNode LESSEQ() { return getToken(TigerParser.LESSEQ, 0); }
		public TerminalNode GREATEQ() { return getToken(TigerParser.GREATEQ, 0); }
		public TerminalNode AND() { return getToken(TigerParser.AND, 0); }
		public TerminalNode OR() { return getToken(TigerParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTLIT:
			case FLOATLIT:
				{
				setState(230);
				constant();
				}
				break;
			case ID:
				{
				setState(231);
				value();
				}
				break;
			case OPENPAREN:
				{
				setState(232);
				match(OPENPAREN);
				setState(233);
				expr(0);
				setState(234);
				match(CLOSEPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(256);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(238);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(239);
						match(POW);
						setState(240);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(242);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(243);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(245);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(246);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(248);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NEQUAL) | (1L << LESS) | (1L << GREAT) | (1L << LESSEQ) | (1L << GREATEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(251);
						match(AND);
						setState(252);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(254);
						match(OR);
						setState(255);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode INTLIT() { return getToken(TigerParser.INTLIT, 0); }
		public TerminalNode FLOATLIT() { return getToken(TigerParser.FLOATLIT, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_la = _input.LA(1);
			if ( !(_la==INTLIT || _la==FLOATLIT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_listContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_tailContext expr_list_tail() {
			return getRuleContext(Expr_list_tailContext.class,0);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExpr_list(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr_list);
		try {
			setState(267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENPAREN:
			case INTLIT:
			case FLOATLIT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				expr(0);
				setState(264);
				expr_list_tail();
				}
				break;
			case CLOSEPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_list_tailContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(TigerParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_list_tailContext expr_list_tail() {
			return getRuleContext(Expr_list_tailContext.class,0);
		}
		public Expr_list_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExpr_list_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExpr_list_tail(this);
		}
	}

	public final Expr_list_tailContext expr_list_tail() throws RecognitionException {
		Expr_list_tailContext _localctx = new Expr_list_tailContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr_list_tail);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				match(COMMA);
				setState(270);
				expr(0);
				setState(271);
				expr_list_tail();
				}
				break;
			case CLOSEPAREN:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public Value_tailContext value_tail() {
			return getRuleContext(Value_tailContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(ID);
			setState(277);
			value_tail();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Value_tailContext extends ParserRuleContext {
		public TerminalNode OPENBRACK() { return getToken(TigerParser.OPENBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSEBRACK() { return getToken(TigerParser.CLOSEBRACK, 0); }
		public Value_tailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterValue_tail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitValue_tail(this);
		}
	}

	public final Value_tailContext value_tail() throws RecognitionException {
		Value_tailContext _localctx = new Value_tailContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_value_tail);
		try {
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(279);
				match(OPENBRACK);
				setState(280);
				expr(0);
				setState(281);
				match(CLOSEBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 21:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0121\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\5\4H\n\4\3\5\3\5\3\5\3\5\5\5N\n\5\3\6\3\6\3\6\3\6"+
		"\5\6T\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"d\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\5"+
		"\fu\n\f\3\r\3\r\3\r\5\rz\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\5\17\u008a\n\17\3\20\3\20\3\20\3\20\3\20"+
		"\5\20\u0091\n\20\3\21\3\21\3\21\5\21\u0096\n\21\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\5\23\u00a0\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00dc\n\24\3\25\3\25"+
		"\5\25\u00e0\n\25\3\26\3\26\3\26\3\26\5\26\u00e6\n\26\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\5\27\u00ef\n\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0103\n\27"+
		"\f\27\16\27\u0106\13\27\3\30\3\30\3\31\3\31\3\31\3\31\5\31\u010e\n\31"+
		"\3\32\3\32\3\32\3\32\3\32\5\32\u0115\n\32\3\33\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\5\34\u011f\n\34\3\34\2\3,\35\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\66\2\b\4\2\13\13\17\17\4\2\24\24\30\30\3\2"+
		"%&\3\2\'(\3\2).\3\2\63\64\2\u0125\28\3\2\2\2\4@\3\2\2\2\6G\3\2\2\2\bM"+
		"\3\2\2\2\nS\3\2\2\2\fU\3\2\2\2\16c\3\2\2\2\20e\3\2\2\2\22g\3\2\2\2\24"+
		"n\3\2\2\2\26t\3\2\2\2\30y\3\2\2\2\32{\3\2\2\2\34\u0089\3\2\2\2\36\u0090"+
		"\3\2\2\2 \u0095\3\2\2\2\"\u0097\3\2\2\2$\u009f\3\2\2\2&\u00db\3\2\2\2"+
		"(\u00df\3\2\2\2*\u00e5\3\2\2\2,\u00ee\3\2\2\2.\u0107\3\2\2\2\60\u010d"+
		"\3\2\2\2\62\u0114\3\2\2\2\64\u0116\3\2\2\2\66\u011e\3\2\2\289\7\22\2\2"+
		"9:\7\65\2\2:;\7\20\2\2;<\5\4\3\2<=\7\4\2\2=>\5\n\6\2>?\7\b\2\2?\3\3\2"+
		"\2\2@A\5\6\4\2AB\5\b\5\2B\5\3\2\2\2CD\5\f\7\2DE\5\6\4\2EH\3\2\2\2FH\3"+
		"\2\2\2GC\3\2\2\2GF\3\2\2\2H\7\3\2\2\2IJ\5\22\n\2JK\5\b\5\2KN\3\2\2\2L"+
		"N\3\2\2\2MI\3\2\2\2ML\3\2\2\2N\t\3\2\2\2OP\5\32\16\2PQ\5\n\6\2QT\3\2\2"+
		"\2RT\3\2\2\2SO\3\2\2\2SR\3\2\2\2T\13\3\2\2\2UV\7\27\2\2VW\7\65\2\2WX\7"+
		"\62\2\2XY\5\16\b\2YZ\7\35\2\2Z\r\3\2\2\2[d\5\20\t\2\\]\7\3\2\2]^\7 \2"+
		"\2^_\7\63\2\2_`\7!\2\2`a\7\21\2\2ad\5\20\t\2bd\7\65\2\2c[\3\2\2\2c\\\3"+
		"\2\2\2cb\3\2\2\2d\17\3\2\2\2ef\t\2\2\2f\21\3\2\2\2gh\5\24\13\2hi\5\26"+
		"\f\2ij\7\34\2\2jk\5\16\b\2kl\5\30\r\2lm\7\35\2\2m\23\3\2\2\2no\t\3\2\2"+
		"o\25\3\2\2\2pu\7\65\2\2qr\7\65\2\2rs\7\32\2\2su\5\26\f\2tp\3\2\2\2tq\3"+
		"\2\2\2u\27\3\2\2\2vw\7\61\2\2wz\5.\30\2xz\3\2\2\2yv\3\2\2\2yx\3\2\2\2"+
		"z\31\3\2\2\2{|\7\r\2\2|}\7\65\2\2}~\7\36\2\2~\177\5\34\17\2\177\u0080"+
		"\7\37\2\2\u0080\u0081\5 \21\2\u0081\u0082\7\4\2\2\u0082\u0083\5$\23\2"+
		"\u0083\u0084\7\b\2\2\u0084\33\3\2\2\2\u0085\u0086\5\"\22\2\u0086\u0087"+
		"\5\36\20\2\u0087\u008a\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0085\3\2\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\35\3\2\2\2\u008b\u008c\7\32\2\2\u008c\u008d"+
		"\5\"\22\2\u008d\u008e\5\36\20\2\u008e\u0091\3\2\2\2\u008f\u0091\3\2\2"+
		"\2\u0090\u008b\3\2\2\2\u0090\u008f\3\2\2\2\u0091\37\3\2\2\2\u0092\u0093"+
		"\7\34\2\2\u0093\u0096\5\16\b\2\u0094\u0096\3\2\2\2\u0095\u0092\3\2\2\2"+
		"\u0095\u0094\3\2\2\2\u0096!\3\2\2\2\u0097\u0098\7\65\2\2\u0098\u0099\7"+
		"\34\2\2\u0099\u009a\5\16\b\2\u009a#\3\2\2\2\u009b\u00a0\5&\24\2\u009c"+
		"\u009d\5&\24\2\u009d\u009e\5$\23\2\u009e\u00a0\3\2\2\2\u009f\u009b\3\2"+
		"\2\2\u009f\u009c\3\2\2\2\u00a0%\3\2\2\2\u00a1\u00a2\5\64\33\2\u00a2\u00a3"+
		"\7\61\2\2\u00a3\u00a4\5,\27\2\u00a4\u00a5\7\35\2\2\u00a5\u00dc\3\2\2\2"+
		"\u00a6\u00a7\7\16\2\2\u00a7\u00a8\5,\27\2\u00a8\u00a9\7\25\2\2\u00a9\u00aa"+
		"\5$\23\2\u00aa\u00ab\7\n\2\2\u00ab\u00ac\7\35\2\2\u00ac\u00dc\3\2\2\2"+
		"\u00ad\u00ae\7\16\2\2\u00ae\u00af\5,\27\2\u00af\u00b0\7\25\2\2\u00b0\u00b1"+
		"\5$\23\2\u00b1\u00b2\7\7\2\2\u00b2\u00b3\5$\23\2\u00b3\u00b4\7\n\2\2\u00b4"+
		"\u00b5\7\35\2\2\u00b5\u00dc\3\2\2\2\u00b6\u00b7\7\31\2\2\u00b7\u00b8\5"+
		",\27\2\u00b8\u00b9\7\6\2\2\u00b9\u00ba\5$\23\2\u00ba\u00bb\7\t\2\2\u00bb"+
		"\u00bc\7\35\2\2\u00bc\u00dc\3\2\2\2\u00bd\u00be\7\f\2\2\u00be\u00bf\7"+
		"\65\2\2\u00bf\u00c0\7\61\2\2\u00c0\u00c1\5,\27\2\u00c1\u00c2\7\26\2\2"+
		"\u00c2\u00c3\5,\27\2\u00c3\u00c4\7\6\2\2\u00c4\u00c5\5$\23\2\u00c5\u00c6"+
		"\7\t\2\2\u00c6\u00c7\7\35\2\2\u00c7\u00dc\3\2\2\2\u00c8\u00c9\5*\26\2"+
		"\u00c9\u00ca\7\65\2\2\u00ca\u00cb\7\36\2\2\u00cb\u00cc\5\60\31\2\u00cc"+
		"\u00cd\7\37\2\2\u00cd\u00ce\7\35\2\2\u00ce\u00dc\3\2\2\2\u00cf\u00d0\7"+
		"\5\2\2\u00d0\u00dc\7\35\2\2\u00d1\u00d2\7\23\2\2\u00d2\u00d3\5(\25\2\u00d3"+
		"\u00d4\7\35\2\2\u00d4\u00dc\3\2\2\2\u00d5\u00d6\7\20\2\2\u00d6\u00d7\5"+
		"\4\3\2\u00d7\u00d8\7\4\2\2\u00d8\u00d9\5$\23\2\u00d9\u00da\7\b\2\2\u00da"+
		"\u00dc\3\2\2\2\u00db\u00a1\3\2\2\2\u00db\u00a6\3\2\2\2\u00db\u00ad\3\2"+
		"\2\2\u00db\u00b6\3\2\2\2\u00db\u00bd\3\2\2\2\u00db\u00c8\3\2\2\2\u00db"+
		"\u00cf\3\2\2\2\u00db\u00d1\3\2\2\2\u00db\u00d5\3\2\2\2\u00dc\'\3\2\2\2"+
		"\u00dd\u00e0\5,\27\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de"+
		"\3\2\2\2\u00e0)\3\2\2\2\u00e1\u00e2\5\64\33\2\u00e2\u00e3\7\61\2\2\u00e3"+
		"\u00e6\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e4\3\2"+
		"\2\2\u00e6+\3\2\2\2\u00e7\u00e8\b\27\1\2\u00e8\u00ef\5.\30\2\u00e9\u00ef"+
		"\5\64\33\2\u00ea\u00eb\7\36\2\2\u00eb\u00ec\5,\27\2\u00ec\u00ed\7\37\2"+
		"\2\u00ed\u00ef\3\2\2\2\u00ee\u00e7\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ee\u00ea"+
		"\3\2\2\2\u00ef\u0104\3\2\2\2\u00f0\u00f1\f\b\2\2\u00f1\u00f2\7$\2\2\u00f2"+
		"\u0103\5,\27\b\u00f3\u00f4\f\7\2\2\u00f4\u00f5\t\4\2\2\u00f5\u0103\5,"+
		"\27\b\u00f6\u00f7\f\6\2\2\u00f7\u00f8\t\5\2\2\u00f8\u0103\5,\27\7\u00f9"+
		"\u00fa\f\5\2\2\u00fa\u00fb\t\6\2\2\u00fb\u0103\5,\27\6\u00fc\u00fd\f\4"+
		"\2\2\u00fd\u00fe\7/\2\2\u00fe\u0103\5,\27\5\u00ff\u0100\f\3\2\2\u0100"+
		"\u0101\7\60\2\2\u0101\u0103\5,\27\4\u0102\u00f0\3\2\2\2\u0102\u00f3\3"+
		"\2\2\2\u0102\u00f6\3\2\2\2\u0102\u00f9\3\2\2\2\u0102\u00fc\3\2\2\2\u0102"+
		"\u00ff\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104\u0105\3\2"+
		"\2\2\u0105-\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\t\7\2\2\u0108/\3\2"+
		"\2\2\u0109\u010a\5,\27\2\u010a\u010b\5\62\32\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010e\3\2\2\2\u010d\u0109\3\2\2\2\u010d\u010c\3\2\2\2\u010e\61\3\2\2"+
		"\2\u010f\u0110\7\32\2\2\u0110\u0111\5,\27\2\u0111\u0112\5\62\32\2\u0112"+
		"\u0115\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u010f\3\2\2\2\u0114\u0113\3\2"+
		"\2\2\u0115\63\3\2\2\2\u0116\u0117\7\65\2\2\u0117\u0118\5\66\34\2\u0118"+
		"\65\3\2\2\2\u0119\u011a\7 \2\2\u011a\u011b\5,\27\2\u011b\u011c\7!\2\2"+
		"\u011c\u011f\3\2\2\2\u011d\u011f\3\2\2\2\u011e\u0119\3\2\2\2\u011e\u011d"+
		"\3\2\2\2\u011f\67\3\2\2\2\25GMScty\u0089\u0090\u0095\u009f\u00db\u00df"+
		"\u00e5\u00ee\u0102\u0104\u010d\u0114\u011e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}