// Generated from compUnit.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class compUnitLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, FuncType=7, Ident=8, UnaryOp=9, 
		Op2=10, Number=11, Decimal_const=12, Octal_const=13, Hexadecimal_const=14, 
		Hexadecimal_prefix=15, Nonzero_digit=16, Octal_digit=17, Digit=18, Hexadecimal_digit=19, 
		WHITE_SPACE=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "FuncType", "Ident", 
			"UnaryOp", "Op2", "Number", "Decimal_const", "Octal_const", "Hexadecimal_const", 
			"Hexadecimal_prefix", "Nonzero_digit", "Octal_digit", "Digit", "Hexadecimal_digit", 
			"WHITE_SPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'return'", "';'", "'int'", "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "FuncType", "Ident", "UnaryOp", 
			"Op2", "Number", "Decimal_const", "Octal_const", "Hexadecimal_const", 
			"Hexadecimal_prefix", "Nonzero_digit", "Octal_digit", "Digit", "Hexadecimal_digit", 
			"WHITE_SPACE"
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


	public compUnitLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "compUnit.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26x\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\13\3\13\3\f\3\f\3\f\5\fM\n\f\3\r\3\r\3\r\7\rR\n\r\f\r\16\rU\13\r"+
		"\3\16\3\16\7\16Y\n\16\f\16\16\16\\\13\16\3\17\3\17\7\17`\n\17\f\17\16"+
		"\17c\13\17\3\20\3\20\3\20\3\20\5\20i\n\20\3\21\3\21\3\22\3\22\3\23\3\23"+
		"\5\23q\n\23\3\24\3\24\3\25\3\25\3\25\3\25\2\2\26\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26\3\2\6\4\2--//\5\2\'\',,\61\61\5\2\62;CHch\7\2\13\f\17\17\"\"))~~"+
		"\2\177\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3+\3\2\2\2\5-\3\2\2\2\7"+
		"/\3\2\2\2\t\61\3\2\2\2\13\63\3\2\2\2\r:\3\2\2\2\17<\3\2\2\2\21@\3\2\2"+
		"\2\23E\3\2\2\2\25G\3\2\2\2\27L\3\2\2\2\31N\3\2\2\2\33V\3\2\2\2\35]\3\2"+
		"\2\2\37h\3\2\2\2!j\3\2\2\2#l\3\2\2\2%p\3\2\2\2\'r\3\2\2\2)t\3\2\2\2+,"+
		"\7*\2\2,\4\3\2\2\2-.\7+\2\2.\6\3\2\2\2/\60\7}\2\2\60\b\3\2\2\2\61\62\7"+
		"\177\2\2\62\n\3\2\2\2\63\64\7t\2\2\64\65\7g\2\2\65\66\7v\2\2\66\67\7w"+
		"\2\2\678\7t\2\289\7p\2\29\f\3\2\2\2:;\7=\2\2;\16\3\2\2\2<=\7k\2\2=>\7"+
		"p\2\2>?\7v\2\2?\20\3\2\2\2@A\7o\2\2AB\7c\2\2BC\7k\2\2CD\7p\2\2D\22\3\2"+
		"\2\2EF\t\2\2\2F\24\3\2\2\2GH\t\3\2\2H\26\3\2\2\2IM\5\31\r\2JM\5\33\16"+
		"\2KM\5\35\17\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2M\30\3\2\2\2NS\5!\21\2OR\5"+
		"!\21\2PR\7\62\2\2QO\3\2\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\32"+
		"\3\2\2\2US\3\2\2\2VZ\7\62\2\2WY\5#\22\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2"+
		"Z[\3\2\2\2[\34\3\2\2\2\\Z\3\2\2\2]a\5\37\20\2^`\5\'\24\2_^\3\2\2\2`c\3"+
		"\2\2\2a_\3\2\2\2ab\3\2\2\2b\36\3\2\2\2ca\3\2\2\2de\7\62\2\2ei\7z\2\2f"+
		"g\7\62\2\2gi\7Z\2\2hd\3\2\2\2hf\3\2\2\2i \3\2\2\2jk\4\63;\2k\"\3\2\2\2"+
		"lm\4\629\2m$\3\2\2\2nq\7\62\2\2oq\5!\21\2pn\3\2\2\2po\3\2\2\2q&\3\2\2"+
		"\2rs\t\4\2\2s(\3\2\2\2tu\t\5\2\2uv\3\2\2\2vw\b\25\2\2w*\3\2\2\2\n\2LQ"+
		"SZahp\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}