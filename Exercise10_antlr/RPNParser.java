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
		INT=1, BOOL=2, WS=3, BOOL_UN_OP=4, INT_BIN_OP=5, BOOL_BIN_OP=6, END=7;
	public static final String[] tokenNames = {
		"<INVALID>", "INT", "BOOL", "WS", "'!'", "INT_BIN_OP", "BOOL_BIN_OP", 
		"';'"
	};
	public static final int
		RULE_start = 0, RULE_expr = 1, RULE_literal = 2, RULE_op = 3, RULE_bin_op = 4;
	public static final String[] ruleNames = {
		"start", "expr", "literal", "op", "bin_op"
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

	    public void pushBoolToStack(String val) {
	        if(val.equals("true")) {
	            System.out.println("HEREERERERERER");
	            stack.push(true);
	        } else {
	            stack.push(false);
	        }
	    }

	    // Apply unary operation (one argument)
	    // Didn't realize not was the only one of these, might as well keep it generic
	    public void applyBoolUnaryOperation(String op) {
	        checkNumArguments(op, 1);

	        Object obj = stack.pop();
	        checkBool(op, obj);

	        boolean first = (boolean) obj;

	        switch(op) {
	            case "!":
	                stack.push(!first);
	                break;
	            default:
	                throw new IllegalArgumentException("Unrecognized operation " + op);
	        }
	    }

	    // Apply an integer binary operation (two arguments) given the operation as a string using the stack
	    public void applyIntBinaryOperation(String op) {
	        checkNumArguments(op, 2);

	        Object obj2 = stack.pop();
	        checkInt(op, obj2);
	        Object obj1 = stack.pop();
	        checkInt(op, obj1);

	        int first = (int) obj1;
	        int second = (int) obj2;

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
	            case "<":
	                stack.push(first < second);
	                break;
	            case "<=":
	                stack.push(first <= second);
	                break;
	            case "==":
	                stack.push(first == second);
	                break;
	            case "!=":
	                stack.push(first != second);
	                break;
	            case ">=":
	                stack.push(first >= second);
	                break;
	            case ">":
	                stack.push(first > second);
	                break;
	            default:
	                throw new IllegalArgumentException("Unrecognized operation " + op);
	        }
	    }

	    // Apply a boolean binary operation (two arguments) given the operation as a string using the Stack
	    public void applyBoolBinaryOperation(String op) {
	        checkNumArguments(op, 2);

	        Object obj2 = stack.pop();
	        checkBool(op, obj2);
	        Object obj1 = stack.pop();
	        checkBool(op, obj1);

	        boolean first = (boolean) obj1;
	        boolean second = (boolean) obj2;

	        switch(op) {
	            case "&&":
	                stack.push(first && second);
	                break;
	            case "||":
	                stack.push(first || second);
	                break;
	            default:
	                throw new IllegalArgumentException("Unrecognized operation " + op);
	        }
	    }

	    public void checkNumArguments(String op, int argsReq) {
	        if(stack.size() < argsReq) {
	            throw new IllegalArgumentException("Not enough arguments for operation " + op + ", expecting " + argsReq);
	        }
	    }

	    public void checkBool(String op, Object obj) {
	        if(!(obj instanceof Boolean)) {
	            throw new IllegalArgumentException("Expecting a boolean for operation " + op + ", got " + obj);
	        }
	    }

	    public void checkInt(String op, Object obj) {
	        if(!(obj instanceof Integer)) {
	            throw new IllegalArgumentException("Expecting an integer for operation " + op + ", got " + obj);
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
			setState(20); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(14); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(10); expr();
					setState(12);
					_la = _input.LA(1);
					if (_la==WS) {
						{
						setState(11); match(WS);
						}
					}

					}
					}
					setState(16); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << BOOL_UN_OP) | (1L << INT_BIN_OP) | (1L << BOOL_BIN_OP))) != 0) );
				setState(18); match(END);
				}
				}
				setState(22); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << BOOL_UN_OP) | (1L << INT_BIN_OP) | (1L << BOOL_BIN_OP))) != 0) );
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
			setState(26);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(24); literal();
				}
				break;
			case BOOL_UN_OP:
			case INT_BIN_OP:
			case BOOL_BIN_OP:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); op();
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
			setState(28);
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
		public TerminalNode BOOL_UN_OP() { return getToken(RPNParser.BOOL_UN_OP, 0); }
		public Bin_opContext bin_op() {
			return getRuleContext(Bin_opContext.class,0);
		}
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
		try {
			setState(32);
			switch (_input.LA(1)) {
			case BOOL_UN_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(30); match(BOOL_UN_OP);
				}
				break;
			case INT_BIN_OP:
			case BOOL_BIN_OP:
				enterOuterAlt(_localctx, 2);
				{
				setState(31); bin_op();
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

	public static class Bin_opContext extends ParserRuleContext {
		public TerminalNode INT_BIN_OP() { return getToken(RPNParser.INT_BIN_OP, 0); }
		public TerminalNode BOOL_BIN_OP() { return getToken(RPNParser.BOOL_BIN_OP, 0); }
		public Bin_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bin_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).enterBin_op(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RPNListener ) ((RPNListener)listener).exitBin_op(this);
		}
	}

	public final Bin_opContext bin_op() throws RecognitionException {
		Bin_opContext _localctx = new Bin_opContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_bin_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !(_la==INT_BIN_OP || _la==BOOL_BIN_OP) ) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t\'\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\5\2\17\n\2\6\2\21\n\2\r\2\16\2\22\3"+
		"\2\3\2\6\2\27\n\2\r\2\16\2\30\3\3\3\3\5\3\35\n\3\3\4\3\4\3\5\3\5\5\5#"+
		"\n\5\3\6\3\6\3\6\2\2\7\2\4\6\b\n\2\4\3\2\3\4\3\2\7\b&\2\26\3\2\2\2\4\34"+
		"\3\2\2\2\6\36\3\2\2\2\b\"\3\2\2\2\n$\3\2\2\2\f\16\5\4\3\2\r\17\7\5\2\2"+
		"\16\r\3\2\2\2\16\17\3\2\2\2\17\21\3\2\2\2\20\f\3\2\2\2\21\22\3\2\2\2\22"+
		"\20\3\2\2\2\22\23\3\2\2\2\23\24\3\2\2\2\24\25\7\t\2\2\25\27\3\2\2\2\26"+
		"\20\3\2\2\2\27\30\3\2\2\2\30\26\3\2\2\2\30\31\3\2\2\2\31\3\3\2\2\2\32"+
		"\35\5\6\4\2\33\35\5\b\5\2\34\32\3\2\2\2\34\33\3\2\2\2\35\5\3\2\2\2\36"+
		"\37\t\2\2\2\37\7\3\2\2\2 #\7\6\2\2!#\5\n\6\2\" \3\2\2\2\"!\3\2\2\2#\t"+
		"\3\2\2\2$%\t\3\2\2%\13\3\2\2\2\7\16\22\30\34\"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}