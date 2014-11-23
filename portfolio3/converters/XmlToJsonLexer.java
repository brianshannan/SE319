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
		WS=1, XML_DEC_OPEN=2, XML_BEG_OPEN=3, XML_END_OPEN=4, TEXT=5, XML_DEC_CLOSE=6, 
		XML_CLOSE=7, XML_EMPTY_CLOSE=8, NAME=9, ATTR_DATA=10, EQUALS=11, COMMENT=12;
	public static final int IN_ELEMENT = 1;
	public static String[] modeNames = {
		"DEFAULT_MODE", "IN_ELEMENT"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'"
	};
	public static final String[] ruleNames = {
		"WS", "XML_DEC_OPEN", "XML_BEG_OPEN", "XML_END_OPEN", "TEXT", "XML_DEC_CLOSE", 
		"XML_CLOSE", "XML_EMPTY_CLOSE", "NAME_START", "NAME_CHAR", "NAME", "ATTR_DATA", 
		"EQUALS", "COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16y\b\1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2\"\n\2\r\2\16\2#\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\6\6:\n\6\r\6\16\6;\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\7\fR\n\f\f\f\16\fU\13\f\3\r\3\r"+
		"\7\rY\n\r\f\r\16\r\\\13\r\3\r\3\r\3\r\7\ra\n\r\f\r\16\rd\13\r\3\r\5\r"+
		"g\n\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17q\n\17\f\17\16\17t\13"+
		"\17\3\17\3\17\3\17\3\17\3r\2\20\4\3\6\4\b\5\n\6\f\7\16\b\20\t\22\n\24"+
		"\2\26\2\30\13\32\f\34\r\36\16\4\2\3\b\5\2\13\f\17\17\"\"\5\2((>>@@\4\2"+
		"C\\c|\7\2/\60\62;C\\aac|\6\2$$((>>@@\5\2()>>@@|\2\4\3\2\2\2\2\6\3\2\2"+
		"\2\2\b\3\2\2\2\2\n\3\2\2\2\2\f\3\2\2\2\3\16\3\2\2\2\3\20\3\2\2\2\3\22"+
		"\3\2\2\2\3\30\3\2\2\2\3\32\3\2\2\2\3\34\3\2\2\2\3\36\3\2\2\2\4!\3\2\2"+
		"\2\6\'\3\2\2\2\b/\3\2\2\2\n\63\3\2\2\2\f9\3\2\2\2\16=\3\2\2\2\20B\3\2"+
		"\2\2\22F\3\2\2\2\24K\3\2\2\2\26M\3\2\2\2\30O\3\2\2\2\32f\3\2\2\2\34h\3"+
		"\2\2\2\36j\3\2\2\2 \"\t\2\2\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2"+
		"$%\3\2\2\2%&\b\2\2\2&\5\3\2\2\2\'(\7>\2\2()\7A\2\2)*\7z\2\2*+\7o\2\2+"+
		",\7n\2\2,-\3\2\2\2-.\b\3\3\2.\7\3\2\2\2/\60\7>\2\2\60\61\3\2\2\2\61\62"+
		"\b\4\3\2\62\t\3\2\2\2\63\64\7>\2\2\64\65\7\61\2\2\65\66\3\2\2\2\66\67"+
		"\b\5\3\2\67\13\3\2\2\28:\n\3\2\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2"+
		"\2<\r\3\2\2\2=>\7A\2\2>?\7@\2\2?@\3\2\2\2@A\b\7\4\2A\17\3\2\2\2BC\7@\2"+
		"\2CD\3\2\2\2DE\b\b\4\2E\21\3\2\2\2FG\7\61\2\2GH\7@\2\2HI\3\2\2\2IJ\b\t"+
		"\4\2J\23\3\2\2\2KL\t\4\2\2L\25\3\2\2\2MN\t\5\2\2N\27\3\2\2\2OS\5\24\n"+
		"\2PR\5\26\13\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\31\3\2\2\2US\3"+
		"\2\2\2VZ\7$\2\2WY\n\6\2\2XW\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[]\3"+
		"\2\2\2\\Z\3\2\2\2]g\7$\2\2^b\7)\2\2_a\n\7\2\2`_\3\2\2\2ad\3\2\2\2b`\3"+
		"\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2eg\7)\2\2fV\3\2\2\2f^\3\2\2\2g\33"+
		"\3\2\2\2hi\7?\2\2i\35\3\2\2\2jk\7>\2\2kl\7#\2\2lm\7/\2\2mn\7/\2\2nr\3"+
		"\2\2\2oq\13\2\2\2po\3\2\2\2qt\3\2\2\2rs\3\2\2\2rp\3\2\2\2su\3\2\2\2tr"+
		"\3\2\2\2uv\7/\2\2vw\7/\2\2wx\7@\2\2x\37\3\2\2\2\13\2\3#;SZbfr\5\b\2\2"+
		"\7\3\2\6\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}