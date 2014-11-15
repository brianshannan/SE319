// Generated from Count.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CountParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, INT=3, WS=4;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'\n'", "INT", "WS"
	};
	public static final int
		RULE_start = 0;
	public static final String[] ruleNames = {
		"start"
	};

	@Override
	public String getGrammarFileName() { return "Count.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	 	int count = 0;

	public CountParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(CountParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CountParser.INT, i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CountListener ) ((CountListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CountListener ) ((CountListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2); match(INT);
			count++; 
			setState(12);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(4); match(T__1);
				setState(5); match(INT);
				setState(7);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(6); match(T__0);
					}
				}

				count++;
				}
				}
				setState(14);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			System.out.println("Total ints Count is " + count);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\6\22\4\2\t\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2\n\n\2\3\2\7\2\r\n\2\f\2\16\2\20\13\2\3\2\2\2\3\2"+
		"\2\2\22\2\4\3\2\2\2\4\5\7\5\2\2\5\16\b\2\1\2\6\7\7\3\2\2\7\t\7\5\2\2\b"+
		"\n\7\4\2\2\t\b\3\2\2\2\t\n\3\2\2\2\n\13\3\2\2\2\13\r\b\2\1\2\f\6\3\2\2"+
		"\2\r\20\3\2\2\2\16\f\3\2\2\2\16\17\3\2\2\2\17\3\3\2\2\2\20\16\3\2\2\2"+
		"\4\t\16";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}