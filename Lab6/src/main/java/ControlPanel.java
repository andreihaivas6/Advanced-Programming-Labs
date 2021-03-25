import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    private final MainFrame frame;
    JButton saveButton  = new JButton("Save");
    JButton loadButton  = new JButton("Load");
    JButton resetButton = new JButton("Reset");
    JButton exitButton  = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        initialization();
    }

    private void initialization() {
        setLayout(new GridLayout(1, 4)); // for fun

        saveButton.setPreferredSize(new Dimension(200, 50)); // seteaza la toate butoanele

        add(saveButton);
        add(loadButton);
        add(resetButton);
        add(exitButton);

        saveButton.addActionListener(this::save);
        loadButton.addActionListener(this::load);
        resetButton.addActionListener(e -> { // new ActionListener
            frame.getCanvas().clearScreen();
            frame.getCanvas().repaint();
        });
        exitButton.addActionListener(e -> System.exit(1));
    }

    private void save(ActionEvent actionEvent) {
        try {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
                System.out.println("User-ul a dat cancel. Nu se poate face save.");
                return;
            }

            File file = fc.getSelectedFile();
            ImageIO.write(frame.getCanvas().image, "PNG", file);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void load(ActionEvent actionEvent){
        try {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
                System.out.println("User-ul a dat cancel. Nu se poate face load.");
                return;
            }

            File file = fc.getSelectedFile();
            BufferedImage image = ImageIO.read(file);
            frame.getCanvas().setImage(image);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
