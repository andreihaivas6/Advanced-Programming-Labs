import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel implements MouseListener, ActionListener, MouseMotionListener {
    final MainFrame frame;
    final static int myWidth = 800, myHeight = 600;

    BufferedImage image;
    Graphics2D graphics;

    private int x1, y1;
    private int x2, y2;
    private List<Pair> points; // memoram punctele de la Free Mode

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
        graphics.setStroke(new BasicStroke(4));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void mousePressed(MouseEvent event) {
        x1 = x2 = event.getX();
        y1 = y2 = event.getY();
        drawShape(x1, y1);
        if(frame.getLeftPanel().getOption().equals("Free Mode")) {
            points = new ArrayList<>();
        }
        repaint();
    }

    private void drawShape(int x, int y) {
        int raza = (int) frame.getConfigPanel().getDimensionShape().getValue();
        int nrLaturi = (int) frame.getConfigPanel().getSidesNumber().getValue();

        Color culoare = (Color) frame.getConfigPanel().getColorCombo().getSelectedItem();
        graphics.setColor(culoare);

        switch (frame.getLeftPanel().getOption()) {
            case "Polygon":
                graphics.fill(new RegularPolygon(x, y, raza, nrLaturi));
                break;
            case "Circle":
                graphics.fill(new Circle(x, y, raza));
                break;
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) { // verificam linie/cerc
        if (frame.getLeftPanel().getOption().equals("Line")) {
            System.out.println("Aceasta este o linie.");
        } else if (frame.getLeftPanel().getOption().equals("Circle")) {
            System.out.println("Acesta este un cerc.");
        } else if (frame.getLeftPanel().getOption().equals("Free Mode")) {
            if(verifyLine()) {
                System.out.println("Aceasta este o linie.");
            } else if (verifyCircle()) {
                System.out.println("Acesta este un cerc.");
            }
        }
    }

    private boolean verifyLine() {
        // comparam pantele a cate 2 puncte consecutive
        for(int i = 0; i < points.size() - 10; ++i) {
            float panta1 = (float)(points.get(i + 5).second - points.get(i).second)
                    / (points.get(i + 5).first - points.get(i).first);
            float panta2 = (float)(points.get(i + 10).second - points.get(i + 5).second)
                    / (points.get(i + 10).first - points.get(i + 5).first);
            if(Math.abs(panta1 - panta2) > 1) // marja de eroare
                return false;
        }
        return true;
    }

    public boolean verifyCircle() {
        // comparam distantele dintre 2 puncte opuse (diametrele cercului)
        if(points.size() == 0)
            return false;
        int mij = points.size() / 2;
        double t1 = points.get(mij).first - points.get(0).first;
        double t2 = points.get(mij).second - points.get(0).second;
        double diam = Math.sqrt(t1 * t1 + t2 * t2);

        for(int i = 0; i < mij; ++i) {
            t1 = points.get(i + mij).first - points.get(i).first;
            t2 = points.get(i + mij).second - points.get(i).second;
            double diam2 = Math.sqrt(t1 * t1 + t2 * t2);
            if(Math.abs(diam - diam2) > 0.25 * diam) // marja de eroare
                return false;
        }
        return (Math.abs(points.get(0).first - points.get(points.size() - 1).first) < 20) &&
                (Math.abs(points.get(0).second - points.get(points.size() - 1).second) < 20);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (frame.getLeftPanel().getOption().equals("Free Mode")) {
            int raza = (int) frame.getConfigPanel().dimensionShape.getValue() / 5;
            graphics.setColor((Color)frame.getConfigPanel().colorCombo.getSelectedItem());
            graphics.fill(new Circle(e.getX(), e.getY(), raza));
            repaint();
            points.add(new Pair(e.getX(), e.getY()));
        } else if (frame.getLeftPanel().getOption().equals("Line")) {
            graphics.setColor(Color.white);
            graphics.drawLine(x1, y1, x2, y2);
            graphics.setColor((Color) frame.getConfigPanel().getColorCombo().getSelectedItem());
            graphics.drawLine(x1, y1, e.getX(), e.getY());
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        } else if (frame.getLeftPanel().getOption().equals("Erase")) {
            int raza = (int) frame.getConfigPanel().dimensionShape.getValue() / 4;
            graphics.setColor(Color.white);
            graphics.fill(new Circle(e.getX(), e.getY(), raza));
            repaint();
        }
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
