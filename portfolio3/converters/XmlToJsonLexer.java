// Generated from XmlToJsonLexer.g4 by ANTLR 4.4
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
		MULT_WS=1, COMMENT=2, XML_DEC_OPEN=3, XML_BEG_OPEN=4, XML_END_OPEN=5, 
		TEXT=6, ELEM_WS=7, XML_DEC_CLOSE=8, XML_CLOSE=9, XML_EMPTY_CLOSE=10, NAME=11, 
		ATTR_DATA=12, EQUALS=13;
	public static final int IN_ELEMENT = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "IN_ELEMENT"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'"
	};
	public static final String[] ruleNames = {
		"WS", "MULT_WS", "COMMENT", "XML_DEC_OPEN", "XML_BEG_OPEN", "XML_END_OPEN", 
		"TEXT", "ELEM_WS", "XML_DEC_CLOSE", "XML_CLOSE", "XML_EMPTY_CLOSE", "NAME_START", 
		"NAME_CHAR", "NAME", "ATTR_DATA", "EQUALS"
	};


	public XmlToJsonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "XmlToJsonLexer.g4"; }

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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\17\u0086\b\1\b\1"+
		"\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t"+
		"\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3"+
		"\2\3\2\3\3\6\3(\n\3\r\3\16\3)\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4\64\n"+
		"\4\f\4\16\4\67\13\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\6\bO\n\b\r\b\16\bP\3\t\6\tT\n\t"+
		"\r\t\16\tU\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\7\17n\n\17\f\17\16\17q\13\17\3\20"+
		"\3\20\7\20u\n\20\f\20\16\20x\13\20\3\20\3\20\3\20\7\20}\n\20\f\20\16\20"+
		"\u0080\13\20\3\20\5\20\u0083\n\20\3\21\3\21\3\65\2\22\4\2\6\3\b\4\n\5"+
		"\f\6\16\7\20\b\22\t\24\n\26\13\30\f\32\2\34\2\36\r \16\"\17\4\2\3\b\5"+
		"\2\13\f\17\17\"\"\5\2((>>@@\4\2C\\c|\7\2/\60\62;C\\aac|\6\2$$((>>@@\5"+
		"\2()>>@@\u0089\2\6\3\2\2\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\2\16\3"+
		"\2\2\2\2\20\3\2\2\2\3\22\3\2\2\2\3\24\3\2\2\2\3\26\3\2\2\2\3\30\3\2\2"+
		"\2\3\36\3\2\2\2\3 \3\2\2\2\3\"\3\2\2\2\4$\3\2\2\2\6\'\3\2\2\2\b-\3\2\2"+
		"\2\n<\3\2\2\2\fD\3\2\2\2\16H\3\2\2\2\20N\3\2\2\2\22S\3\2\2\2\24Y\3\2\2"+
		"\2\26^\3\2\2\2\30b\3\2\2\2\32g\3\2\2\2\34i\3\2\2\2\36k\3\2\2\2 \u0082"+
		"\3\2\2\2\"\u0084\3\2\2\2$%\t\2\2\2%\5\3\2\2\2&(\5\4\2\2\'&\3\2\2\2()\3"+
		"\2\2\2)\'\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\b\3\2\2,\7\3\2\2\2-.\7>\2\2./"+
		"\7#\2\2/\60\7/\2\2\60\61\7/\2\2\61\65\3\2\2\2\62\64\13\2\2\2\63\62\3\2"+
		"\2\2\64\67\3\2\2\2\65\66\3\2\2\2\65\63\3\2\2\2\668\3\2\2\2\67\65\3\2\2"+
		"\289\7/\2\29:\7/\2\2:;\7@\2\2;\t\3\2\2\2<=\7>\2\2=>\7A\2\2>?\7z\2\2?@"+
		"\7o\2\2@A\7n\2\2AB\3\2\2\2BC\b\5\3\2C\13\3\2\2\2DE\7>\2\2EF\3\2\2\2FG"+
		"\b\6\3\2G\r\3\2\2\2HI\7>\2\2IJ\7\61\2\2JK\3\2\2\2KL\b\7\3\2L\17\3\2\2"+
		"\2MO\n\3\2\2NM\3\2\2\2OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\21\3\2\2\2RT\5\4"+
		"\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WX\b\t\2\2X\23\3"+
		"\2\2\2YZ\7A\2\2Z[\7@\2\2[\\\3\2\2\2\\]\b\n\4\2]\25\3\2\2\2^_\7@\2\2_`"+
		"\3\2\2\2`a\b\13\4\2a\27\3\2\2\2bc\7\61\2\2cd\7@\2\2de\3\2\2\2ef\b\f\4"+
		"\2f\31\3\2\2\2gh\t\4\2\2h\33\3\2\2\2ij\t\5\2\2j\35\3\2\2\2ko\5\32\r\2"+
		"ln\5\34\16\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2p\37\3\2\2\2qo\3\2"+
		"\2\2rv\7$\2\2su\n\6\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2"+
		"\2\2xv\3\2\2\2y\u0083\7$\2\2z~\7)\2\2{}\n\7\2\2|{\3\2\2\2}\u0080\3\2\2"+
		"\2~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0083"+
		"\7)\2\2\u0082r\3\2\2\2\u0082z\3\2\2\2\u0083!\3\2\2\2\u0084\u0085\7?\2"+
		"\2\u0085#\3\2\2\2\f\2\3)\65PUov~\u0082\5\b\2\2\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}