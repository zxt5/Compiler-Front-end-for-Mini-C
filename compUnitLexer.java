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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, FuncType=7, Ident=8, Number=9, 
		Decimal_const=10, Octal_const=11, Hexadecimal_const=12, Hexadecimal_prefix=13, 
		Nonzero_digit=14, Octal_digit=15, Digit=16, Hexadecimal_digit=17, WHITE_SPACE=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "FuncType", "Ident", 
			"Number", "Decimal_const", "Octal_const", "Hexadecimal_const", "Hexadecimal_prefix", 
			"Nonzero_digit", "Octal_digit", "Digit", "Hexadecimal_digit", "WHITE_SPACE"
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
			null, null, null, null, null, null, null, "FuncType", "Ident", "Number", 
			"Decimal_const", "Octal_const", "Hexadecimal_const", "Hexadecimal_prefix", 
			"Nonzero_digit", "Octal_digit", "Digit", "Hexadecimal_digit", "WHITE_SPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24p\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\5\nE\n\n\3\13"+
		"\3\13\3\13\7\13J\n\13\f\13\16\13M\13\13\3\f\3\f\7\fQ\n\f\f\f\16\fT\13"+
		"\f\3\r\3\r\7\rX\n\r\f\r\16\r[\13\r\3\16\3\16\3\16\3\16\5\16a\n\16\3\17"+
		"\3\17\3\20\3\20\3\21\3\21\5\21i\n\21\3\22\3\22\3\23\3\23\3\23\3\23\2\2"+
		"\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\3\2\4\5\2\62;CHch\7\2\13\f\17\17\"\"))~~\2w\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13/\3\2\2\2\r"+
		"\66\3\2\2\2\178\3\2\2\2\21<\3\2\2\2\23D\3\2\2\2\25F\3\2\2\2\27N\3\2\2"+
		"\2\31U\3\2\2\2\33`\3\2\2\2\35b\3\2\2\2\37d\3\2\2\2!h\3\2\2\2#j\3\2\2\2"+
		"%l\3\2\2\2\'(\7*\2\2(\4\3\2\2\2)*\7+\2\2*\6\3\2\2\2+,\7}\2\2,\b\3\2\2"+
		"\2-.\7\177\2\2.\n\3\2\2\2/\60\7t\2\2\60\61\7g\2\2\61\62\7v\2\2\62\63\7"+
		"w\2\2\63\64\7t\2\2\64\65\7p\2\2\65\f\3\2\2\2\66\67\7=\2\2\67\16\3\2\2"+
		"\289\7k\2\29:\7p\2\2:;\7v\2\2;\20\3\2\2\2<=\7o\2\2=>\7c\2\2>?\7k\2\2?"+
		"@\7p\2\2@\22\3\2\2\2AE\5\25\13\2BE\5\27\f\2CE\5\31\r\2DA\3\2\2\2DB\3\2"+
		"\2\2DC\3\2\2\2E\24\3\2\2\2FK\5\35\17\2GJ\5\35\17\2HJ\7\62\2\2IG\3\2\2"+
		"\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2L\26\3\2\2\2MK\3\2\2\2NR\7\62"+
		"\2\2OQ\5\37\20\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\30\3\2\2\2T"+
		"R\3\2\2\2UY\5\33\16\2VX\5#\22\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2"+
		"\2Z\32\3\2\2\2[Y\3\2\2\2\\]\7\62\2\2]a\7z\2\2^_\7\62\2\2_a\7Z\2\2`\\\3"+
		"\2\2\2`^\3\2\2\2a\34\3\2\2\2bc\4\63;\2c\36\3\2\2\2de\4\629\2e \3\2\2\2"+
		"fi\7\62\2\2gi\5\35\17\2hf\3\2\2\2hg\3\2\2\2i\"\3\2\2\2jk\t\2\2\2k$\3\2"+
		"\2\2lm\t\3\2\2mn\3\2\2\2no\b\23\2\2o&\3\2\2\2\n\2DIKRY`h\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}