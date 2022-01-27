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
		COLON=26, SEMICOLON=27, OPENPAR=28, CLOSEPAR=29, OPENBRACK=30, CLOSEBRACK=31, 
		OPENCURLY=32, CLOSECURLY=33, PLUS=34, MINUS=35, MULT=36, DIV=37, POW=38, 
		EQUAL=39, NEQUAL=40, LESS=41, GREAT=42, LESSEQ=43, GREATED=44, AND=45, 
		OR=46, ASSIGN=47, TASSIGN=48, INTLIT=49, FLOATLIT=50, ID=51, COMMENT=52, 
		WS=53;
	public static final int
		RULE_main = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"main"
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
			"SEMICOLON", "OPENPAR", "CLOSEPAR", "OPENBRACK", "CLOSEBRACK", "OPENCURLY", 
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
			setState(2);
			match(PROGRAM);
			setState(3);
			match(ID);
			setState(4);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\67\t\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\2\2\3\2\2\2\2\7\2\4\3\2\2\2\4\5\7\22\2\2\5\6\7\65\2\2"+
		"\6\7\7\b\2\2\7\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}