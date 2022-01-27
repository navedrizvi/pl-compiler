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
		PROGRAM=1, END=2, INTLIT=3, FLOATLIT=4, ID=5, COMMENT=6, WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PROGRAM", "END", "INTLIT", "FLOATLIT", "ID", "COMMENT", "WS", "ZERO", 
			"DIGIT", "NON_ZERO_DIGIT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'program'", "'end'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PROGRAM", "END", "INTLIT", "FLOATLIT", "ID", "COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t]\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3\4\3\4\7\4\'"+
		"\n\4\f\4\16\4*\13\4\5\4,\n\4\3\5\3\5\6\5\60\n\5\r\5\16\5\61\5\5\64\n\5"+
		"\3\5\3\5\7\58\n\5\f\5\16\5;\13\5\3\6\3\6\6\6?\n\6\r\6\16\6@\3\7\3\7\3"+
		"\7\3\7\7\7G\n\7\f\7\16\7J\13\7\3\7\3\7\3\7\3\7\3\7\3\b\6\bR\n\b\r\b\16"+
		"\bS\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3H\2\f\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\2\23\2\25\2\3\2\7\4\2C\\c|\6\2\62;C\\aac|\5\2\13\f\17\17\"\""+
		"\3\2\62;\3\2\63;\2b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\27\3\2\2\2\5\37\3\2\2\2\7+\3\2"+
		"\2\2\t\63\3\2\2\2\13<\3\2\2\2\rB\3\2\2\2\17Q\3\2\2\2\21W\3\2\2\2\23Y\3"+
		"\2\2\2\25[\3\2\2\2\27\30\7r\2\2\30\31\7t\2\2\31\32\7q\2\2\32\33\7i\2\2"+
		"\33\34\7t\2\2\34\35\7c\2\2\35\36\7o\2\2\36\4\3\2\2\2\37 \7g\2\2 !\7p\2"+
		"\2!\"\7f\2\2\"\6\3\2\2\2#,\5\21\t\2$(\5\25\13\2%\'\5\23\n\2&%\3\2\2\2"+
		"\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2),\3\2\2\2*(\3\2\2\2+#\3\2\2\2+$\3\2\2"+
		"\2,\b\3\2\2\2-\64\5\21\t\2.\60\5\25\13\2/.\3\2\2\2\60\61\3\2\2\2\61/\3"+
		"\2\2\2\61\62\3\2\2\2\62\64\3\2\2\2\63-\3\2\2\2\63/\3\2\2\2\63\64\3\2\2"+
		"\2\64\65\3\2\2\2\659\7\60\2\2\668\5\23\n\2\67\66\3\2\2\28;\3\2\2\29\67"+
		"\3\2\2\29:\3\2\2\2:\n\3\2\2\2;9\3\2\2\2<>\t\2\2\2=?\t\3\2\2>=\3\2\2\2"+
		"?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\f\3\2\2\2BC\7\61\2\2CD\7,\2\2DH\3\2\2"+
		"\2EG\13\2\2\2FE\3\2\2\2GJ\3\2\2\2HI\3\2\2\2HF\3\2\2\2IK\3\2\2\2JH\3\2"+
		"\2\2KL\7,\2\2LM\7\61\2\2MN\3\2\2\2NO\b\7\2\2O\16\3\2\2\2PR\t\4\2\2QP\3"+
		"\2\2\2RS\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\b\b\2\2V\20\3\2\2\2W"+
		"X\7\62\2\2X\22\3\2\2\2YZ\t\5\2\2Z\24\3\2\2\2[\\\t\6\2\2\\\26\3\2\2\2\13"+
		"\2(+\61\639@HS\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}