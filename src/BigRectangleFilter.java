import java.awt.*;

public class BigRectangleFilter implements Filter {

    private double perimeterMinCutoff; //again, implementing a variable parameter for testing and practice; still defaults to 10

    public BigRectangleFilter(double perimeterMinCutoff) {
        this.perimeterMinCutoff = perimeterMinCutoff;
    }

    public BigRectangleFilter() {
        perimeterMinCutoff = 10.0;
    }

    @Override
    public boolean accept(Object x) {

        Rectangle r = (Rectangle) x;
        double perimeter = 2 * (r.width + r.height);
        return perimeter > this.perimeterMinCutoff;
    }

}

// no real need for a getter, setter, or toString class for a filter like this
