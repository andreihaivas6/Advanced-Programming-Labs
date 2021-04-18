package generated;// Generated from D:/Facultate/MATERII/An 2 Sem2/3. PA/Laboratoare/Lab6/src/main/java\myGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class myGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NR=6;
	public static final int
		RULE_punct = 0, RULE_type = 1, RULE_command = 2, RULE_circleCommand = 3, 
		RULE_raza = 4, RULE_polygonCommand = 5, RULE_nrLaturi = 6, RULE_dimensiune = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"punct", "type", "command", "circleCommand", "raza", "polygonCommand", 
			"nrLaturi", "dimensiune"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "'fill'", "'draw'", "' circle'", "' polygon'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "grammar/myGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public myGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PunctContext extends ParserRuleContext {
		public List<TerminalNode> NR() { return getTokens(myGrammarParser.NR); }
		public TerminalNode NR(int i) {
			return getToken(myGrammarParser.NR, i);
		}
		public PunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_punct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).enterPunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).exitPunct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor) return ((myGrammarVisitor<? extends T>)visitor).visitPunct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PunctContext punct() throws RecognitionException {
		PunctContext _localctx = new PunctContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_punct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__0);
			setState(17);
			match(NR);
			setState(18);
			match(T__0);
			setState(19);
			match(NR);
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

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor) return ((myGrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_la = _input.LA(1);
			if ( !(_la==T__1 || _la==T__2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class CommandContext extends ParserRuleContext {
		public CircleCommandContext circleCommand() {
			return getRuleContext(CircleCommandContext.class,0);
		}
		public PolygonCommandContext polygonCommand() {
			return getRuleContext(PolygonCommandContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).exitCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor) return ((myGrammarVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_command);
		try {
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(23);
				circleCommand();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(24);
				polygonCommand();
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

	public static class CircleCommandContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PunctContext punct() {
			return getRuleContext(PunctContext.class,0);
		}
		public RazaContext raza() {
			return getRuleContext(RazaContext.class,0);
		}
		public CircleCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circleCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).enterCircleCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).exitCircleCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor) return ((myGrammarVisitor<? extends T>)visitor).visitCircleCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CircleCommandContext circleCommand() throws RecognitionException {
		CircleCommandContext _localctx = new CircleCommandContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_circleCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			type();
			setState(28);
			match(T__3);
			setState(29);
			punct();
			setState(30);
			raza();
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

	public static class RazaContext extends ParserRuleContext {
		public TerminalNode NR() { return getToken(myGrammarParser.NR, 0); }
		public RazaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raza; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).enterRaza(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).exitRaza(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor) return ((myGrammarVisitor<? extends T>)visitor).visitRaza(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RazaContext raza() throws RecognitionException {
		RazaContext _localctx = new RazaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_raza);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(T__0);
			setState(33);
			match(NR);
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

	public static class PolygonCommandContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public PunctContext punct() {
			return getRuleContext(PunctContext.class,0);
		}
		public NrLaturiContext nrLaturi() {
			return getRuleContext(NrLaturiContext.class,0);
		}
		public DimensiuneContext dimensiune() {
			return getRuleContext(DimensiuneContext.class,0);
		}
		public PolygonCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polygonCommand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).enterPolygonCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).exitPolygonCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor) return ((myGrammarVisitor<? extends T>)visitor).visitPolygonCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolygonCommandContext polygonCommand() throws RecognitionException {
		PolygonCommandContext _localctx = new PolygonCommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_polygonCommand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			type();
			setState(36);
			match(T__4);
			setState(37);
			punct();
			setState(38);
			nrLaturi();
			setState(39);
			dimensiune();
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

	public static class NrLaturiContext extends ParserRuleContext {
		public TerminalNode NR() { return getToken(myGrammarParser.NR, 0); }
		public NrLaturiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nrLaturi; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).enterNrLaturi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).exitNrLaturi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor) return ((myGrammarVisitor<? extends T>)visitor).visitNrLaturi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NrLaturiContext nrLaturi() throws RecognitionException {
		NrLaturiContext _localctx = new NrLaturiContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_nrLaturi);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__0);
			setState(42);
			match(NR);
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

	public static class DimensiuneContext extends ParserRuleContext {
		public TerminalNode NR() { return getToken(myGrammarParser.NR, 0); }
		public DimensiuneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensiune; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).enterDimensiune(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof myGrammarListener) ((myGrammarListener)listener).exitDimensiune(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof myGrammarVisitor) return ((myGrammarVisitor<? extends T>)visitor).visitDimensiune(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensiuneContext dimensiune() throws RecognitionException {
		DimensiuneContext _localctx = new DimensiuneContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_dimensiune);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__0);
			setState(45);
			match(NR);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\b\62\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\5\4\34\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\2\2\n\2\4\6\b\n\f\16\20\2"+
		"\3\3\2\4\5\2*\2\22\3\2\2\2\4\27\3\2\2\2\6\33\3\2\2\2\b\35\3\2\2\2\n\""+
		"\3\2\2\2\f%\3\2\2\2\16+\3\2\2\2\20.\3\2\2\2\22\23\7\3\2\2\23\24\7\b\2"+
		"\2\24\25\7\3\2\2\25\26\7\b\2\2\26\3\3\2\2\2\27\30\t\2\2\2\30\5\3\2\2\2"+
		"\31\34\5\b\5\2\32\34\5\f\7\2\33\31\3\2\2\2\33\32\3\2\2\2\34\7\3\2\2\2"+
		"\35\36\5\4\3\2\36\37\7\6\2\2\37 \5\2\2\2 !\5\n\6\2!\t\3\2\2\2\"#\7\3\2"+
		"\2#$\7\b\2\2$\13\3\2\2\2%&\5\4\3\2&\'\7\7\2\2\'(\5\2\2\2()\5\16\b\2)*"+
		"\5\20\t\2*\r\3\2\2\2+,\7\3\2\2,-\7\b\2\2-\17\3\2\2\2./\7\3\2\2/\60\7\b"+
		"\2\2\60\21\3\2\2\2\3\33";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}