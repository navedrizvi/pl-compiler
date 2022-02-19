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
		public TerminalNode EOF() { return getToken(TigerParser.EOF, 0); }
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitMain(this);
			else return visitor.visitChildren(this);
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
			setState(61);
			match(EOF);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitDecl_seg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_segContext decl_seg() throws RecognitionException {
		Decl_segContext _localctx = new Decl_segContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl_seg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			type_decl_list();
			setState(64);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitType_decl_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_decl_listContext type_decl_list() throws RecognitionException {
		Type_decl_listContext _localctx = new Type_decl_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type_decl_list);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(66);
				type_decl();
				setState(67);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitVar_decl_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_decl_listContext var_decl_list() throws RecognitionException {
		Var_decl_listContext _localctx = new Var_decl_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_decl_list);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STATIC:
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				var_decl();
				setState(73);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitFunct_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Funct_listContext funct_list() throws RecognitionException {
		Funct_listContext _localctx = new Funct_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funct_list);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				funct();
				setState(79);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitType_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_declContext type_decl() throws RecognitionException {
		Type_declContext _localctx = new Type_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(TYPE);
			setState(85);
			match(ID);
			setState(86);
			match(TASSIGN);
			setState(87);
			type();
			setState(88);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeArrayContext extends TypeContext {
		public TerminalNode ARRAY() { return getToken(TigerParser.ARRAY, 0); }
		public TerminalNode OPENBRACK() { return getToken(TigerParser.OPENBRACK, 0); }
		public TerminalNode INTLIT() { return getToken(TigerParser.INTLIT, 0); }
		public TerminalNode CLOSEBRACK() { return getToken(TigerParser.CLOSEBRACK, 0); }
		public TerminalNode OF() { return getToken(TigerParser.OF, 0); }
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TypeArrayContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterTypeArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitTypeArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitTypeArray(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeIDContext extends TypeContext {
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TypeIDContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterTypeID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitTypeID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitTypeID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeBaseTypeContext extends TypeContext {
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public TypeBaseTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterTypeBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitTypeBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitTypeBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(98);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FLOAT:
			case INT:
				_localctx = new TypeBaseTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				base_type();
				}
				break;
			case ARRAY:
				_localctx = new TypeArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(ARRAY);
				setState(92);
				match(OPENBRACK);
				setState(93);
				match(INTLIT);
				setState(94);
				match(CLOSEBRACK);
				setState(95);
				match(OF);
				setState(96);
				base_type();
				}
				break;
			case ID:
				_localctx = new TypeIDContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
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
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
	 
		public Base_typeContext() { }
		public void copyFrom(Base_typeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BaseTypeFloatContext extends Base_typeContext {
		public TerminalNode FLOAT() { return getToken(TigerParser.FLOAT, 0); }
		public BaseTypeFloatContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterBaseTypeFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitBaseTypeFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitBaseTypeFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseTypeIntContext extends Base_typeContext {
		public TerminalNode INT() { return getToken(TigerParser.INT, 0); }
		public BaseTypeIntContext(Base_typeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterBaseTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitBaseTypeInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitBaseTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_base_type);
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new BaseTypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new BaseTypeFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(101);
				match(FLOAT);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			storage_class();
			setState(105);
			id_list();
			setState(106);
			match(COLON);
			setState(107);
			type();
			setState(108);
			optional_init();
			setState(109);
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
		public Storage_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage_class; }
	 
		public Storage_classContext() { }
		public void copyFrom(Storage_classContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StorageClassStaticContext extends Storage_classContext {
		public TerminalNode STATIC() { return getToken(TigerParser.STATIC, 0); }
		public StorageClassStaticContext(Storage_classContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStorageClassStatic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStorageClassStatic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStorageClassStatic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StorageClassVarContext extends Storage_classContext {
		public TerminalNode VAR() { return getToken(TigerParser.VAR, 0); }
		public StorageClassVarContext(Storage_classContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStorageClassVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStorageClassVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStorageClassVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Storage_classContext storage_class() throws RecognitionException {
		Storage_classContext _localctx = new Storage_classContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_storage_class);
		try {
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new StorageClassVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(VAR);
				}
				break;
			case STATIC:
				_localctx = new StorageClassStaticContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(STATIC);
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

	public static class Id_listContext extends ParserRuleContext {
		public Id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_list; }
	 
		public Id_listContext() { }
		public void copyFrom(Id_listContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdListIdContext extends Id_listContext {
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public IdListIdContext(Id_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterIdListId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitIdListId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitIdListId(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdListContext extends Id_listContext {
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode COMMA() { return getToken(TigerParser.COMMA, 0); }
		public Id_listContext id_list() {
			return getRuleContext(Id_listContext.class,0);
		}
		public IdListContext(Id_listContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterIdList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitIdList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitIdList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Id_listContext id_list() throws RecognitionException {
		Id_listContext _localctx = new Id_listContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_id_list);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new IdListIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(115);
				match(ID);
				}
				break;
			case 2:
				_localctx = new IdListContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(ID);
				setState(117);
				match(COMMA);
				setState(118);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitOptional_init(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Optional_initContext optional_init() throws RecognitionException {
		Optional_initContext _localctx = new Optional_initContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_optional_init);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ASSIGN:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(ASSIGN);
				setState(122);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitFunct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctContext funct() throws RecognitionException {
		FunctContext _localctx = new FunctContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(FUNCTION);
			setState(127);
			match(ID);
			setState(128);
			match(OPENPAREN);
			setState(129);
			param_list();
			setState(130);
			match(CLOSEPAREN);
			setState(131);
			return_type();
			setState(132);
			match(BEGIN);
			setState(133);
			stat_seq();
			setState(134);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitParam_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_listContext param_list() throws RecognitionException {
		Param_listContext _localctx = new Param_listContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_param_list);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				param();
				setState(137);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitParam_list_tail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_list_tailContext param_list_tail() throws RecognitionException {
		Param_list_tailContext _localctx = new Param_list_tailContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param_list_tail);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(COMMA);
				setState(143);
				param();
				setState(144);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitReturn_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_return_type);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				match(COLON);
				setState(150);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ID);
			setState(155);
			match(COLON);
			setState(156);
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
		public Stat_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat_seq; }
	 
		public Stat_seqContext() { }
		public void copyFrom(Stat_seqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatSingleContext extends Stat_seqContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public StatSingleContext(Stat_seqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatSingle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatSeqContext extends Stat_seqContext {
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Stat_seqContext stat_seq() {
			return getRuleContext(Stat_seqContext.class,0);
		}
		public StatSeqContext(Stat_seqContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatSeq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stat_seqContext stat_seq() throws RecognitionException {
		Stat_seqContext _localctx = new Stat_seqContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_stat_seq);
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new StatSingleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				stat();
				}
				break;
			case 2:
				_localctx = new StatSeqContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				stat();
				setState(160);
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
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatForContext extends StatContext {
		public TerminalNode FOR() { return getToken(TigerParser.FOR, 0); }
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(TigerParser.ASSIGN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TO() { return getToken(TigerParser.TO, 0); }
		public TerminalNode DO() { return getToken(TigerParser.DO, 0); }
		public Stat_seqContext stat_seq() {
			return getRuleContext(Stat_seqContext.class,0);
		}
		public TerminalNode ENDDO() { return getToken(TigerParser.ENDDO, 0); }
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public StatForContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatFor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatIfContext extends StatContext {
		public TerminalNode IF() { return getToken(TigerParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(TigerParser.THEN, 0); }
		public Stat_seqContext stat_seq() {
			return getRuleContext(Stat_seqContext.class,0);
		}
		public TerminalNode ENDIF() { return getToken(TigerParser.ENDIF, 0); }
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public StatIfContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatIf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatLetContext extends StatContext {
		public TerminalNode LET() { return getToken(TigerParser.LET, 0); }
		public Decl_segContext decl_seg() {
			return getRuleContext(Decl_segContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(TigerParser.BEGIN, 0); }
		public Stat_seqContext stat_seq() {
			return getRuleContext(Stat_seqContext.class,0);
		}
		public TerminalNode END() { return getToken(TigerParser.END, 0); }
		public StatLetContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatLet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatLet(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatBreakContext extends StatContext {
		public TerminalNode BREAK() { return getToken(TigerParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public StatBreakContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatBreak(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatFunctionCallContext extends StatContext {
		public Opt_prefixContext opt_prefix() {
			return getRuleContext(Opt_prefixContext.class,0);
		}
		public TerminalNode ID() { return getToken(TigerParser.ID, 0); }
		public TerminalNode OPENPAREN() { return getToken(TigerParser.OPENPAREN, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode CLOSEPAREN() { return getToken(TigerParser.CLOSEPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public StatFunctionCallContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatIfElseContext extends StatContext {
		public TerminalNode IF() { return getToken(TigerParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(TigerParser.THEN, 0); }
		public List<Stat_seqContext> stat_seq() {
			return getRuleContexts(Stat_seqContext.class);
		}
		public Stat_seqContext stat_seq(int i) {
			return getRuleContext(Stat_seqContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(TigerParser.ELSE, 0); }
		public TerminalNode ENDIF() { return getToken(TigerParser.ENDIF, 0); }
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public StatIfElseContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatIfElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatIfElse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatWhileContext extends StatContext {
		public TerminalNode WHILE() { return getToken(TigerParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DO() { return getToken(TigerParser.DO, 0); }
		public Stat_seqContext stat_seq() {
			return getRuleContext(Stat_seqContext.class,0);
		}
		public TerminalNode ENDDO() { return getToken(TigerParser.ENDDO, 0); }
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public StatWhileContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatReturnContext extends StatContext {
		public TerminalNode RETURN() { return getToken(TigerParser.RETURN, 0); }
		public Opt_returnContext opt_return() {
			return getRuleContext(Opt_returnContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public StatReturnContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StatAssignContext extends StatContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(TigerParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(TigerParser.SEMICOLON, 0); }
		public StatAssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterStatAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitStatAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitStatAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_stat);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new StatAssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				value();
				setState(165);
				match(ASSIGN);
				setState(166);
				expr(0);
				setState(167);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new StatIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(IF);
				setState(170);
				expr(0);
				setState(171);
				match(THEN);
				setState(172);
				stat_seq();
				setState(173);
				match(ENDIF);
				setState(174);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new StatIfElseContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(176);
				match(IF);
				setState(177);
				expr(0);
				setState(178);
				match(THEN);
				setState(179);
				stat_seq();
				setState(180);
				match(ELSE);
				setState(181);
				stat_seq();
				setState(182);
				match(ENDIF);
				setState(183);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new StatWhileContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(185);
				match(WHILE);
				setState(186);
				expr(0);
				setState(187);
				match(DO);
				setState(188);
				stat_seq();
				setState(189);
				match(ENDDO);
				setState(190);
				match(SEMICOLON);
				}
				break;
			case 5:
				_localctx = new StatForContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(192);
				match(FOR);
				setState(193);
				match(ID);
				setState(194);
				match(ASSIGN);
				setState(195);
				expr(0);
				setState(196);
				match(TO);
				setState(197);
				expr(0);
				setState(198);
				match(DO);
				setState(199);
				stat_seq();
				setState(200);
				match(ENDDO);
				setState(201);
				match(SEMICOLON);
				}
				break;
			case 6:
				_localctx = new StatFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(203);
				opt_prefix();
				setState(204);
				match(ID);
				setState(205);
				match(OPENPAREN);
				setState(206);
				expr_list();
				setState(207);
				match(CLOSEPAREN);
				setState(208);
				match(SEMICOLON);
				}
				break;
			case 7:
				_localctx = new StatBreakContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(210);
				match(BREAK);
				setState(211);
				match(SEMICOLON);
				}
				break;
			case 8:
				_localctx = new StatReturnContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(212);
				match(RETURN);
				setState(213);
				opt_return();
				setState(214);
				match(SEMICOLON);
				}
				break;
			case 9:
				_localctx = new StatLetContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(216);
				match(LET);
				setState(217);
				decl_seg();
				setState(218);
				match(BEGIN);
				setState(219);
				stat_seq();
				setState(220);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitOpt_return(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Opt_returnContext opt_return() throws RecognitionException {
		Opt_returnContext _localctx = new Opt_returnContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_opt_return);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENPAREN:
			case INTLIT:
			case FLOATLIT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitOpt_prefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Opt_prefixContext opt_prefix() throws RecognitionException {
		Opt_prefixContext _localctx = new Opt_prefixContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_opt_prefix);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(228);
				value();
				setState(229);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprAddSubContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(TigerParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TigerParser.MINUS, 0); }
		public ExprAddSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExprAddSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExprAddSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExprAddSub(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprAndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(TigerParser.AND, 0); }
		public ExprAndContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExprAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprPowContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(TigerParser.POW, 0); }
		public ExprPowContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExprPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExprPow(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExprPow(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExporOrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(TigerParser.OR, 0); }
		public ExporOrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExporOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExporOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExporOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprParenContext extends ExprContext {
		public TerminalNode OPENPAREN() { return getToken(TigerParser.OPENPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSEPAREN() { return getToken(TigerParser.CLOSEPAREN, 0); }
		public ExprParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExprParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExprParen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExprParen(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprValueContext extends ExprContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ExprValueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExprValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExprValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExprValue(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprCompContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUAL() { return getToken(TigerParser.EQUAL, 0); }
		public TerminalNode NEQUAL() { return getToken(TigerParser.NEQUAL, 0); }
		public TerminalNode LESS() { return getToken(TigerParser.LESS, 0); }
		public TerminalNode GREAT() { return getToken(TigerParser.GREAT, 0); }
		public TerminalNode LESSEQ() { return getToken(TigerParser.LESSEQ, 0); }
		public TerminalNode GREATEQ() { return getToken(TigerParser.GREATEQ, 0); }
		public ExprCompContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExprComp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExprComp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExprComp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprMultDivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULT() { return getToken(TigerParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(TigerParser.DIV, 0); }
		public ExprMultDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExprMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExprMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExprMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprConstantContext extends ExprContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ExprConstantContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterExprConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitExprConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExprConstant(this);
			else return visitor.visitChildren(this);
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
			setState(241);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTLIT:
			case FLOATLIT:
				{
				_localctx = new ExprConstantContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(235);
				constant();
				}
				break;
			case ID:
				{
				_localctx = new ExprValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				value();
				}
				break;
			case OPENPAREN:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(OPENPAREN);
				setState(238);
				expr(0);
				setState(239);
				match(CLOSEPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(263);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(261);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprPowContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(244);
						match(POW);
						setState(245);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprMultDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(247);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprAddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(249);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(250);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new ExprCompContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(252);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(253);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUAL) | (1L << NEQUAL) | (1L << LESS) | (1L << GREAT) | (1L << LESSEQ) | (1L << GREATEQ))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(254);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(255);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(256);
						match(AND);
						setState(257);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new ExporOrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(258);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(259);
						match(OR);
						setState(260);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(265);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstantIntLitContext extends ConstantContext {
		public TerminalNode INTLIT() { return getToken(TigerParser.INTLIT, 0); }
		public ConstantIntLitContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterConstantIntLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitConstantIntLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitConstantIntLit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantFloatLitContext extends ConstantContext {
		public TerminalNode FLOATLIT() { return getToken(TigerParser.FLOATLIT, 0); }
		public ConstantFloatLitContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).enterConstantFloatLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TigerListener ) ((TigerListener)listener).exitConstantFloatLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitConstantFloatLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constant);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTLIT:
				_localctx = new ConstantIntLitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				match(INTLIT);
				}
				break;
			case FLOATLIT:
				_localctx = new ConstantFloatLitContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(FLOATLIT);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExpr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr_list);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPENPAREN:
			case INTLIT:
			case FLOATLIT:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitExpr_list_tail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_list_tailContext expr_list_tail() throws RecognitionException {
		Expr_list_tailContext _localctx = new Expr_list_tailContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expr_list_tail);
		try {
			setState(281);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMMA:
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				match(COMMA);
				setState(277);
				expr(0);
				setState(278);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(ID);
			setState(284);
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
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TigerVisitor ) return ((TigerVisitor<? extends T>)visitor).visitValue_tail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_tailContext value_tail() throws RecognitionException {
		Value_tailContext _localctx = new Value_tailContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_value_tail);
		try {
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				match(OPENBRACK);
				setState(287);
				expr(0);
				setState(288);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\u0128\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\5\5O\n\5\3\6\3\6\3\6"+
		"\3\6\5\6U\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\5\be\n\b\3\t\3\t\5\ti\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\5\13"+
		"t\n\13\3\f\3\f\3\f\3\f\5\fz\n\f\3\r\3\r\3\r\5\r\177\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\5\17\u008f\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u0096\n\20\3\21\3\21\3\21\5\21\u009b\n"+
		"\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00a5\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\5\24\u00e1\n\24\3\25\3\25\5\25\u00e5\n\25\3\26\3\26\3\26\3\26\5\26\u00eb"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00f4\n\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\7\27\u0108\n\27\f\27\16\27\u010b\13\27\3\30\3\30\5\30\u010f\n\30"+
		"\3\31\3\31\3\31\3\31\5\31\u0115\n\31\3\32\3\32\3\32\3\32\3\32\5\32\u011c"+
		"\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\5\34\u0126\n\34\3\34\2\3"+
		",\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\5\3"+
		"\2%&\3\2\'(\3\2).\2\u012f\28\3\2\2\2\4A\3\2\2\2\6H\3\2\2\2\bN\3\2\2\2"+
		"\nT\3\2\2\2\fV\3\2\2\2\16d\3\2\2\2\20h\3\2\2\2\22j\3\2\2\2\24s\3\2\2\2"+
		"\26y\3\2\2\2\30~\3\2\2\2\32\u0080\3\2\2\2\34\u008e\3\2\2\2\36\u0095\3"+
		"\2\2\2 \u009a\3\2\2\2\"\u009c\3\2\2\2$\u00a4\3\2\2\2&\u00e0\3\2\2\2(\u00e4"+
		"\3\2\2\2*\u00ea\3\2\2\2,\u00f3\3\2\2\2.\u010e\3\2\2\2\60\u0114\3\2\2\2"+
		"\62\u011b\3\2\2\2\64\u011d\3\2\2\2\66\u0125\3\2\2\289\7\22\2\29:\7\65"+
		"\2\2:;\7\20\2\2;<\5\4\3\2<=\7\4\2\2=>\5\n\6\2>?\7\b\2\2?@\7\2\2\3@\3\3"+
		"\2\2\2AB\5\6\4\2BC\5\b\5\2C\5\3\2\2\2DE\5\f\7\2EF\5\6\4\2FI\3\2\2\2GI"+
		"\3\2\2\2HD\3\2\2\2HG\3\2\2\2I\7\3\2\2\2JK\5\22\n\2KL\5\b\5\2LO\3\2\2\2"+
		"MO\3\2\2\2NJ\3\2\2\2NM\3\2\2\2O\t\3\2\2\2PQ\5\32\16\2QR\5\n\6\2RU\3\2"+
		"\2\2SU\3\2\2\2TP\3\2\2\2TS\3\2\2\2U\13\3\2\2\2VW\7\27\2\2WX\7\65\2\2X"+
		"Y\7\62\2\2YZ\5\16\b\2Z[\7\35\2\2[\r\3\2\2\2\\e\5\20\t\2]^\7\3\2\2^_\7"+
		" \2\2_`\7\63\2\2`a\7!\2\2ab\7\21\2\2be\5\20\t\2ce\7\65\2\2d\\\3\2\2\2"+
		"d]\3\2\2\2dc\3\2\2\2e\17\3\2\2\2fi\7\17\2\2gi\7\13\2\2hf\3\2\2\2hg\3\2"+
		"\2\2i\21\3\2\2\2jk\5\24\13\2kl\5\26\f\2lm\7\34\2\2mn\5\16\b\2no\5\30\r"+
		"\2op\7\35\2\2p\23\3\2\2\2qt\7\30\2\2rt\7\24\2\2sq\3\2\2\2sr\3\2\2\2t\25"+
		"\3\2\2\2uz\7\65\2\2vw\7\65\2\2wx\7\32\2\2xz\5\26\f\2yu\3\2\2\2yv\3\2\2"+
		"\2z\27\3\2\2\2{|\7\61\2\2|\177\5.\30\2}\177\3\2\2\2~{\3\2\2\2~}\3\2\2"+
		"\2\177\31\3\2\2\2\u0080\u0081\7\r\2\2\u0081\u0082\7\65\2\2\u0082\u0083"+
		"\7\36\2\2\u0083\u0084\5\34\17\2\u0084\u0085\7\37\2\2\u0085\u0086\5 \21"+
		"\2\u0086\u0087\7\4\2\2\u0087\u0088\5$\23\2\u0088\u0089\7\b\2\2\u0089\33"+
		"\3\2\2\2\u008a\u008b\5\"\22\2\u008b\u008c\5\36\20\2\u008c\u008f\3\2\2"+
		"\2\u008d\u008f\3\2\2\2\u008e\u008a\3\2\2\2\u008e\u008d\3\2\2\2\u008f\35"+
		"\3\2\2\2\u0090\u0091\7\32\2\2\u0091\u0092\5\"\22\2\u0092\u0093\5\36\20"+
		"\2\u0093\u0096\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0090\3\2\2\2\u0095\u0094"+
		"\3\2\2\2\u0096\37\3\2\2\2\u0097\u0098\7\34\2\2\u0098\u009b\5\16\b\2\u0099"+
		"\u009b\3\2\2\2\u009a\u0097\3\2\2\2\u009a\u0099\3\2\2\2\u009b!\3\2\2\2"+
		"\u009c\u009d\7\65\2\2\u009d\u009e\7\34\2\2\u009e\u009f\5\16\b\2\u009f"+
		"#\3\2\2\2\u00a0\u00a5\5&\24\2\u00a1\u00a2\5&\24\2\u00a2\u00a3\5$\23\2"+
		"\u00a3\u00a5\3\2\2\2\u00a4\u00a0\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5%\3"+
		"\2\2\2\u00a6\u00a7\5\64\33\2\u00a7\u00a8\7\61\2\2\u00a8\u00a9\5,\27\2"+
		"\u00a9\u00aa\7\35\2\2\u00aa\u00e1\3\2\2\2\u00ab\u00ac\7\16\2\2\u00ac\u00ad"+
		"\5,\27\2\u00ad\u00ae\7\25\2\2\u00ae\u00af\5$\23\2\u00af\u00b0\7\n\2\2"+
		"\u00b0\u00b1\7\35\2\2\u00b1\u00e1\3\2\2\2\u00b2\u00b3\7\16\2\2\u00b3\u00b4"+
		"\5,\27\2\u00b4\u00b5\7\25\2\2\u00b5\u00b6\5$\23\2\u00b6\u00b7\7\7\2\2"+
		"\u00b7\u00b8\5$\23\2\u00b8\u00b9\7\n\2\2\u00b9\u00ba\7\35\2\2\u00ba\u00e1"+
		"\3\2\2\2\u00bb\u00bc\7\31\2\2\u00bc\u00bd\5,\27\2\u00bd\u00be\7\6\2\2"+
		"\u00be\u00bf\5$\23\2\u00bf\u00c0\7\t\2\2\u00c0\u00c1\7\35\2\2\u00c1\u00e1"+
		"\3\2\2\2\u00c2\u00c3\7\f\2\2\u00c3\u00c4\7\65\2\2\u00c4\u00c5\7\61\2\2"+
		"\u00c5\u00c6\5,\27\2\u00c6\u00c7\7\26\2\2\u00c7\u00c8\5,\27\2\u00c8\u00c9"+
		"\7\6\2\2\u00c9\u00ca\5$\23\2\u00ca\u00cb\7\t\2\2\u00cb\u00cc\7\35\2\2"+
		"\u00cc\u00e1\3\2\2\2\u00cd\u00ce\5*\26\2\u00ce\u00cf\7\65\2\2\u00cf\u00d0"+
		"\7\36\2\2\u00d0\u00d1\5\60\31\2\u00d1\u00d2\7\37\2\2\u00d2\u00d3\7\35"+
		"\2\2\u00d3\u00e1\3\2\2\2\u00d4\u00d5\7\5\2\2\u00d5\u00e1\7\35\2\2\u00d6"+
		"\u00d7\7\23\2\2\u00d7\u00d8\5(\25\2\u00d8\u00d9\7\35\2\2\u00d9\u00e1\3"+
		"\2\2\2\u00da\u00db\7\20\2\2\u00db\u00dc\5\4\3\2\u00dc\u00dd\7\4\2\2\u00dd"+
		"\u00de\5$\23\2\u00de\u00df\7\b\2\2\u00df\u00e1\3\2\2\2\u00e0\u00a6\3\2"+
		"\2\2\u00e0\u00ab\3\2\2\2\u00e0\u00b2\3\2\2\2\u00e0\u00bb\3\2\2\2\u00e0"+
		"\u00c2\3\2\2\2\u00e0\u00cd\3\2\2\2\u00e0\u00d4\3\2\2\2\u00e0\u00d6\3\2"+
		"\2\2\u00e0\u00da\3\2\2\2\u00e1\'\3\2\2\2\u00e2\u00e5\5,\27\2\u00e3\u00e5"+
		"\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5)\3\2\2\2\u00e6"+
		"\u00e7\5\64\33\2\u00e7\u00e8\7\61\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00eb"+
		"\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb+\3\2\2\2\u00ec"+
		"\u00ed\b\27\1\2\u00ed\u00f4\5.\30\2\u00ee\u00f4\5\64\33\2\u00ef\u00f0"+
		"\7\36\2\2\u00f0\u00f1\5,\27\2\u00f1\u00f2\7\37\2\2\u00f2\u00f4\3\2\2\2"+
		"\u00f3\u00ec\3\2\2\2\u00f3\u00ee\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f4\u0109"+
		"\3\2\2\2\u00f5\u00f6\f\b\2\2\u00f6\u00f7\7$\2\2\u00f7\u0108\5,\27\b\u00f8"+
		"\u00f9\f\7\2\2\u00f9\u00fa\t\2\2\2\u00fa\u0108\5,\27\b\u00fb\u00fc\f\6"+
		"\2\2\u00fc\u00fd\t\3\2\2\u00fd\u0108\5,\27\7\u00fe\u00ff\f\5\2\2\u00ff"+
		"\u0100\t\4\2\2\u0100\u0108\5,\27\6\u0101\u0102\f\4\2\2\u0102\u0103\7/"+
		"\2\2\u0103\u0108\5,\27\5\u0104\u0105\f\3\2\2\u0105\u0106\7\60\2\2\u0106"+
		"\u0108\5,\27\4\u0107\u00f5\3\2\2\2\u0107\u00f8\3\2\2\2\u0107\u00fb\3\2"+
		"\2\2\u0107\u00fe\3\2\2\2\u0107\u0101\3\2\2\2\u0107\u0104\3\2\2\2\u0108"+
		"\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a-\3\2\2\2"+
		"\u010b\u0109\3\2\2\2\u010c\u010f\7\63\2\2\u010d\u010f\7\64\2\2\u010e\u010c"+
		"\3\2\2\2\u010e\u010d\3\2\2\2\u010f/\3\2\2\2\u0110\u0111\5,\27\2\u0111"+
		"\u0112\5\62\32\2\u0112\u0115\3\2\2\2\u0113\u0115\3\2\2\2\u0114\u0110\3"+
		"\2\2\2\u0114\u0113\3\2\2\2\u0115\61\3\2\2\2\u0116\u0117\7\32\2\2\u0117"+
		"\u0118\5,\27\2\u0118\u0119\5\62\32\2\u0119\u011c\3\2\2\2\u011a\u011c\3"+
		"\2\2\2\u011b\u0116\3\2\2\2\u011b\u011a\3\2\2\2\u011c\63\3\2\2\2\u011d"+
		"\u011e\7\65\2\2\u011e\u011f\5\66\34\2\u011f\65\3\2\2\2\u0120\u0121\7 "+
		"\2\2\u0121\u0122\5,\27\2\u0122\u0123\7!\2\2\u0123\u0126\3\2\2\2\u0124"+
		"\u0126\3\2\2\2\u0125\u0120\3\2\2\2\u0125\u0124\3\2\2\2\u0126\67\3\2\2"+
		"\2\30HNTdhsy~\u008e\u0095\u009a\u00a4\u00e0\u00e4\u00ea\u00f3\u0107\u0109"+
		"\u010e\u0114\u011b\u0125";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}