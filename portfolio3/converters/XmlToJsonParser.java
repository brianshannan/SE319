// Generated from XmlToJson.g4 by ANTLR 4.4
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
		WS=1, TEXT=2, XML_DEC_OPEN=3, XML_DEC_CLOSE=4, XML_BEG_OPEN=5, XML_END_OPEN=6, 
		XML_CLOSE=7, XML_EMPTY_CLOSE=8, NAME=9, ATTR_DATA=10, EQUALS=11, COMMENT=12;
	public static final String[] tokenNames = {
		"<INVALID>", "WS", "TEXT", "'<?xml'", "'?>'", "'<'", "'</'", "'>'", "'/>'", 
		"NAME", "ATTR_DATA", "'='", "COMMENT"
	};
	public static final int
		RULE_start = 0, RULE_xml_dec = 1, RULE_content = 2, RULE_element = 3, 
		RULE_attribute = 4;
	public static final String[] ruleNames = {
		"start", "xml_dec", "content", "element", "attribute"
	};

	@Override
	public String getGrammarFileName() { return "XmlToJson.g4"; }

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
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_la = _input.LA(1);
			if (_la==XML_DEC_OPEN) {
				{
				setState(10); xml_dec();
				}
			}

			setState(13); content();
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
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).enterXml_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).exitXml_dec(this);
		}
	}

	public final Xml_decContext xml_dec() throws RecognitionException {
		Xml_decContext _localctx = new Xml_decContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_xml_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15); match(XML_DEC_OPEN);
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NAME) {
				{
				{
				setState(16); attribute();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(22); match(XML_DEC_CLOSE);
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
		public TerminalNode TEXT(int i) {
			return getToken(XmlToJsonParser.TEXT, i);
		}
		public List<ElementContext> element() {
			return getRuleContexts(ElementContext.class);
		}
		public ElementContext element(int i) {
			return getRuleContext(ElementContext.class,i);
		}
		public List<TerminalNode> TEXT() { return getTokens(XmlToJsonParser.TEXT); }
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
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).enterContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).exitContent(this);
		}
	}

	public final ContentContext content() throws RecognitionException {
		ContentContext _localctx = new ContentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TEXT) | (1L << XML_BEG_OPEN) | (1L << COMMENT))) != 0)) {
				{
				setState(27);
				switch (_input.LA(1)) {
				case XML_BEG_OPEN:
					{
					setState(24); element();
					}
					break;
				case TEXT:
					{
					setState(25); match(TEXT);
					}
					break;
				case COMMENT:
					{
					setState(26); match(COMMENT);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(31);
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
		public TerminalNode XML_EMPTY_CLOSE() { return getToken(XmlToJsonParser.XML_EMPTY_CLOSE, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public TerminalNode XML_BEG_OPEN() { return getToken(XmlToJsonParser.XML_BEG_OPEN, 0); }
		public TerminalNode NAME(int i) {
			return getToken(XmlToJsonParser.NAME, i);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public ContentContext content() {
			return getRuleContext(ContentContext.class,0);
		}
		public List<TerminalNode> XML_CLOSE() { return getTokens(XmlToJsonParser.XML_CLOSE); }
		public List<TerminalNode> NAME() { return getTokens(XmlToJsonParser.NAME); }
		public TerminalNode XML_END_OPEN() { return getToken(XmlToJsonParser.XML_END_OPEN, 0); }
		public TerminalNode XML_CLOSE(int i) {
			return getToken(XmlToJsonParser.XML_CLOSE, i);
		}
		public ElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_element; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).enterElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).exitElement(this);
		}
	}

	public final ElementContext element() throws RecognitionException {
		ElementContext _localctx = new ElementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_element);
		int _la;
		try {
			setState(55);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32); match(XML_BEG_OPEN);
				setState(33); match(NAME);
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(34); attribute();
					}
					}
					setState(39);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(40); match(XML_CLOSE);
				setState(41); content();
				setState(42); match(XML_END_OPEN);
				setState(43); match(NAME);
				setState(44); match(XML_CLOSE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46); match(XML_BEG_OPEN);
				setState(47); match(NAME);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NAME) {
					{
					{
					setState(48); attribute();
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(54); match(XML_EMPTY_CLOSE);
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
		public TerminalNode EQUALS() { return getToken(XmlToJsonParser.EQUALS, 0); }
		public TerminalNode ATTR_DATA() { return getToken(XmlToJsonParser.ATTR_DATA, 0); }
		public TerminalNode NAME() { return getToken(XmlToJsonParser.NAME, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XmlToJsonListener ) ((XmlToJsonListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); match(NAME);
			setState(58); match(EQUALS);
			setState(59); match(ATTR_DATA);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16@\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\5\2\16\n\2\3\2\3\2\3\3\3\3\7\3\24\n\3\f"+
		"\3\16\3\27\13\3\3\3\3\3\3\4\3\4\3\4\7\4\36\n\4\f\4\16\4!\13\4\3\5\3\5"+
		"\3\5\7\5&\n\5\f\5\16\5)\13\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\64"+
		"\n\5\f\5\16\5\67\13\5\3\5\5\5:\n\5\3\6\3\6\3\6\3\6\3\6\2\2\7\2\4\6\b\n"+
		"\2\2B\2\r\3\2\2\2\4\21\3\2\2\2\6\37\3\2\2\2\b9\3\2\2\2\n;\3\2\2\2\f\16"+
		"\5\4\3\2\r\f\3\2\2\2\r\16\3\2\2\2\16\17\3\2\2\2\17\20\5\6\4\2\20\3\3\2"+
		"\2\2\21\25\7\5\2\2\22\24\5\n\6\2\23\22\3\2\2\2\24\27\3\2\2\2\25\23\3\2"+
		"\2\2\25\26\3\2\2\2\26\30\3\2\2\2\27\25\3\2\2\2\30\31\7\6\2\2\31\5\3\2"+
		"\2\2\32\36\5\b\5\2\33\36\7\4\2\2\34\36\7\16\2\2\35\32\3\2\2\2\35\33\3"+
		"\2\2\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \7\3\2\2\2"+
		"!\37\3\2\2\2\"#\7\7\2\2#\'\7\13\2\2$&\5\n\6\2%$\3\2\2\2&)\3\2\2\2\'%\3"+
		"\2\2\2\'(\3\2\2\2(*\3\2\2\2)\'\3\2\2\2*+\7\t\2\2+,\5\6\4\2,-\7\b\2\2-"+
		".\7\13\2\2./\7\t\2\2/:\3\2\2\2\60\61\7\7\2\2\61\65\7\13\2\2\62\64\5\n"+
		"\6\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\668\3\2\2"+
		"\2\67\65\3\2\2\28:\7\n\2\29\"\3\2\2\29\60\3\2\2\2:\t\3\2\2\2;<\7\13\2"+
		"\2<=\7\r\2\2=>\7\f\2\2>\13\3\2\2\2\t\r\25\35\37\'\659";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}