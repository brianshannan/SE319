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
		INT=1, BOOL=2, WS=3, UN_OP=4, BIN_OP=5, END=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'"
	};
	public static final String[] ruleNames = {
		"INT", "BOOL", "WS", "UN_OP", "BIN_OP", "END"
	};


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
		case 3: UN_OP_action((RuleContext)_localctx, actionIndex); break;
		case 4: BIN_OP_action((RuleContext)_localctx, actionIndex); break;
		case 5: END_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void INT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: pushIntToStack(getText()); break;
		}
	}
	private void END_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: System.out.println(stack.pop()); break;
		}
	}
	private void BIN_OP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: applyBinaryOperation(getText()); break;
		}
	}
	private void UN_OP_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: applyUnaryOperation(getText()); break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bA\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\6\2\21\n\2\r\2\16\2\22\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3 \n\3\3\4\6\4#\n\4\r\4\16"+
		"\4$\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\5\6;\n\6\3\6\3\6\3\7\3\7\3\7\2\2\b\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\3\2\5\3\2\62;\5\2\13\f\17\17\"\"\6\2\'\',-//\61\61K\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\3\20\3\2\2"+
		"\2\5\37\3\2\2\2\7\"\3\2\2\2\t(\3\2\2\2\13:\3\2\2\2\r>\3\2\2\2\17\21\t"+
		"\2\2\2\20\17\3\2\2\2\21\22\3\2\2\2\22\20\3\2\2\2\22\23\3\2\2\2\23\24\3"+
		"\2\2\2\24\25\b\2\2\2\25\4\3\2\2\2\26\27\7v\2\2\27\30\7t\2\2\30\31\7w\2"+
		"\2\31 \7g\2\2\32\33\7h\2\2\33\34\7c\2\2\34\35\7n\2\2\35\36\7u\2\2\36 "+
		"\7g\2\2\37\26\3\2\2\2\37\32\3\2\2\2 \6\3\2\2\2!#\t\3\2\2\"!\3\2\2\2#$"+
		"\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%&\3\2\2\2&\'\b\4\3\2\'\b\3\2\2\2()\7#\2"+
		"\2)*\b\5\4\2*\n\3\2\2\2+;\t\4\2\2,-\7(\2\2-;\7(\2\2./\7~\2\2/;\7~\2\2"+
		"\60;\7>\2\2\61\62\7>\2\2\62;\7?\2\2\63\64\7?\2\2\64;\7?\2\2\65\66\7#\2"+
		"\2\66;\7?\2\2\678\7@\2\28;\7?\2\29;\7@\2\2:+\3\2\2\2:,\3\2\2\2:.\3\2\2"+
		"\2:\60\3\2\2\2:\61\3\2\2\2:\63\3\2\2\2:\65\3\2\2\2:\67\3\2\2\2:9\3\2\2"+
		"\2;<\3\2\2\2<=\b\6\5\2=\f\3\2\2\2>?\7=\2\2?@\b\7\6\2@\16\3\2\2\2\7\2\22"+
		"\37$:\7\3\2\2\b\2\2\3\5\3\3\6\4\3\7\5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}