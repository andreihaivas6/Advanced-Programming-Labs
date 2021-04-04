import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Double {
    public Circle(double x, double y, double radius) {
        super(x - radius / 2, y - radius / 2, radius, radius);
    }
}
