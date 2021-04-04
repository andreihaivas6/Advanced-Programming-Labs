import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingPanel canvas;
    private LeftPanel leftPanel;

    public MainFrame() {
        super("My drawing App");
        initialization();
    }

    private void initialization() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new BorderLayout());

        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);
        leftPanel = new LeftPanel(this);

        // JFrame foloseste BorderLayout by default
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        add(canvas, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        pack(); // invoke layout manager
    }

    public ConfigPanel getConfigPanel() {
        return configPanel;
    }

    public void setConfigPanel(ConfigPanel configPanel) {
        this.configPanel = configPanel;
    }

    public ControlPanel getControlPanel() {
        return controlPanel;
    }

    public void setControlPanel(ControlPanel controlPanel) {
        this.controlPanel = controlPanel;
    }

    public DrawingPanel getCanvas() {
        return canvas;
    }

    public void setCanvas(DrawingPanel canvas) {
        this.canvas = canvas;
    }

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(LeftPanel leftPanel) {
        this.leftPanel = leftPanel;
    }
}

