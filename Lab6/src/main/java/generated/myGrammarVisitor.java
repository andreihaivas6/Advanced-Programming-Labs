package generated;// Generated from D:/Facultate/MATERII/An 2 Sem2/3. PA/Laboratoare/Lab6/src/main/java\myGrammar.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link myGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface myGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#punct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPunct(myGrammarParser.PunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(myGrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(myGrammarParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#circleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCircleCommand(myGrammarParser.CircleCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#raza}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRaza(myGrammarParser.RazaContext ctx);
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#polygonCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolygonCommand(myGrammarParser.PolygonCommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#nrLaturi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNrLaturi(myGrammarParser.NrLaturiContext ctx);
	/**
	 * Visit a parse tree produced by {@link myGrammarParser#dimensiune}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensiune(myGrammarParser.DimensiuneContext ctx);
}