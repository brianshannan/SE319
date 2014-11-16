// Generated from RPN.g4 by ANTLR 4.4

    import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RPNLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INT=1, BOOL=2, WS=3, BOOL_UN_OP=4, INT_BIN_OP=5, BOOL_BIN_OP=6, END=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'"
	};
	public static final String[] ruleNames = {
		"INT", "BOOL", "WS", "BOOL_UN_OP", "INT_BIN_OP", "BOOL_BIN_OP", "END"
	};


	    // Stack to store numbers
	    Stack<Object> stack = new Stack<Object>();

	    // Push a number onto the stack
	    public void pushIntToStack(String val) {
	        stack.push(Integer.parseInt(val));
	    }

	    public void pushBoolToStack(String val) {
	        if(val.equals("true")) {
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

	    public void endExpr() {
	        if(stack.size() < 1) {
	            System.out.println("No data to show");
	            return;
	        }
	        if(stack.size() > 1) {
	            System.out.println("More than one result, showing the first");
	        }
	        System.out.println(stack.pop());
	    }


	public RPNLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "RPN.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 0: INT_action((RuleContext)_localctx, actionIndex); break;
		case 1: BOOL_action((RuleContext)_localctx, actionIndex); break;
		case 3: BOOL_UN_OP_action((RuleContext)_localctx, actionIndex); break;
		case 4: INT_BIN_OP_action((RuleContext)_localctx, actionIndex); break;
		case 5: BOOL_BIN_OP_action((RuleContext)_localctx, actionIndex); break;
		case 6: END_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void INT_BIN_OP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: applyIntBinaryOperation(getText()); break;
		}
	}
	private void INT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: pushIntToStack(getText()); break;
		}
	}
	private void BOOL_BIN_OP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: applyBoolBinaryOperation(getText()); break;
		}
	}
	private void END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: System.out.println(stack.pop()); stack.clear(); break;
		}
	}
	private void BOOL_UN_OP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: applyBoolUnaryOperation(getText()); break;
		}
	}
	private void BOOL_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: pushBoolToStack(getText()); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tH\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\6\2\23\n\2\r\2\16\2"+
		"\24\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\3\3\3\3\4"+
		"\6\4\'\n\4\r\4\16\4(\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\5\6:\n\6\3\6\3\6\3\7\3\7\3\7\3\7\5\7B\n\7\3\7\3\7\3\b\3\b\3"+
		"\b\2\2\t\3\3\5\4\7\5\t\6\13\7\r\b\17\t\3\2\5\3\2\62;\5\2\13\f\17\17\""+
		"\"\7\2\'\',-//\61\61>>P\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\22\3\2\2\2\5!\3\2\2\2\7&\3"+
		"\2\2\2\t,\3\2\2\2\139\3\2\2\2\rA\3\2\2\2\17E\3\2\2\2\21\23\t\2\2\2\22"+
		"\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2\2\25\26\3\2\2\2\26"+
		"\27\b\2\2\2\27\4\3\2\2\2\30\31\7v\2\2\31\32\7t\2\2\32\33\7w\2\2\33\"\7"+
		"g\2\2\34\35\7h\2\2\35\36\7c\2\2\36\37\7n\2\2\37 \7u\2\2 \"\7g\2\2!\30"+
		"\3\2\2\2!\34\3\2\2\2\"#\3\2\2\2#$\b\3\3\2$\6\3\2\2\2%\'\t\3\2\2&%\3\2"+
		"\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\b\4\4\2+\b\3\2\2\2,-\7"+
		"#\2\2-.\b\5\5\2.\n\3\2\2\2/:\t\4\2\2\60\61\7>\2\2\61:\7?\2\2\62\63\7?"+
		"\2\2\63:\7?\2\2\64\65\7#\2\2\65:\7?\2\2\66\67\7@\2\2\67:\7?\2\28:\7@\2"+
		"\29/\3\2\2\29\60\3\2\2\29\62\3\2\2\29\64\3\2\2\29\66\3\2\2\298\3\2\2\2"+
		":;\3\2\2\2;<\b\6\6\2<\f\3\2\2\2=>\7(\2\2>B\7(\2\2?@\7~\2\2@B\7~\2\2A="+
		"\3\2\2\2A?\3\2\2\2BC\3\2\2\2CD\b\7\7\2D\16\3\2\2\2EF\7=\2\2FG\b\b\b\2"+
		"G\20\3\2\2\2\b\2\24!(9A\t\3\2\2\3\3\3\b\2\2\3\5\4\3\6\5\3\7\6\3\b\7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}