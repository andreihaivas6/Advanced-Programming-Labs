import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    private final MainFrame frame;
    private String option;

    JButton freeModeButton = new JButton("Free Mode");
    JButton polygonButton  = new JButton("Polygon");
    JButton circleButton   = new JButton("Circle");
    JButton lineButton     = new JButton("Line");
    JButton eraseButton    = new JButton("Erase");

    public LeftPanel(MainFrame frame) {
        this.frame = frame;
        option = "Polygon";
        initialization();
    }

    private void initialization() {
        setLayout(new GridLayout(6, 1, 0, 50));

        add(freeModeButton);
        add(polygonButton);
        add(circleButton);
        add(lineButton);
        add(eraseButton);

        freeModeButton.addActionListener(e -> {
            option = "Free Mode";
            frame.getConfigPanel().sidesNumber.setVisible(false);
            frame.getConfigPanel().sidesLabel.setVisible(false);
            frame.getConfigPanel().colorCombo.setVisible(true);
            frame.getConfigPanel().dimensionShape.setVisible(true);
            frame.getConfigPanel().dimensionLabel.setVisible(true);
        });
        lineButton.addActionListener(e -> {
            option = "Line";
            frame.getConfigPanel().sidesNumber.setVisible(false);
            frame.getConfigPanel().sidesLabel.setVisible(false);
            frame.getConfigPanel().colorCombo.setVisible(true);
            frame.getConfigPanel().dimensionShape.setVisible(false);
            frame.getConfigPanel().dimensionLabel.setVisible(false);
        });
        eraseButton.addActionListener(e -> {
            option = "Erase";
            frame.getConfigPanel().sidesNumber.setVisible(false);
            frame.getConfigPanel().sidesLabel.setVisible(false);
            frame.getConfigPanel().colorCombo.setVisible(false);
            frame.getConfigPanel().dimensionShape.setVisible(true);
            frame.getConfigPanel().dimensionLabel.setVisible(true);
        });
        polygonButton.addActionListener(e -> {
            option = "Polygon";
            frame.getConfigPanel().sidesNumber.setVisible(true);
            frame.getConfigPanel().sidesLabel.setVisible(true);
            frame.getConfigPanel().colorCombo.setVisible(true);
            frame.getConfigPanel().dimensionShape.setVisible(true);
            frame.getConfigPanel().dimensionLabel.setVisible(true);
        });
        circleButton.addActionListener(e -> {
            option = "Circle";
            frame.getConfigPanel().sidesNumber.setVisible(false);
            frame.getConfigPanel().sidesLabel.setVisible(false);
            frame.getConfigPanel().colorCombo.setVisible(true);
            frame.getConfigPanel().dimensionShape.setVisible(true);
            frame.getConfigPanel().dimensionLabel.setVisible(true);
        });
    }

    public MainFrame getFrame() {
        return frame;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }
}
