// Generated from simple.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class simpleLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ALPHA=1, NUMERIC=2, EXIT=3, NEWLINE=4, WS=5;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'"
	};
	public static final String[] ruleNames = {
		"ALPHA", "NUMERIC", "EXIT", "NEWLINE", "WS"
	};


	public simpleLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "simple.g4"; }

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
		case 0: ALPHA_action((RuleContext)_localctx, actionIndex); break;
		case 1: NUMERIC_action((RuleContext)_localctx, actionIndex); break;
		case 2: EXIT_action((RuleContext)_localctx, actionIndex); break;
		case 4: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void EXIT_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:  System.out.println("EXITING!"); System.exit(0);  break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3: skip(); break;
		}
	}
	private void NUMERIC_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:  System.out.println("Found numeric: "+getText());  break;
		}
	}
	private void ALPHA_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  System.out.println("Found alpha: "+getText());  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\7*\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\6\2\17\n\2\r\2\16\2\20\3\2\3\2\3\3"+
		"\6\3\26\n\3\r\3\16\3\27\3\3\3\3\3\4\3\4\3\4\3\5\5\5 \n\5\3\5\3\5\3\6\6"+
		"\6%\n\6\r\6\16\6&\3\6\3\6\2\2\7\3\3\5\4\7\5\t\6\13\7\3\2\4\4\2C\\c|\4"+
		"\2\13\13\"\"-\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\3\16\3\2\2\2\5\25\3\2\2\2\7\33\3\2\2\2\t\37\3\2\2\2\13$\3\2\2\2\r"+
		"\17\t\2\2\2\16\r\3\2\2\2\17\20\3\2\2\2\20\16\3\2\2\2\20\21\3\2\2\2\21"+
		"\22\3\2\2\2\22\23\b\2\2\2\23\4\3\2\2\2\24\26\4\62;\2\25\24\3\2\2\2\26"+
		"\27\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\31\3\2\2\2\31\32\b\3\3\2\32"+
		"\6\3\2\2\2\33\34\7\60\2\2\34\35\b\4\4\2\35\b\3\2\2\2\36 \7\17\2\2\37\36"+
		"\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!\"\7\f\2\2\"\n\3\2\2\2#%\t\3\2\2$#\3\2"+
		"\2\2%&\3\2\2\2&$\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\b\6\5\2)\f\3\2\2\2\7"+
		"\2\20\27\37&\6\3\2\2\3\3\3\3\4\4\3\6\5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}