// Generated from compUnit.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class compUnitParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		Type=18, IdentMain=19, If=20, While=21, Break=22, Continue=23, Or=24, 
		And=25, Cmp=26, Equal=27, Return=28, Ident=29, Nondigit=30, Number=31, 
		Decimal_const=32, Octal_const=33, Hexadecimal_const=34, Hexadecimal_prefix=35, 
		Nonzero_digit=36, Octal_digit=37, Digit=38, Hexadecimal_digit=39, WHITE_SPACE=40;
	public static final int
		RULE_compUnit = 0, RULE_funcDef = 1, RULE_decl = 2, RULE_constDecl = 3, 
		RULE_constDef = 4, RULE_constInitVal = 5, RULE_constExp = 6, RULE_varDecl = 7, 
		RULE_varDef = 8, RULE_initVal = 9, RULE_block = 10, RULE_blockItem = 11, 
		RULE_condition = 12, RULE_stmt = 13, RULE_lorExp = 14, RULE_relExp = 15, 
		RULE_eqExp = 16, RULE_landExp = 17, RULE_exp = 18, RULE_lVal = 19, RULE_primaryExp = 20, 
		RULE_addExp = 21, RULE_mulExp = 22, RULE_unaryExp = 23, RULE_funcRParams = 24, 
		RULE_unaryOp = 25, RULE_calOp = 26;
	private static String[] makeRuleNames() {
		return new String[] {
			"compUnit", "funcDef", "decl", "constDecl", "constDef", "constInitVal", 
			"constExp", "varDecl", "varDef", "initVal", "block", "blockItem", "condition", 
			"stmt", "lorExp", "relExp", "eqExp", "landExp", "exp", "lVal", "primaryExp", 
			"addExp", "mulExp", "unaryExp", "funcRParams", "unaryOp", "calOp"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'const'", "','", "';'", "'['", "']'", "'='", "'{'", 
			"'}'", "'else'", "'+'", "'-'", "'!'", "'*'", "'/'", "'%'", "'int'", "'main'", 
			"'if'", "'while'", "'break'", "'continue'", "'||'", "'&&'", null, null, 
			"'return'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "Type", "IdentMain", "If", "While", 
			"Break", "Continue", "Or", "And", "Cmp", "Equal", "Return", "Ident", 
			"Nondigit", "Number", "Decimal_const", "Octal_const", "Hexadecimal_const", 
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

	@Override
	public String getGrammarFileName() { return "compUnit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public compUnitParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompUnitContext extends ParserRuleContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public CompUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterCompUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitCompUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitCompUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompUnitContext compUnit() throws RecognitionException {
		CompUnitContext _localctx = new CompUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compUnit);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(54);
					decl();
					}
					} 
				}
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(60);
			funcDef();
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

	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(compUnitParser.Type, 0); }
		public TerminalNode IdentMain() { return getToken(compUnitParser.IdentMain, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(Type);
			setState(63);
			match(IdentMain);
			setState(64);
			match(T__0);
			setState(65);
			match(T__1);
			setState(66);
			block();
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

	public static class DeclContext extends ParserRuleContext {
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				constDecl();
				}
				break;
			case Type:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				varDecl();
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

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(compUnitParser.Type, 0); }
		public List<ConstDefContext> constDef() {
			return getRuleContexts(ConstDefContext.class);
		}
		public ConstDefContext constDef(int i) {
			return getRuleContext(ConstDefContext.class,i);
		}
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterConstDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitConstDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__2);
			setState(73);
			match(Type);
			setState(74);
			constDef();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(75);
				match(T__3);
				setState(76);
				constDef();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(T__4);
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

	public static class ConstDefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(compUnitParser.Ident, 0); }
		public ConstInitValContext constInitVal() {
			return getRuleContext(ConstInitValContext.class,0);
		}
		public List<ConstExpContext> constExp() {
			return getRuleContexts(ConstExpContext.class);
		}
		public ConstExpContext constExp(int i) {
			return getRuleContext(ConstExpContext.class,i);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterConstDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitConstDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitConstDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_constDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(Ident);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(85);
				match(T__5);
				setState(86);
				constExp();
				setState(87);
				match(T__6);
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(T__7);
			setState(95);
			constInitVal();
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

	public static class ConstInitValContext extends ParserRuleContext {
		public ConstExpContext constExp() {
			return getRuleContext(ConstExpContext.class,0);
		}
		public List<ConstInitValContext> constInitVal() {
			return getRuleContexts(ConstInitValContext.class);
		}
		public ConstInitValContext constInitVal(int i) {
			return getRuleContext(ConstInitValContext.class,i);
		}
		public ConstInitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constInitVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterConstInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitConstInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitConstInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstInitValContext constInitVal() throws RecognitionException {
		ConstInitValContext _localctx = new ConstInitValContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constInitVal);
		int _la;
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__12:
			case T__13:
			case Ident:
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(97);
				constExp();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(T__8);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << Ident) | (1L << Number))) != 0)) {
					{
					setState(99);
					constInitVal();
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(100);
						match(T__3);
						setState(101);
						constInitVal();
						}
						}
						setState(106);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(109);
				match(T__9);
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

	public static class ConstExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ConstExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterConstExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitConstExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitConstExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstExpContext constExp() throws RecognitionException {
		ConstExpContext _localctx = new ConstExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			addExp(0);
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

	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(compUnitParser.Type, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(Type);
			setState(115);
			varDef();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(116);
				match(T__3);
				setState(117);
				varDef();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(123);
			match(T__4);
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

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(compUnitParser.Ident, 0); }
		public List<ConstExpContext> constExp() {
			return getRuleContexts(ConstExpContext.class);
		}
		public ConstExpContext constExp(int i) {
			return getRuleContext(ConstExpContext.class,i);
		}
		public InitValContext initVal() {
			return getRuleContext(InitValContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varDef);
		int _la;
		try {
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				match(Ident);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(126);
					match(T__5);
					setState(127);
					constExp();
					setState(128);
					match(T__6);
					}
					}
					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(Ident);
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__5) {
					{
					{
					setState(136);
					match(T__5);
					setState(137);
					constExp();
					setState(138);
					match(T__6);
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(145);
				match(T__7);
				setState(146);
				initVal();
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

	public static class InitValContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<InitValContext> initVal() {
			return getRuleContexts(InitValContext.class);
		}
		public InitValContext initVal(int i) {
			return getRuleContext(InitValContext.class,i);
		}
		public InitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitValContext initVal() throws RecognitionException {
		InitValContext _localctx = new InitValContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_initVal);
		int _la;
		try {
			setState(162);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__12:
			case T__13:
			case Ident:
			case Number:
				enterOuterAlt(_localctx, 1);
				{
				setState(149);
				exp();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				match(T__8);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << Ident) | (1L << Number))) != 0)) {
					{
					setState(151);
					initVal();
					setState(156);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(152);
						match(T__3);
						setState(153);
						initVal();
						}
						}
						setState(158);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(161);
				match(T__9);
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

	public static class BlockContext extends ParserRuleContext {
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__8);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << Type) | (1L << If) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << Ident) | (1L << Number))) != 0)) {
				{
				{
				setState(165);
				blockItem();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
			match(T__9);
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

	public static class BlockItemContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_blockItem);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case Type:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				decl();
				}
				break;
			case T__0:
			case T__4:
			case T__8:
			case T__11:
			case T__12:
			case T__13:
			case If:
			case While:
			case Break:
			case Continue:
			case Return:
			case Ident:
			case Number:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				stmt();
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

	public static class ConditionContext extends ParserRuleContext {
		public LorExpContext lorExp() {
			return getRuleContext(LorExpContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			lorExp(0);
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

	public static class StmtContext extends ParserRuleContext {
		public LValContext lVal() {
			return getRuleContext(LValContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Return() { return getToken(compUnitParser.Return, 0); }
		public TerminalNode If() { return getToken(compUnitParser.If, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode While() { return getToken(compUnitParser.While, 0); }
		public TerminalNode Break() { return getToken(compUnitParser.Break, 0); }
		public TerminalNode Continue() { return getToken(compUnitParser.Continue, 0); }
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_stmt);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				lVal();
				setState(180);
				match(T__7);
				setState(181);
				exp();
				setState(182);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << Ident) | (1L << Number))) != 0)) {
					{
					setState(184);
					exp();
					}
				}

				setState(187);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				match(Return);
				setState(189);
				exp();
				setState(190);
				match(T__4);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(192);
				match(If);
				setState(193);
				match(T__0);
				setState(194);
				condition();
				setState(195);
				match(T__1);
				setState(196);
				stmt();
				setState(199);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(197);
					match(T__10);
					setState(198);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(201);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(202);
				match(While);
				setState(203);
				match(T__0);
				setState(204);
				condition();
				setState(205);
				match(T__1);
				setState(206);
				stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(208);
				match(Break);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(209);
				match(Continue);
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

	public static class LorExpContext extends ParserRuleContext {
		public LandExpContext landExp() {
			return getRuleContext(LandExpContext.class,0);
		}
		public LorExpContext lorExp() {
			return getRuleContext(LorExpContext.class,0);
		}
		public TerminalNode Or() { return getToken(compUnitParser.Or, 0); }
		public LorExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lorExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterLorExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitLorExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitLorExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LorExpContext lorExp() throws RecognitionException {
		return lorExp(0);
	}

	private LorExpContext lorExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LorExpContext _localctx = new LorExpContext(_ctx, _parentState);
		LorExpContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_lorExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(213);
			landExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LorExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lorExp);
					setState(215);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(216);
					match(Or);
					setState(217);
					landExp(0);
					}
					} 
				}
				setState(222);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class RelExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public RelExpContext relExp() {
			return getRuleContext(RelExpContext.class,0);
		}
		public TerminalNode Cmp() { return getToken(compUnitParser.Cmp, 0); }
		public RelExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterRelExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitRelExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitRelExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExpContext relExp() throws RecognitionException {
		return relExp(0);
	}

	private RelExpContext relExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelExpContext _localctx = new RelExpContext(_ctx, _parentState);
		RelExpContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_relExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(224);
			addExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relExp);
					setState(226);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(227);
					match(Cmp);
					setState(228);
					addExp(0);
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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

	public static class EqExpContext extends ParserRuleContext {
		public RelExpContext relExp() {
			return getRuleContext(RelExpContext.class,0);
		}
		public EqExpContext eqExp() {
			return getRuleContext(EqExpContext.class,0);
		}
		public TerminalNode Equal() { return getToken(compUnitParser.Equal, 0); }
		public EqExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterEqExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitEqExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqExpContext eqExp() throws RecognitionException {
		return eqExp(0);
	}

	private EqExpContext eqExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqExpContext _localctx = new EqExpContext(_ctx, _parentState);
		EqExpContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_eqExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(235);
			relExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_eqExp);
					setState(237);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(238);
					match(Equal);
					setState(239);
					relExp(0);
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class LandExpContext extends ParserRuleContext {
		public EqExpContext eqExp() {
			return getRuleContext(EqExpContext.class,0);
		}
		public LandExpContext landExp() {
			return getRuleContext(LandExpContext.class,0);
		}
		public TerminalNode And() { return getToken(compUnitParser.And, 0); }
		public LandExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_landExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterLandExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitLandExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitLandExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LandExpContext landExp() throws RecognitionException {
		return landExp(0);
	}

	private LandExpContext landExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LandExpContext _localctx = new LandExpContext(_ctx, _parentState);
		LandExpContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_landExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(246);
			eqExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LandExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_landExp);
					setState(248);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(249);
					match(And);
					setState(250);
					eqExp(0);
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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

	public static class ExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			addExp(0);
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

	public static class LValContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(compUnitParser.Ident, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterLVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitLVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitLVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LValContext lVal() throws RecognitionException {
		LValContext _localctx = new LValContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_lVal);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(Ident);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(259);
					match(T__5);
					setState(260);
					exp();
					setState(261);
					match(T__6);
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class PrimaryExpContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LValContext lVal() {
			return getRuleContext(LValContext.class,0);
		}
		public TerminalNode Number() { return getToken(compUnitParser.Number, 0); }
		public PrimaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterPrimaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitPrimaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitPrimaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpContext primaryExp() throws RecognitionException {
		PrimaryExpContext _localctx = new PrimaryExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primaryExp);
		try {
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				match(T__0);
				setState(269);
				exp();
				setState(270);
				match(T__1);
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				lVal();
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				match(Number);
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

	public static class AddExpContext extends ParserRuleContext {
		public MulExpContext mulExp() {
			return getRuleContext(MulExpContext.class,0);
		}
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public AddExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterAddExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitAddExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitAddExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExpContext addExp() throws RecognitionException {
		return addExp(0);
	}

	private AddExpContext addExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExpContext _localctx = new AddExpContext(_ctx, _parentState);
		AddExpContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_addExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(277);
			mulExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(285);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addExp);
					setState(279);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(280);
					unaryOp();
					setState(281);
					mulExp(0);
					}
					} 
				}
				setState(287);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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

	public static class MulExpContext extends ParserRuleContext {
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public MulExpContext mulExp() {
			return getRuleContext(MulExpContext.class,0);
		}
		public CalOpContext calOp() {
			return getRuleContext(CalOpContext.class,0);
		}
		public MulExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterMulExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitMulExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitMulExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExpContext mulExp() throws RecognitionException {
		return mulExp(0);
	}

	private MulExpContext mulExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulExpContext _localctx = new MulExpContext(_ctx, _parentState);
		MulExpContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_mulExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(289);
			unaryExp();
			}
			_ctx.stop = _input.LT(-1);
			setState(297);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExp);
					setState(291);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(292);
					calOp();
					setState(293);
					unaryExp();
					}
					} 
				}
				setState(299);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	public static class UnaryExpContext extends ParserRuleContext {
		public PrimaryExpContext primaryExp() {
			return getRuleContext(PrimaryExpContext.class,0);
		}
		public TerminalNode Ident() { return getToken(compUnitParser.Ident, 0); }
		public FuncRParamsContext funcRParams() {
			return getRuleContext(FuncRParamsContext.class,0);
		}
		public UnaryOpContext unaryOp() {
			return getRuleContext(UnaryOpContext.class,0);
		}
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterUnaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitUnaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitUnaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_unaryExp);
		int _la;
		try {
			setState(310);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				primaryExp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				match(Ident);
				setState(302);
				match(T__0);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << Ident) | (1L << Number))) != 0)) {
					{
					setState(303);
					funcRParams();
					}
				}

				setState(306);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(307);
				unaryOp();
				setState(308);
				unaryExp();
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

	public static class FuncRParamsContext extends ParserRuleContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncRParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcRParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterFuncRParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitFuncRParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitFuncRParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncRParamsContext funcRParams() throws RecognitionException {
		FuncRParamsContext _localctx = new FuncRParamsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_funcRParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			exp();
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(313);
				match(T__3);
				setState(314);
				exp();
				}
				}
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class UnaryOpContext extends ParserRuleContext {
		public UnaryOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterUnaryOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitUnaryOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitUnaryOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpContext unaryOp() throws RecognitionException {
		UnaryOpContext _localctx = new UnaryOpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
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

	public static class CalOpContext extends ParserRuleContext {
		public CalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).enterCalOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof compUnitListener ) ((compUnitListener)listener).exitCalOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof compUnitVisitor ) return ((compUnitVisitor<? extends T>)visitor).visitCalOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalOpContext calOp() throws RecognitionException {
		CalOpContext _localctx = new CalOpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_calOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return lorExp_sempred((LorExpContext)_localctx, predIndex);
		case 15:
			return relExp_sempred((RelExpContext)_localctx, predIndex);
		case 16:
			return eqExp_sempred((EqExpContext)_localctx, predIndex);
		case 17:
			return landExp_sempred((LandExpContext)_localctx, predIndex);
		case 21:
			return addExp_sempred((AddExpContext)_localctx, predIndex);
		case 22:
			return mulExp_sempred((MulExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean lorExp_sempred(LorExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relExp_sempred(RelExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eqExp_sempred(EqExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean landExp_sempred(LandExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean addExp_sempred(AddExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mulExp_sempred(MulExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0147\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\7\2:\n\2\f\2\16\2=\13\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\4\3\4\5\4I\n\4\3\5\3\5\3\5\3\5\3\5\7\5P\n\5\f\5"+
		"\16\5S\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\5\7n\n\7\3\7\5\7q\n"+
		"\7\3\b\3\b\3\t\3\t\3\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\7\n\u0085\n\n\f\n\16\n\u0088\13\n\3\n\3\n\3\n\3\n\3\n\7\n\u008f"+
		"\n\n\f\n\16\n\u0092\13\n\3\n\3\n\5\n\u0096\n\n\3\13\3\13\3\13\3\13\3\13"+
		"\7\13\u009d\n\13\f\13\16\13\u00a0\13\13\5\13\u00a2\n\13\3\13\5\13\u00a5"+
		"\n\13\3\f\3\f\7\f\u00a9\n\f\f\f\16\f\u00ac\13\f\3\f\3\f\3\r\3\r\5\r\u00b2"+
		"\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00bc\n\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ca\n\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00d5\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\7\20\u00dd\n\20\f\20\16\20\u00e0\13\20\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\7\21\u00e8\n\21\f\21\16\21\u00eb\13\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\7\22\u00f3\n\22\f\22\16\22\u00f6\13\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\7\23\u00fe\n\23\f\23\16\23\u0101\13\23\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\7\25\u010a\n\25\f\25\16\25\u010d\13\25\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\5\26\u0115\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\7\27\u011e\n\27\f\27\16\27\u0121\13\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\7\30\u012a\n\30\f\30\16\30\u012d\13\30\3\31\3\31\3\31\3\31\5\31"+
		"\u0133\n\31\3\31\3\31\3\31\3\31\5\31\u0139\n\31\3\32\3\32\3\32\7\32\u013e"+
		"\n\32\f\32\16\32\u0141\13\32\3\33\3\33\3\34\3\34\3\34\2\b\36 \"$,.\35"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\4\3\2\16"+
		"\20\3\2\21\23\2\u0151\2;\3\2\2\2\4@\3\2\2\2\6H\3\2\2\2\bJ\3\2\2\2\nV\3"+
		"\2\2\2\fp\3\2\2\2\16r\3\2\2\2\20t\3\2\2\2\22\u0095\3\2\2\2\24\u00a4\3"+
		"\2\2\2\26\u00a6\3\2\2\2\30\u00b1\3\2\2\2\32\u00b3\3\2\2\2\34\u00d4\3\2"+
		"\2\2\36\u00d6\3\2\2\2 \u00e1\3\2\2\2\"\u00ec\3\2\2\2$\u00f7\3\2\2\2&\u0102"+
		"\3\2\2\2(\u0104\3\2\2\2*\u0114\3\2\2\2,\u0116\3\2\2\2.\u0122\3\2\2\2\60"+
		"\u0138\3\2\2\2\62\u013a\3\2\2\2\64\u0142\3\2\2\2\66\u0144\3\2\2\28:\5"+
		"\6\4\298\3\2\2\2:=\3\2\2\2;9\3\2\2\2;<\3\2\2\2<>\3\2\2\2=;\3\2\2\2>?\5"+
		"\4\3\2?\3\3\2\2\2@A\7\24\2\2AB\7\25\2\2BC\7\3\2\2CD\7\4\2\2DE\5\26\f\2"+
		"E\5\3\2\2\2FI\5\b\5\2GI\5\20\t\2HF\3\2\2\2HG\3\2\2\2I\7\3\2\2\2JK\7\5"+
		"\2\2KL\7\24\2\2LQ\5\n\6\2MN\7\6\2\2NP\5\n\6\2OM\3\2\2\2PS\3\2\2\2QO\3"+
		"\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2\2TU\7\7\2\2U\t\3\2\2\2V]\7\37\2\2W"+
		"X\7\b\2\2XY\5\16\b\2YZ\7\t\2\2Z\\\3\2\2\2[W\3\2\2\2\\_\3\2\2\2][\3\2\2"+
		"\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\n\2\2ab\5\f\7\2b\13\3\2\2\2cq\5\16"+
		"\b\2dm\7\13\2\2ej\5\f\7\2fg\7\6\2\2gi\5\f\7\2hf\3\2\2\2il\3\2\2\2jh\3"+
		"\2\2\2jk\3\2\2\2kn\3\2\2\2lj\3\2\2\2me\3\2\2\2mn\3\2\2\2no\3\2\2\2oq\7"+
		"\f\2\2pc\3\2\2\2pd\3\2\2\2q\r\3\2\2\2rs\5,\27\2s\17\3\2\2\2tu\7\24\2\2"+
		"uz\5\22\n\2vw\7\6\2\2wy\5\22\n\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2"+
		"\2{}\3\2\2\2|z\3\2\2\2}~\7\7\2\2~\21\3\2\2\2\177\u0086\7\37\2\2\u0080"+
		"\u0081\7\b\2\2\u0081\u0082\5\16\b\2\u0082\u0083\7\t\2\2\u0083\u0085\3"+
		"\2\2\2\u0084\u0080\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0096\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u0090\7\37"+
		"\2\2\u008a\u008b\7\b\2\2\u008b\u008c\5\16\b\2\u008c\u008d\7\t\2\2\u008d"+
		"\u008f\3\2\2\2\u008e\u008a\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092\u0090\3\2\2\2\u0093"+
		"\u0094\7\n\2\2\u0094\u0096\5\24\13\2\u0095\177\3\2\2\2\u0095\u0089\3\2"+
		"\2\2\u0096\23\3\2\2\2\u0097\u00a5\5&\24\2\u0098\u00a1\7\13\2\2\u0099\u009e"+
		"\5\24\13\2\u009a\u009b\7\6\2\2\u009b\u009d\5\24\13\2\u009c\u009a\3\2\2"+
		"\2\u009d\u00a0\3\2\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a2"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1\u0099\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a5\7\f\2\2\u00a4\u0097\3\2\2\2\u00a4\u0098\3\2"+
		"\2\2\u00a5\25\3\2\2\2\u00a6\u00aa\7\13\2\2\u00a7\u00a9\5\30\r\2\u00a8"+
		"\u00a7\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7\f\2\2\u00ae"+
		"\27\3\2\2\2\u00af\u00b2\5\6\4\2\u00b0\u00b2\5\34\17\2\u00b1\u00af\3\2"+
		"\2\2\u00b1\u00b0\3\2\2\2\u00b2\31\3\2\2\2\u00b3\u00b4\5\36\20\2\u00b4"+
		"\33\3\2\2\2\u00b5\u00b6\5(\25\2\u00b6\u00b7\7\n\2\2\u00b7\u00b8\5&\24"+
		"\2\u00b8\u00b9\7\7\2\2\u00b9\u00d5\3\2\2\2\u00ba\u00bc\5&\24\2\u00bb\u00ba"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00d5\7\7\2\2\u00be"+
		"\u00bf\7\36\2\2\u00bf\u00c0\5&\24\2\u00c0\u00c1\7\7\2\2\u00c1\u00d5\3"+
		"\2\2\2\u00c2\u00c3\7\26\2\2\u00c3\u00c4\7\3\2\2\u00c4\u00c5\5\32\16\2"+
		"\u00c5\u00c6\7\4\2\2\u00c6\u00c9\5\34\17\2\u00c7\u00c8\7\r\2\2\u00c8\u00ca"+
		"\5\34\17\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d5\3\2\2\2"+
		"\u00cb\u00d5\5\26\f\2\u00cc\u00cd\7\27\2\2\u00cd\u00ce\7\3\2\2\u00ce\u00cf"+
		"\5\32\16\2\u00cf\u00d0\7\4\2\2\u00d0\u00d1\5\34\17\2\u00d1\u00d5\3\2\2"+
		"\2\u00d2\u00d5\7\30\2\2\u00d3\u00d5\7\31\2\2\u00d4\u00b5\3\2\2\2\u00d4"+
		"\u00bb\3\2\2\2\u00d4\u00be\3\2\2\2\u00d4\u00c2\3\2\2\2\u00d4\u00cb\3\2"+
		"\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5"+
		"\35\3\2\2\2\u00d6\u00d7\b\20\1\2\u00d7\u00d8\5$\23\2\u00d8\u00de\3\2\2"+
		"\2\u00d9\u00da\f\3\2\2\u00da\u00db\7\32\2\2\u00db\u00dd\5$\23\2\u00dc"+
		"\u00d9\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\37\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\b\21\1\2\u00e2\u00e3"+
		"\5,\27\2\u00e3\u00e9\3\2\2\2\u00e4\u00e5\f\3\2\2\u00e5\u00e6\7\34\2\2"+
		"\u00e6\u00e8\5,\27\2\u00e7\u00e4\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea!\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec"+
		"\u00ed\b\22\1\2\u00ed\u00ee\5 \21\2\u00ee\u00f4\3\2\2\2\u00ef\u00f0\f"+
		"\3\2\2\u00f0\u00f1\7\35\2\2\u00f1\u00f3\5 \21\2\u00f2\u00ef\3\2\2\2\u00f3"+
		"\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5#\3\2\2\2"+
		"\u00f6\u00f4\3\2\2\2\u00f7\u00f8\b\23\1\2\u00f8\u00f9\5\"\22\2\u00f9\u00ff"+
		"\3\2\2\2\u00fa\u00fb\f\3\2\2\u00fb\u00fc\7\33\2\2\u00fc\u00fe\5\"\22\2"+
		"\u00fd\u00fa\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100"+
		"\3\2\2\2\u0100%\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\5,\27\2\u0103"+
		"\'\3\2\2\2\u0104\u010b\7\37\2\2\u0105\u0106\7\b\2\2\u0106\u0107\5&\24"+
		"\2\u0107\u0108\7\t\2\2\u0108\u010a\3\2\2\2\u0109\u0105\3\2\2\2\u010a\u010d"+
		"\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c)\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010e\u010f\7\3\2\2\u010f\u0110\5&\24\2\u0110\u0111\7\4"+
		"\2\2\u0111\u0115\3\2\2\2\u0112\u0115\5(\25\2\u0113\u0115\7!\2\2\u0114"+
		"\u010e\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115+\3\2\2\2"+
		"\u0116\u0117\b\27\1\2\u0117\u0118\5.\30\2\u0118\u011f\3\2\2\2\u0119\u011a"+
		"\f\3\2\2\u011a\u011b\5\64\33\2\u011b\u011c\5.\30\2\u011c\u011e\3\2\2\2"+
		"\u011d\u0119\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120-\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\b\30\1\2\u0123"+
		"\u0124\5\60\31\2\u0124\u012b\3\2\2\2\u0125\u0126\f\3\2\2\u0126\u0127\5"+
		"\66\34\2\u0127\u0128\5\60\31\2\u0128\u012a\3\2\2\2\u0129\u0125\3\2\2\2"+
		"\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c/\3"+
		"\2\2\2\u012d\u012b\3\2\2\2\u012e\u0139\5*\26\2\u012f\u0130\7\37\2\2\u0130"+
		"\u0132\7\3\2\2\u0131\u0133\5\62\32\2\u0132\u0131\3\2\2\2\u0132\u0133\3"+
		"\2\2\2\u0133\u0134\3\2\2\2\u0134\u0139\7\4\2\2\u0135\u0136\5\64\33\2\u0136"+
		"\u0137\5\60\31\2\u0137\u0139\3\2\2\2\u0138\u012e\3\2\2\2\u0138\u012f\3"+
		"\2\2\2\u0138\u0135\3\2\2\2\u0139\61\3\2\2\2\u013a\u013f\5&\24\2\u013b"+
		"\u013c\7\6\2\2\u013c\u013e\5&\24\2\u013d\u013b\3\2\2\2\u013e\u0141\3\2"+
		"\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\63\3\2\2\2\u0141\u013f"+
		"\3\2\2\2\u0142\u0143\t\2\2\2\u0143\65\3\2\2\2\u0144\u0145\t\3\2\2\u0145"+
		"\67\3\2\2\2 ;HQ]jmpz\u0086\u0090\u0095\u009e\u00a1\u00a4\u00aa\u00b1\u00bb"+
		"\u00c9\u00d4\u00de\u00e9\u00f4\u00ff\u010b\u0114\u011f\u012b\u0132\u0138"+
		"\u013f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}