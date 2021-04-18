package grammar;

import generated.myGrammarListener;
import generated.myGrammarParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Listener implements myGrammarListener {

    private String type;
    private String shapeName;
    private int x;
    private int y;
    private int raza;
    private int nrLaturi = 0;

    // draw circle 500 500 150
    // fill polygon 200 200 80 8

    @Override
    public void enterPunct(myGrammarParser.PunctContext ctx) {

    }

    @Override
    public void exitPunct(myGrammarParser.PunctContext ctx) {
        x = Integer.parseInt(ctx.NR(0).getSymbol().getText());
        y = Integer.parseInt(ctx.NR(1).getSymbol().getText());
    }

    @Override
    public void enterType(myGrammarParser.TypeContext ctx) {

    }

    @Override
    public void exitType(myGrammarParser.TypeContext ctx) {
        type = ctx.getText();
    }

    @Override
    public void enterCommand(myGrammarParser.CommandContext ctx) {

    }

    @Override
    public void exitCommand(myGrammarParser.CommandContext ctx) {

    }

    @Override
    public void enterCircleCommand(myGrammarParser.CircleCommandContext ctx) {
        shapeName = "circle";
    }

    @Override
    public void exitCircleCommand(myGrammarParser.CircleCommandContext ctx) {

    }

    @Override
    public void enterRaza(myGrammarParser.RazaContext ctx) {

    }

    @Override
    public void exitRaza(myGrammarParser.RazaContext ctx) {
        raza = Integer.parseInt(ctx.NR().getSymbol().getText());
    }

    @Override
    public void enterPolygonCommand(myGrammarParser.PolygonCommandContext ctx) {
        shapeName = "polygon";
    }

    @Override
    public void exitPolygonCommand(myGrammarParser.PolygonCommandContext ctx) {

    }

    @Override
    public void enterNrLaturi(myGrammarParser.NrLaturiContext ctx) {

    }

    @Override
    public void exitNrLaturi(myGrammarParser.NrLaturiContext ctx) {
        raza = Integer.parseInt(ctx.NR().getSymbol().getText());
    }

    @Override
    public void enterDimensiune(myGrammarParser.DimensiuneContext ctx) {

    }

    @Override
    public void exitDimensiune(myGrammarParser.DimensiuneContext ctx) {
        nrLaturi = Integer.parseInt(ctx.NR().getSymbol().getText());
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRaza() {
        return raza;
    }

    public void setRaza(int raza) {
        this.raza = raza;
    }

    public int getNrLaturi() {
        return nrLaturi;
    }

    public void setNrLaturi(int nrLaturi) {
        this.nrLaturi = nrLaturi;
    }
}
