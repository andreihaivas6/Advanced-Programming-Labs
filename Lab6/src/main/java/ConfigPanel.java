import generated.myGrammarLexer;
import generated.myGrammarParser;
import grammar.Listener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    private final MainFrame frame;

    JLabel    sidesLabel,  dimensionLabel;
    JSpinner  sidesNumber, dimensionShape;
    JComboBox colorCombo; // set de culori
    JTextArea textArea;
//    JScrollPane scrollPane;
    JButton submitButton = new JButton("Submit");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        initialization();
    }

    private void initialization() {
        sidesLabel = new JLabel("Number of sides");
        sidesNumber = new JSpinner(new SpinnerNumberModel(5, 3, 100, 1));
//        sidesNumber.setValue(5);

        Color[] colors = new Color[]{ Color.RED, Color.BLUE, Color.orange, Color.BLACK,
                Color.GREEN, Color.CYAN, Color.magenta, Color.PINK};
        colorCombo = new JComboBox(colors);
        colorCombo.setPreferredSize(new Dimension(100,40));
        colorCombo.setRenderer(new MyCellRenderer()); // sa apara culori in loc de text
//        colorCombo.setMaximumRowCount(5);

        dimensionLabel = new JLabel("Dimension");
        dimensionShape = new JSpinner(new SpinnerNumberModel(50, 1, 100, 5));

        textArea = new JTextArea(2, 20);
//        scrollPane = new JScrollPane(textArea);

        add(dimensionLabel); // JPanel foloseste FlowLayout by default
        add(dimensionShape);
        add(sidesLabel);
        add(sidesNumber);
        add(colorCombo);
        add(textArea);

        submitButton.addActionListener(this::submit);
        add(submitButton);
    }

    private void submit(ActionEvent actionEvent) { // pornim parserul
        String command = textArea.getText();
        System.out.println(command);

        myGrammarLexer lexer = new myGrammarLexer(CharStreams.fromString(command));
        myGrammarParser parser = new myGrammarParser(new CommonTokenStream(lexer));

        Listener listener = new Listener();
        parser.addParseListener(listener);
        parser.command().enterRule(listener);

        frame.getCanvas().submitCommand(listener.getType(), listener.getShapeName(),
                    listener.getX(), listener.getY(), listener.getRaza(), listener.getNrLaturi());
    }

    public MainFrame getFrame() {
        return frame;
    }

    public JLabel getSidesLabel() {
        return sidesLabel;
    }

    public void setSidesLabel(JLabel sidesLabel) {
        this.sidesLabel = sidesLabel;
    }

    public JLabel getDimensionLabel() {
        return dimensionLabel;
    }

    public void setDimensionLabel(JLabel dimensionLabel) {
        this.dimensionLabel = dimensionLabel;
    }

    public JSpinner getSidesNumber() {
        return sidesNumber;
    }

    public void setSidesNumber(JSpinner sidesNumber) {
        this.sidesNumber = sidesNumber;
    }

    public JSpinner getDimensionShape() {
        return dimensionShape;
    }

    public void setDimensionShape(JSpinner dimensionShape) {
        this.dimensionShape = dimensionShape;
    }

    public JComboBox getColorCombo() {
        return colorCombo;
    }

    public void setColorCombo(JComboBox colorCombo) {
        this.colorCombo = colorCombo;
    }
}
