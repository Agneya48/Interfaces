import java.awt.Rectangle;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {

        ArrayList<Rectangle> rectangles = new ArrayList<>();
        BigRectangleFilter filter = new BigRectangleFilter(10);
        //will only accept rectangles with a perimeter larger than 10

        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(3, 2));
        // #4 has a perimeter of exactly 10, so good test of cutoff
        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(4, 3));
        rectangles.add(new Rectangle(4, 4));
        rectangles.add(new Rectangle(5, 4));
        rectangles.add(new Rectangle(6, 4));
        rectangles.add(new Rectangle(6, 5));

        int rectNum = 0;
        System.out.println();
        for (Rectangle rectangle : rectangles) {
            rectNum++;
            double perimeter = 2 * (rectangle.width + rectangle.height);
            if (filter.accept(rectangle)) {
                System.out.println("Rectangle #" + rectNum + ":  width " + rectangle.width +
                        ", height " + rectangle.height + ", perimeter " + perimeter);
            }
        }
    }
}
