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
		OPENCURLY=32, CLOSECURLY=33, PLUS=34, MINUS=35, MULT=36, DIV=37, POW=38, 
		EQUAL=39, NEQUAL=40, LESS=41, GREAT=42, LESSEQ=43, GREATED=44, AND=45, 
		OR=46, ASSIGN=47, TASSIGN=48, INTLIT=49, FLOATLIT=50, ID=51, COMMENT=52, 
		WS=53;
	public static final int
		RULE_main = 0, RULE_decl_seg = 1, RULE_type_decl_list = 2, RULE_var_decl_list = 3, 
		RULE_funct_list = 4, RULE_type_decl = 5, RULE_type = 6, RULE_base_type = 7, 
		RULE_var_decl = 8, RULE_storage_class = 9, RULE_id_list = 10, RULE_optional_init = 11, 
		RULE_funct = 12, RULE_param_list = 13, RULE_param_list_tail = 14, RULE_return_type = 15, 
		RULE_param = 16, RULE_stat_seq = 17, RULE_stat = 18, RULE_constant = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"main", "decl_seg", "type_decl_list", "var_decl_list", "funct_list", 
			"type_decl", "type", "base_type", "var_decl", "storage_class", "id_list", 
			"optional_init", "funct", "param_list", "param_list_tail", "return_type", 
			"param", "stat_seq", "stat", "constant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'array'", "'begin'", "'break'", "'do'", "'else'", "'end'", "'enddo'", 
			"'endif'", "'float'", "'for'", "'function'", "'if'", "'int'", "'let'", 
			"'of'", "'program'", "'return'", "'static'", "'then'", "'to'", "'type'", 
			"'var'", "'while'", "','", "'.'", "':'", "';'", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'+'", "'-'", "'*'", "'/'", "'**'", "'=='", "'!='", 
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
			"CLOSECURLY", "PLUS", "MINUS", "MULT", "DIV", "POW", "EQUAL", "NEQUAL", 
			"LESS", "GREAT", "LESSEQ", "GREATED", "AND", "OR", "ASSIGN", "TASSIGN", 
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
			setState(40);
			match(PROGRAM);
			setState(41);
			match(ID);
			setState(42);
			match(LET);
			setState(43);
			decl_seg();
			setState(44);
			match(BEGIN);
			setState(45);
			funct_list();
			setState(46);
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
			setState(48);
			type_decl_list();
			setState(49);
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
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				type_decl();
				setState(52);
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
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STATIC:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				var_decl();
				setState(58);
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
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				funct();
				setState(64);
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
			setState(69);
			match(TYPE);
			setState(70);
			match(ID);
			setState(71);
			match(TASSIGN);
			setState(72);
			type();
			setState(73);
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
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				base_type();
				}
				break;
			case ARRAY:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(ARRAY);
				setState(77);
				match(OPENBRACK);
				setState(78);
				match(INTLIT);
				setState(79);
				match(CLOSEBRACK);
				setState(80);
				match(OF);
				setState(81);
				base_type();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(82);
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
			setState(85);
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
			setState(87);
			storage_class();
			setState(88);
			id_list();
			setState(89);
			match(COLON);
			setState(90);
			type();
			setState(91);
			optional_init();
			setState(92);
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
			setState(94);
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
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(ID);
				setState(98);
				match(COMMA);
				setState(99);
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
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				match(ASSIGN);
				setState(103);
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
			setState(107);
			match(FUNCTION);
			setState(108);
			match(ID);
			setState(109);
			match(OPENPAREN);
			setState(110);
			param_list();
			setState(111);
			match(CLOSEPAREN);
			setState(112);
			return_type();
			setState(113);
			match(BEGIN);
			setState(114);
			stat_seq();
			setState(115);
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
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				param();
				setState(118);
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
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(COMMA);
				setState(124);
				param();
				setState(125);
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
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(COLON);
				setState(131);
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
			setState(135);
			match(ID);
			setState(136);
			match(COLON);
			setState(137);
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
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				stat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				stat();
				setState(141);
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
		public TerminalNode BREAK() { return getToken(TigerParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(BREAK);
			setState(146);
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
		enterRule(_localctx, 38, RULE_constant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0099\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\5\5@\n\5\3\6\3\6\3\6\3\6"+
		"\5\6F\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"V\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\5"+
		"\fg\n\f\3\r\3\r\3\r\5\rl\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\5\17|\n\17\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u0083\n\20\3\21\3\21\3\21\5\21\u0088\n\21\3\22\3\22\3\22\3\22\3\23\3"+
		"\23\3\23\3\23\5\23\u0092\n\23\3\24\3\24\3\24\3\25\3\25\3\25\2\2\26\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\5\4\2\13\13\17\17\4\2\24\24"+
		"\30\30\3\2\63\64\2\u008f\2*\3\2\2\2\4\62\3\2\2\2\69\3\2\2\2\b?\3\2\2\2"+
		"\nE\3\2\2\2\fG\3\2\2\2\16U\3\2\2\2\20W\3\2\2\2\22Y\3\2\2\2\24`\3\2\2\2"+
		"\26f\3\2\2\2\30k\3\2\2\2\32m\3\2\2\2\34{\3\2\2\2\36\u0082\3\2\2\2 \u0087"+
		"\3\2\2\2\"\u0089\3\2\2\2$\u0091\3\2\2\2&\u0093\3\2\2\2(\u0096\3\2\2\2"+
		"*+\7\22\2\2+,\7\65\2\2,-\7\20\2\2-.\5\4\3\2./\7\4\2\2/\60\5\n\6\2\60\61"+
		"\7\b\2\2\61\3\3\2\2\2\62\63\5\6\4\2\63\64\5\b\5\2\64\5\3\2\2\2\65\66\5"+
		"\f\7\2\66\67\5\6\4\2\67:\3\2\2\28:\3\2\2\29\65\3\2\2\298\3\2\2\2:\7\3"+
		"\2\2\2;<\5\22\n\2<=\5\b\5\2=@\3\2\2\2>@\3\2\2\2?;\3\2\2\2?>\3\2\2\2@\t"+
		"\3\2\2\2AB\5\32\16\2BC\5\n\6\2CF\3\2\2\2DF\3\2\2\2EA\3\2\2\2ED\3\2\2\2"+
		"F\13\3\2\2\2GH\7\27\2\2HI\7\65\2\2IJ\7\62\2\2JK\5\16\b\2KL\7\35\2\2L\r"+
		"\3\2\2\2MV\5\20\t\2NO\7\3\2\2OP\7 \2\2PQ\7\63\2\2QR\7!\2\2RS\7\21\2\2"+
		"SV\5\20\t\2TV\7\65\2\2UM\3\2\2\2UN\3\2\2\2UT\3\2\2\2V\17\3\2\2\2WX\t\2"+
		"\2\2X\21\3\2\2\2YZ\5\24\13\2Z[\5\26\f\2[\\\7\34\2\2\\]\5\16\b\2]^\5\30"+
		"\r\2^_\7\35\2\2_\23\3\2\2\2`a\t\3\2\2a\25\3\2\2\2bg\7\65\2\2cd\7\65\2"+
		"\2de\7\32\2\2eg\5\26\f\2fb\3\2\2\2fc\3\2\2\2g\27\3\2\2\2hi\7\61\2\2il"+
		"\5(\25\2jl\3\2\2\2kh\3\2\2\2kj\3\2\2\2l\31\3\2\2\2mn\7\r\2\2no\7\65\2"+
		"\2op\7\36\2\2pq\5\34\17\2qr\7\37\2\2rs\5 \21\2st\7\4\2\2tu\5$\23\2uv\7"+
		"\b\2\2v\33\3\2\2\2wx\5\"\22\2xy\5\36\20\2y|\3\2\2\2z|\3\2\2\2{w\3\2\2"+
		"\2{z\3\2\2\2|\35\3\2\2\2}~\7\32\2\2~\177\5\"\22\2\177\u0080\5\36\20\2"+
		"\u0080\u0083\3\2\2\2\u0081\u0083\3\2\2\2\u0082}\3\2\2\2\u0082\u0081\3"+
		"\2\2\2\u0083\37\3\2\2\2\u0084\u0085\7\34\2\2\u0085\u0088\5\16\b\2\u0086"+
		"\u0088\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0086\3\2\2\2\u0088!\3\2\2\2"+
		"\u0089\u008a\7\65\2\2\u008a\u008b\7\34\2\2\u008b\u008c\5\16\b\2\u008c"+
		"#\3\2\2\2\u008d\u0092\5&\24\2\u008e\u008f\5&\24\2\u008f\u0090\5$\23\2"+
		"\u0090\u0092\3\2\2\2\u0091\u008d\3\2\2\2\u0091\u008e\3\2\2\2\u0092%\3"+
		"\2\2\2\u0093\u0094\7\5\2\2\u0094\u0095\7\35\2\2\u0095\'\3\2\2\2\u0096"+
		"\u0097\t\4\2\2\u0097)\3\2\2\2\f9?EUfk{\u0082\u0087\u0091";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}