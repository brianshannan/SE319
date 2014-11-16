// Generated from RPN.g4 by ANTLR 4.4

    import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RPNParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOL=2, WS=3, UN_OP=4, BIN_OP=5, END=6;
	public static final String[] tokenNames = {
		"<INVALID>", "INT", "BOOL", "WS", "'!'", "BIN_OP", "';'"
	};
	public static final int
		RULE_start = 0, RULE_expr = 1, RULE_literal = 2, RULE_op = 3;
	public static final String[] ruleNames = {
		"start", "expr", "literal", "op"
	};

	@Override
	public String getGrammarFileName() { return "RPN.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    // Stack to store numbers
	    Stack<Object> stack = new Stack<Object>();

	    // Push a number onto the stack
	    public void pushIntToStack(String val) {
	        stack.push(Integer.parseInt(val));
	    }

	    // Apply unary operation (one argument)
	    // Didn't realize not was the only one of these, might as well keep it generic
	    public void applyUnaryOperation(String op) {
	        int first = stack.pop();
	        switch(op) {
	            case "!":
	                stack.push(!first);
	                break;
	        }
	    }

	    // Apply a binary operation (two arguments) given the operation as a string using the stack
	    public void applyBinaryOperation(String op) {
	        int second = stack.pop();
	        int first = stack.pop();
	        switch(op) {
	            case "+":
	                stack.push(first + second);
	                break;
	            case "-":
	                stack.push(first - second);
	                break;
	            case "*":
	                stack.push(first * second);
	                break;
	            case "/":
	                stack.push(first / second);
	                break;
	            case "%":
	                stack.push(first % second);
	                break;
	        }
	    }

	public RPNParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<TerminalNode> WS() { return getTokens(RPNParser.WS); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode END(int i) {
			return getToken(RPNParser.END, i);
		}
		public TerminalNode WS(int i) {
			return getToken(RPNParser.WS, i);
		}
		public List<TerminalNode> END() { return getTokens(RPNParser.END); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(12); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(8); expr();
					setState(10);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(9); match(WS);
						}
					}

					}
					}
					setState(14); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << UN_OP) | (1L << BIN_OP))) != 0) );
				setState(16); match(END);
				}
				}
				setState(20); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << UN_OP) | (1L << BIN_OP))) != 0) );
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
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expr);
		try {
			setState(24);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(22); literal();
				}
				break;
			case UN_OP:
			case BIN_OP:
				enterOuterAlt(_localctx, 2);
				{
				setState(23); op();
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(RPNParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(RPNParser.INT, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==BOOL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class OpContext extends ParserRuleContext {
		public TerminalNode UN_OP() { return getToken(RPNParser.UN_OP, 0); }
		public TerminalNode BIN_OP() { return getToken(RPNParser.BIN_OP, 0); }
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_la = _input.LA(1);
			if ( !(_la==UN_OP || _la==BIN_OP) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b!\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\5\2\r\n\2\6\2\17\n\2\r\2\16\2\20\3\2\3\2\6"+
		"\2\25\n\2\r\2\16\2\26\3\3\3\3\5\3\33\n\3\3\4\3\4\3\5\3\5\3\5\2\2\6\2\4"+
		"\6\b\2\4\3\2\3\4\3\2\6\7 \2\24\3\2\2\2\4\32\3\2\2\2\6\34\3\2\2\2\b\36"+
		"\3\2\2\2\n\f\5\4\3\2\13\r\7\5\2\2\f\13\3\2\2\2\f\r\3\2\2\2\r\17\3\2\2"+
		"\2\16\n\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21\22\3\2\2"+
		"\2\22\23\7\b\2\2\23\25\3\2\2\2\24\16\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2"+
		"\2\26\27\3\2\2\2\27\3\3\2\2\2\30\33\5\6\4\2\31\33\5\b\5\2\32\30\3\2\2"+
		"\2\32\31\3\2\2\2\33\5\3\2\2\2\34\35\t\2\2\2\35\7\3\2\2\2\36\37\t\3\2\2"+
		"\37\t\3\2\2\2\6\f\20\26\32";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}