// Generated from SimpleBoolean.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleBooleanParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, LPAREN=3, RPAREN=4, AND=5, OR=6, NOT=7, NAME=8, WS=9;
	public static final String[] tokenNames = {
		"<INVALID>", "'\n'", "';'", "'('", "')'", "'&&'", "'||'", "'!'", "NAME", 
		"WS"
	};
	public static final int
		RULE_start = 0, RULE_andexpression = 1, RULE_orexpression = 2, RULE_notexpression = 3, 
		RULE_atom = 4;
	public static final String[] ruleNames = {
		"start", "andexpression", "orexpression", "notexpression", "atom"
	};

	@Override
	public String getGrammarFileName() { return "SimpleBoolean.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleBooleanParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<AndexpressionContext> andexpression() {
			return getRuleContexts(AndexpressionContext.class);
		}
		public AndexpressionContext andexpression(int i) {
			return getRuleContext(AndexpressionContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10); andexpression();
				setState(11); match(T__0);
				setState(12); match(T__1);
				}
				}
				setState(16); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAREN) | (1L << NOT) | (1L << NAME))) != 0) );
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

	public static class AndexpressionContext extends ParserRuleContext {
		public List<TerminalNode> AND() { return getTokens(SimpleBooleanParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(SimpleBooleanParser.AND, i);
		}
		public OrexpressionContext orexpression(int i) {
			return getRuleContext(OrexpressionContext.class,i);
		}
		public List<OrexpressionContext> orexpression() {
			return getRuleContexts(OrexpressionContext.class);
		}
		public AndexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterAndexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitAndexpression(this);
		}
	}

	public final AndexpressionContext andexpression() throws RecognitionException {
		AndexpressionContext _localctx = new AndexpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_andexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); orexpression();
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(19); match(AND);
				setState(20); orexpression();
				}
				}
				setState(25);
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

	public static class OrexpressionContext extends ParserRuleContext {
		public List<NotexpressionContext> notexpression() {
			return getRuleContexts(NotexpressionContext.class);
		}
		public List<TerminalNode> OR() { return getTokens(SimpleBooleanParser.OR); }
		public NotexpressionContext notexpression(int i) {
			return getRuleContext(NotexpressionContext.class,i);
		}
		public TerminalNode OR(int i) {
			return getToken(SimpleBooleanParser.OR, i);
		}
		public OrexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterOrexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitOrexpression(this);
		}
	}

	public final OrexpressionContext orexpression() throws RecognitionException {
		OrexpressionContext _localctx = new OrexpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_orexpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26); notexpression();
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(27); match(OR);
				setState(28); notexpression();
				}
				}
				setState(33);
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

	public static class NotexpressionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SimpleBooleanParser.NOT, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public NotexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notexpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterNotexpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitNotexpression(this);
		}
	}

	public final NotexpressionContext notexpression() throws RecognitionException {
		NotexpressionContext _localctx = new NotexpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_notexpression);
		try {
			setState(37);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); match(NOT);
				setState(35); atom();
				}
				break;
			case LPAREN:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(36); atom();
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

	public static class AtomContext extends ParserRuleContext {
		public AndexpressionContext andexpression() {
			return getRuleContext(AndexpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(SimpleBooleanParser.RPAREN, 0); }
		public TerminalNode NAME() { return getToken(SimpleBooleanParser.NAME, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleBooleanParser.LPAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleBooleanListener ) ((SimpleBooleanListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atom);
		try {
			setState(44);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(39); match(NAME);
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(40); match(LPAREN);
				setState(41); andexpression();
				setState(42); match(RPAREN);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\13\61\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\6\2\21\n\2\r\2\16\2\22\3"+
		"\3\3\3\3\3\7\3\30\n\3\f\3\16\3\33\13\3\3\4\3\4\3\4\7\4 \n\4\f\4\16\4#"+
		"\13\4\3\5\3\5\3\5\5\5(\n\5\3\6\3\6\3\6\3\6\3\6\5\6/\n\6\3\6\2\2\7\2\4"+
		"\6\b\n\2\2\60\2\20\3\2\2\2\4\24\3\2\2\2\6\34\3\2\2\2\b\'\3\2\2\2\n.\3"+
		"\2\2\2\f\r\5\4\3\2\r\16\7\4\2\2\16\17\7\3\2\2\17\21\3\2\2\2\20\f\3\2\2"+
		"\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\3\3\2\2\2\24\31\5\6\4"+
		"\2\25\26\7\7\2\2\26\30\5\6\4\2\27\25\3\2\2\2\30\33\3\2\2\2\31\27\3\2\2"+
		"\2\31\32\3\2\2\2\32\5\3\2\2\2\33\31\3\2\2\2\34!\5\b\5\2\35\36\7\b\2\2"+
		"\36 \5\b\5\2\37\35\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\7\3\2\2"+
		"\2#!\3\2\2\2$%\7\t\2\2%(\5\n\6\2&(\5\n\6\2\'$\3\2\2\2\'&\3\2\2\2(\t\3"+
		"\2\2\2)/\7\n\2\2*+\7\5\2\2+,\5\4\3\2,-\7\6\2\2-/\3\2\2\2.)\3\2\2\2.*\3"+
		"\2\2\2/\13\3\2\2\2\7\22\31!\'.";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}