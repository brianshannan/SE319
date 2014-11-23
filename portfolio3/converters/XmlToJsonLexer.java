// Generated from XmlToJson.g4 by ANTLR 4.4
package converters;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XmlToJsonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WS=1, TEXT=2, XML_DEC_OPEN=3, XML_DEC_CLOSE=4, XML_BEG_OPEN=5, XML_END_OPEN=6, 
		XML_CLOSE=7, XML_EMPTY_CLOSE=8, NAME=9, ATTR_DATA=10, EQUALS=11, COMMENT=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"WS", "TEXT_CHAR", "TEXT", "XML_DEC_OPEN", "XML_DEC_CLOSE", "XML_BEG_OPEN", 
		"XML_END_OPEN", "XML_CLOSE", "XML_EMPTY_CLOSE", "NAME_START", "NAME_CHAR", 
		"NAME", "ATTR_DATA", "EQUALS", "COMMENT"
	};


	public XmlToJsonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XmlToJson.g4"; }

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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2#\n\2\r\2\16"+
		"\2$\3\2\3\2\3\3\3\3\3\4\6\4,\n\4\r\4\16\4-\3\5\3\5\3\5\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\7\rI\n\r\f\r\16\rL\13\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16T\n\16"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20^\n\20\f\20\16\20a\13\20"+
		"\3\20\3\20\3\20\3\20\3_\2\21\3\3\5\2\7\4\t\5\13\6\r\7\17\b\21\t\23\n\25"+
		"\2\27\2\31\13\33\f\35\r\37\16\3\2\b\5\2\13\f\17\17\"\"\6\2((>>@@``\4\2"+
		"C\\c|\5\2\62;C\\c|\7\2$$((>>@@``\6\2()>>@@``g\2\3\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\3\"\3\2\2\2"+
		"\5(\3\2\2\2\7+\3\2\2\2\t/\3\2\2\2\13\65\3\2\2\2\r8\3\2\2\2\17:\3\2\2\2"+
		"\21=\3\2\2\2\23?\3\2\2\2\25B\3\2\2\2\27D\3\2\2\2\31F\3\2\2\2\33S\3\2\2"+
		"\2\35U\3\2\2\2\37W\3\2\2\2!#\t\2\2\2\"!\3\2\2\2#$\3\2\2\2$\"\3\2\2\2$"+
		"%\3\2\2\2%&\3\2\2\2&\'\b\2\2\2\'\4\3\2\2\2()\t\3\2\2)\6\3\2\2\2*,\5\5"+
		"\3\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\b\3\2\2\2/\60\7>\2\2\60"+
		"\61\7A\2\2\61\62\7z\2\2\62\63\7o\2\2\63\64\7n\2\2\64\n\3\2\2\2\65\66\7"+
		"A\2\2\66\67\7@\2\2\67\f\3\2\2\289\7>\2\29\16\3\2\2\2:;\7>\2\2;<\7\61\2"+
		"\2<\20\3\2\2\2=>\7@\2\2>\22\3\2\2\2?@\7\61\2\2@A\7@\2\2A\24\3\2\2\2BC"+
		"\t\4\2\2C\26\3\2\2\2DE\t\5\2\2E\30\3\2\2\2FJ\5\25\13\2GI\5\27\f\2HG\3"+
		"\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\32\3\2\2\2LJ\3\2\2\2MN\7$\2\2NO"+
		"\t\6\2\2OT\7$\2\2PQ\7)\2\2QR\t\7\2\2RT\7)\2\2SM\3\2\2\2SP\3\2\2\2T\34"+
		"\3\2\2\2UV\7?\2\2V\36\3\2\2\2WX\7>\2\2XY\7#\2\2YZ\7/\2\2Z[\7/\2\2[_\3"+
		"\2\2\2\\^\13\2\2\2]\\\3\2\2\2^a\3\2\2\2_`\3\2\2\2_]\3\2\2\2`b\3\2\2\2"+
		"a_\3\2\2\2bc\7/\2\2cd\7/\2\2de\7@\2\2e \3\2\2\2\b\2$-JS_\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}