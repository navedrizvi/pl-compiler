// Generated from Tiger.g4 by ANTLR 4.9.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TigerLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ARRAY", "BEGIN", "BREAK", "DO", "ELSE", "END", "ENDDO", "ENDIF", "FLOAT", 
			"FOR", "FUNCTION", "IF", "INT", "LET", "OF", "PROGRAM", "RETURN", "STATIC", 
			"THEN", "TO", "TYPE", "VAR", "WHILE", "COMMA", "DOT", "COLON", "SEMICOLON", 
			"OPENPAR", "CLOSEPAR", "OPENBRACK", "CLOSEBRACK", "OPENCURLY", "CLOSECURLY", 
			"PLUS", "MINUS", "MULT", "DIV", "POW", "EQUAL", "NEQUAL", "LESS", "GREAT", 
			"LESSEQ", "GREATED", "AND", "OR", "ASSIGN", "TASSIGN", "INTLIT", "FLOATLIT", 
			"ID", "COMMENT", "WS", "ZERO", "DIGIT", "NON_ZERO_DIGIT"
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


	public TigerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tiger.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\67\u015d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3"+
		"\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&"+
		"\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3-\3.\3."+
		"\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\62\7\62\u0127\n\62\f\62\16"+
		"\62\u012a\13\62\5\62\u012c\n\62\3\63\3\63\6\63\u0130\n\63\r\63\16\63\u0131"+
		"\5\63\u0134\n\63\3\63\3\63\7\63\u0138\n\63\f\63\16\63\u013b\13\63\3\64"+
		"\3\64\6\64\u013f\n\64\r\64\16\64\u0140\3\65\3\65\3\65\3\65\7\65\u0147"+
		"\n\65\f\65\16\65\u014a\13\65\3\65\3\65\3\65\3\65\3\65\3\66\6\66\u0152"+
		"\n\66\r\66\16\66\u0153\3\66\3\66\3\67\3\67\38\38\39\39\3\u0148\2:\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m\2o\2q"+
		"\2\3\2\7\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\3\2\62;\3\2\63;\2"+
		"\u0162\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2"+
		"\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\3"+
		"s\3\2\2\2\5y\3\2\2\2\7\177\3\2\2\2\t\u0085\3\2\2\2\13\u0088\3\2\2\2\r"+
		"\u008d\3\2\2\2\17\u0091\3\2\2\2\21\u0097\3\2\2\2\23\u009d\3\2\2\2\25\u00a3"+
		"\3\2\2\2\27\u00a7\3\2\2\2\31\u00b0\3\2\2\2\33\u00b3\3\2\2\2\35\u00b7\3"+
		"\2\2\2\37\u00bb\3\2\2\2!\u00be\3\2\2\2#\u00c6\3\2\2\2%\u00cd\3\2\2\2\'"+
		"\u00d4\3\2\2\2)\u00d9\3\2\2\2+\u00dc\3\2\2\2-\u00e1\3\2\2\2/\u00e5\3\2"+
		"\2\2\61\u00eb\3\2\2\2\63\u00ed\3\2\2\2\65\u00ef\3\2\2\2\67\u00f1\3\2\2"+
		"\29\u00f3\3\2\2\2;\u00f5\3\2\2\2=\u00f7\3\2\2\2?\u00f9\3\2\2\2A\u00fb"+
		"\3\2\2\2C\u00fd\3\2\2\2E\u00ff\3\2\2\2G\u0101\3\2\2\2I\u0103\3\2\2\2K"+
		"\u0105\3\2\2\2M\u0107\3\2\2\2O\u010a\3\2\2\2Q\u010d\3\2\2\2S\u0110\3\2"+
		"\2\2U\u0112\3\2\2\2W\u0114\3\2\2\2Y\u0117\3\2\2\2[\u011a\3\2\2\2]\u011c"+
		"\3\2\2\2_\u011e\3\2\2\2a\u0121\3\2\2\2c\u012b\3\2\2\2e\u0133\3\2\2\2g"+
		"\u013c\3\2\2\2i\u0142\3\2\2\2k\u0151\3\2\2\2m\u0157\3\2\2\2o\u0159\3\2"+
		"\2\2q\u015b\3\2\2\2st\7c\2\2tu\7t\2\2uv\7t\2\2vw\7c\2\2wx\7{\2\2x\4\3"+
		"\2\2\2yz\7d\2\2z{\7g\2\2{|\7i\2\2|}\7k\2\2}~\7p\2\2~\6\3\2\2\2\177\u0080"+
		"\7d\2\2\u0080\u0081\7t\2\2\u0081\u0082\7g\2\2\u0082\u0083\7c\2\2\u0083"+
		"\u0084\7m\2\2\u0084\b\3\2\2\2\u0085\u0086\7f\2\2\u0086\u0087\7q\2\2\u0087"+
		"\n\3\2\2\2\u0088\u0089\7g\2\2\u0089\u008a\7n\2\2\u008a\u008b\7u\2\2\u008b"+
		"\u008c\7g\2\2\u008c\f\3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f\7p\2\2\u008f"+
		"\u0090\7f\2\2\u0090\16\3\2\2\2\u0091\u0092\7g\2\2\u0092\u0093\7p\2\2\u0093"+
		"\u0094\7f\2\2\u0094\u0095\7f\2\2\u0095\u0096\7q\2\2\u0096\20\3\2\2\2\u0097"+
		"\u0098\7g\2\2\u0098\u0099\7p\2\2\u0099\u009a\7f\2\2\u009a\u009b\7k\2\2"+
		"\u009b\u009c\7h\2\2\u009c\22\3\2\2\2\u009d\u009e\7h\2\2\u009e\u009f\7"+
		"n\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1\7c\2\2\u00a1\u00a2\7v\2\2\u00a2\24"+
		"\3\2\2\2\u00a3\u00a4\7h\2\2\u00a4\u00a5\7q\2\2\u00a5\u00a6\7t\2\2\u00a6"+
		"\26\3\2\2\2\u00a7\u00a8\7h\2\2\u00a8\u00a9\7w\2\2\u00a9\u00aa\7p\2\2\u00aa"+
		"\u00ab\7e\2\2\u00ab\u00ac\7v\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7q\2\2"+
		"\u00ae\u00af\7p\2\2\u00af\30\3\2\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7"+
		"h\2\2\u00b2\32\3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7p\2\2\u00b5\u00b6"+
		"\7v\2\2\u00b6\34\3\2\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba"+
		"\7v\2\2\u00ba\36\3\2\2\2\u00bb\u00bc\7q\2\2\u00bc\u00bd\7h\2\2\u00bd "+
		"\3\2\2\2\u00be\u00bf\7r\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7q\2\2\u00c1"+
		"\u00c2\7i\2\2\u00c2\u00c3\7t\2\2\u00c3\u00c4\7c\2\2\u00c4\u00c5\7o\2\2"+
		"\u00c5\"\3\2\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7g\2\2\u00c8\u00c9\7v"+
		"\2\2\u00c9\u00ca\7w\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7p\2\2\u00cc$\3"+
		"\2\2\2\u00cd\u00ce\7u\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7c\2\2\u00d0"+
		"\u00d1\7v\2\2\u00d1\u00d2\7k\2\2\u00d2\u00d3\7e\2\2\u00d3&\3\2\2\2\u00d4"+
		"\u00d5\7v\2\2\u00d5\u00d6\7j\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7p\2\2"+
		"\u00d8(\3\2\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7q\2\2\u00db*\3\2\2\2\u00dc"+
		"\u00dd\7v\2\2\u00dd\u00de\7{\2\2\u00de\u00df\7r\2\2\u00df\u00e0\7g\2\2"+
		"\u00e0,\3\2\2\2\u00e1\u00e2\7x\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7t\2"+
		"\2\u00e4.\3\2\2\2\u00e5\u00e6\7y\2\2\u00e6\u00e7\7j\2\2\u00e7\u00e8\7"+
		"k\2\2\u00e8\u00e9\7n\2\2\u00e9\u00ea\7g\2\2\u00ea\60\3\2\2\2\u00eb\u00ec"+
		"\7.\2\2\u00ec\62\3\2\2\2\u00ed\u00ee\7\60\2\2\u00ee\64\3\2\2\2\u00ef\u00f0"+
		"\7<\2\2\u00f0\66\3\2\2\2\u00f1\u00f2\7=\2\2\u00f28\3\2\2\2\u00f3\u00f4"+
		"\7*\2\2\u00f4:\3\2\2\2\u00f5\u00f6\7+\2\2\u00f6<\3\2\2\2\u00f7\u00f8\7"+
		"]\2\2\u00f8>\3\2\2\2\u00f9\u00fa\7_\2\2\u00fa@\3\2\2\2\u00fb\u00fc\7}"+
		"\2\2\u00fcB\3\2\2\2\u00fd\u00fe\7\177\2\2\u00feD\3\2\2\2\u00ff\u0100\7"+
		"-\2\2\u0100F\3\2\2\2\u0101\u0102\7/\2\2\u0102H\3\2\2\2\u0103\u0104\7,"+
		"\2\2\u0104J\3\2\2\2\u0105\u0106\7\61\2\2\u0106L\3\2\2\2\u0107\u0108\7"+
		",\2\2\u0108\u0109\7,\2\2\u0109N\3\2\2\2\u010a\u010b\7?\2\2\u010b\u010c"+
		"\7?\2\2\u010cP\3\2\2\2\u010d\u010e\7#\2\2\u010e\u010f\7?\2\2\u010fR\3"+
		"\2\2\2\u0110\u0111\7>\2\2\u0111T\3\2\2\2\u0112\u0113\7@\2\2\u0113V\3\2"+
		"\2\2\u0114\u0115\7>\2\2\u0115\u0116\7?\2\2\u0116X\3\2\2\2\u0117\u0118"+
		"\7@\2\2\u0118\u0119\7?\2\2\u0119Z\3\2\2\2\u011a\u011b\7(\2\2\u011b\\\3"+
		"\2\2\2\u011c\u011d\7~\2\2\u011d^\3\2\2\2\u011e\u011f\7<\2\2\u011f\u0120"+
		"\7?\2\2\u0120`\3\2\2\2\u0121\u0122\7?\2\2\u0122b\3\2\2\2\u0123\u012c\5"+
		"m\67\2\u0124\u0128\5q9\2\u0125\u0127\5o8\2\u0126\u0125\3\2\2\2\u0127\u012a"+
		"\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u012c\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012b\u0123\3\2\2\2\u012b\u0124\3\2\2\2\u012cd\3\2\2\2"+
		"\u012d\u0134\5m\67\2\u012e\u0130\5q9\2\u012f\u012e\3\2\2\2\u0130\u0131"+
		"\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u012d\3\2\2\2\u0133\u012f\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135\u0139\7\60\2\2\u0136\u0138\5o8\2\u0137\u0136\3\2\2\2\u0138"+
		"\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013af\3\2\2\2"+
		"\u013b\u0139\3\2\2\2\u013c\u013e\t\2\2\2\u013d\u013f\t\3\2\2\u013e\u013d"+
		"\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"h\3\2\2\2\u0142\u0143\7\61\2\2\u0143\u0144\7,\2\2\u0144\u0148\3\2\2\2"+
		"\u0145\u0147\13\2\2\2\u0146\u0145\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u0148\3\2\2\2\u014b"+
		"\u014c\7,\2\2\u014c\u014d\7\61\2\2\u014d\u014e\3\2\2\2\u014e\u014f\b\65"+
		"\2\2\u014fj\3\2\2\2\u0150\u0152\t\4\2\2\u0151\u0150\3\2\2\2\u0152\u0153"+
		"\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u0156\b\66\2\2\u0156l\3\2\2\2\u0157\u0158\7\62\2\2\u0158n\3\2\2\2\u0159"+
		"\u015a\t\5\2\2\u015ap\3\2\2\2\u015b\u015c\t\6\2\2\u015cr\3\2\2\2\13\2"+
		"\u0128\u012b\u0131\u0133\u0139\u0140\u0148\u0153\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}