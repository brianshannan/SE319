// Generated from XmlToJsonParser.g4 by ANTLR 4.4
package converters;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XmlToJsonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ELEM_WS=7, XML_EMPTY_CLOSE=10, NAME=11, EQUALS=13, XML_BEG_OPEN=4, XML_END_OPEN=5, 
		XML_DEC_OPEN=3, TEXT=6, MULT_WS=1, COMMENT=2, XML_DEC_CLOSE=8, ATTR_DATA=12, 
		XML_CLOSE=9;
	public static final String[] tokenNames = {
		"<INVALID>", "MULT_WS", "COMMENT", "'<?xml'", "'<'", "'</'", "TEXT", "ELEM_WS", 
		"'?>'", "'>'", "'/>'", "NAME", "ATTR_DATA", "'='"
	};
	public static final int
		RULE_start = 0, RULE_xml_dec = 1, RULE_content = 2, RULE_element = 3, 
		RULE_attribute = 4, RULE_text = 5;
	public static final String[] ruleNames = {
		"start", "xml_dec", "content", "element", "attribute", "text"
	};

	@Override
	public String getGrammarFileName() { return "XmlToJsonParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XmlToJsonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public Xml_decContext xml_dec() {
			return getRuleContext(Xml_decContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_la = _input.LA(1);
			if (_la==XML_DEC_OPEN) {
				{
				setState(12); xml_dec();
				}
			}

			setState(15); content();
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

	public static class Xml_decContext extends ParserRuleContext {
		public TerminalNode XML_DEC_CLOSE() { return getToken(XmlToJsonParser.XML_DEC_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public TerminalNode XML_DEC_OPEN() { return getToken(XmlToJsonParser.XML_DEC_OPEN, 0); }
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Xml_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xml_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).enterXml_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).exitXml_dec(this);
		}
	}

	public final Xml_decContext xml_dec() throws RecognitionException {
		Xml_decContext _localctx = new Xml_decContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_xml_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17); match(XML_DEC_OPEN);
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(18); attribute();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24); match(XML_DEC_CLOSE);
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

	public static class ContentContext extends ParserRuleContext {
		public List<TextContext> text() {
			return getRuleContexts(TextContext.class);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public TextContext text(int i) {
			return getRuleContext(TextContext.class,i);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public TerminalNode COMMENT(int i) {
			return getToken(XmlToJsonParser.COMMENT, i);
		}
		public List<TerminalNode> COMMENT() { return getTokens(XmlToJsonParser.COMMENT); }
		public ContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).exitContent(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << XML_BEG_OPEN) | (1L << TEXT))) != 0)) {
				{
				setState(29);
				switch (_input.LA(1)) {
				case XML_BEG_OPEN:
					{
					setState(26); element();
					}
					break;
				case TEXT:
					{
					setState(27); text();
					}
					break;
				case COMMENT:
					{
					setState(28); match(COMMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
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

	public static class ElementContext extends ParserRuleContext {
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public TerminalNode NAME(int i) {
			return getToken(XmlToJsonParser.NAME, i);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public List<TerminalNode> NAME() { return getTokens(XmlToJsonParser.NAME); }
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_element);
		int _la;
		try {
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(34); match(XML_BEG_OPEN);
				setState(35); match(NAME);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(36); attribute();
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(42); match(XML_CLOSE);
				setState(43); content();
				setState(44); match(XML_END_OPEN);
				setState(45); match(NAME);
				setState(46); match(XML_CLOSE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48); match(XML_BEG_OPEN);
				setState(49); match(NAME);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(50); attribute();
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(56); match(XML_EMPTY_CLOSE);
				}
				break;
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

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode ATTR_DATA() { return getToken(XmlToJsonParser.ATTR_DATA, 0); }
		public TerminalNode NAME() { return getToken(XmlToJsonParser.NAME, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(NAME);
			setState(60); match(EQUALS);
			setState(61); match(ATTR_DATA);
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

	public static class TextContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(XmlToJsonParser.TEXT, 0); }
		public TextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_text; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).enterText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonParserListener ) ((XmlToJsonParserListener)listener).exitText(this);
		}
	}

	public final TextContext text() throws RecognitionException {
		TextContext _localctx = new TextContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_text);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63); match(TEXT);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\17D\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\5\2\20\n\2\3\2\3\2\3\3\3\3\7\3"+
		"\26\n\3\f\3\16\3\31\13\3\3\3\3\3\3\4\3\4\3\4\7\4 \n\4\f\4\16\4#\13\4\3"+
		"\5\3\5\3\5\7\5(\n\5\f\5\16\5+\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\7\5\66\n\5\f\5\16\59\13\5\3\5\5\5<\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\2"+
		"\2\b\2\4\6\b\n\f\2\2E\2\17\3\2\2\2\4\23\3\2\2\2\6!\3\2\2\2\b;\3\2\2\2"+
		"\n=\3\2\2\2\fA\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\17\20\3\2\2\2\20\21"+
		"\3\2\2\2\21\22\5\6\4\2\22\3\3\2\2\2\23\27\7\5\2\2\24\26\5\n\6\2\25\24"+
		"\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27"+
		"\3\2\2\2\32\33\7\n\2\2\33\5\3\2\2\2\34 \5\b\5\2\35 \5\f\7\2\36 \7\4\2"+
		"\2\37\34\3\2\2\2\37\35\3\2\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\""+
		"\3\2\2\2\"\7\3\2\2\2#!\3\2\2\2$%\7\6\2\2%)\7\r\2\2&(\5\n\6\2\'&\3\2\2"+
		"\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\13\2\2-.\5\6"+
		"\4\2./\7\7\2\2/\60\7\r\2\2\60\61\7\13\2\2\61<\3\2\2\2\62\63\7\6\2\2\63"+
		"\67\7\r\2\2\64\66\5\n\6\2\65\64\3\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678"+
		"\3\2\2\28:\3\2\2\29\67\3\2\2\2:<\7\f\2\2;$\3\2\2\2;\62\3\2\2\2<\t\3\2"+
		"\2\2=>\7\r\2\2>?\7\17\2\2?@\7\16\2\2@\13\3\2\2\2AB\7\b\2\2B\r\3\2\2\2"+
		"\t\17\27\37!)\67;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}