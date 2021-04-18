package generated;// Generated from D:/Facultate/MATERII/An 2 Sem2/3. PA/Laboratoare/Lab6/src/main/java\myGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link myGrammarParser}.
 */
public interface myGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#punct}.
	 * @param ctx the parse tree
	 */
	void enterPunct(myGrammarParser.PunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#punct}.
	 * @param ctx the parse tree
	 */
	void exitPunct(myGrammarParser.PunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(myGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(myGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(myGrammarParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(myGrammarParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#circleCommand}.
	 * @param ctx the parse tree
	 */
	void enterCircleCommand(myGrammarParser.CircleCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#circleCommand}.
	 * @param ctx the parse tree
	 */
	void exitCircleCommand(myGrammarParser.CircleCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#raza}.
	 * @param ctx the parse tree
	 */
	void enterRaza(myGrammarParser.RazaContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#raza}.
	 * @param ctx the parse tree
	 */
	void exitRaza(myGrammarParser.RazaContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#polygonCommand}.
	 * @param ctx the parse tree
	 */
	void enterPolygonCommand(myGrammarParser.PolygonCommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#polygonCommand}.
	 * @param ctx the parse tree
	 */
	void exitPolygonCommand(myGrammarParser.PolygonCommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#nrLaturi}.
	 * @param ctx the parse tree
	 */
	void enterNrLaturi(myGrammarParser.NrLaturiContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#nrLaturi}.
	 * @param ctx the parse tree
	 */
	void exitNrLaturi(myGrammarParser.NrLaturiContext ctx);
	/**
	 * Enter a parse tree produced by {@link myGrammarParser#dimensiune}.
	 * @param ctx the parse tree
	 */
	void enterDimensiune(myGrammarParser.DimensiuneContext ctx);
	/**
	 * Exit a parse tree produced by {@link myGrammarParser#dimensiune}.
	 * @param ctx the parse tree
	 */
	void exitDimensiune(myGrammarParser.DimensiuneContext ctx);
}