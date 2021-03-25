import java.awt.*;

public class RegularPolygon extends Polygon {

    public RegularPolygon(int x, int y, int raza, int nrLaturi) {
        double alpha = 2 * Math.PI / nrLaturi;
        for (int i = 0; i < nrLaturi; ++i) {
            double x2 = x + raza * Math.cos(alpha * i);
            double y2 = y + raza * Math.sin(alpha * i);
            this.addPoint((int) x2, (int) y2);
        }
    }
}
