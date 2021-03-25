import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int myWidth = 800, myHeight = 600;

    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        clearScreen();
        initialization();
    }

    public void clearScreen() {
        image = new BufferedImage(myWidth, myHeight, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, myWidth, myHeight);
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        graphics = image.createGraphics();
        graphics.drawImage(this.image, 0, 0, null);
        repaint();
    }

    private void initialization() {
        setPreferredSize(new Dimension(myWidth, myHeight));
        setBorder(BorderFactory.createEtchedBorder()); // for fun
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                drawShape(event.getX(), event.getY());
                repaint();
            }

        });
    }

    private void drawShape(int x, int y) {
        int raza      = (int)frame.getConfigPanel().getDimensionShape().getValue();
        int nrLaturi  = (int)frame.getConfigPanel().getSidesNumber().getValue();

        Color culoare = (Color)frame.getConfigPanel().getColorCombo().getSelectedItem();
        graphics.setColor(culoare);

        graphics.fill(new RegularPolygon(x, y, raza, nrLaturi));
    }

    @Override
    public void update(Graphics g) { }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
