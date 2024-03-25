import java.awt.*;

public class Triangle extends Item {
    private Point point1;
    private Point point2;
    private Point point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    public boolean includes(Point point) {
        // Calculate area of the whole triangle
        double wholeArea = area(point1, point2, point3);

        // Calculate areas of three sub-triangles formed by the point and triangle edges
        double area1 = area(point, point2, point3);
        double area2 = area(point1, point, point3);
        double area3 = area(point1, point2, point);

        // Check if the sum of sub-triangles' areas equals the whole triangle's area
        return Math.abs(wholeArea - (area1 + area2 + area3)) < 0.0001;
    }

    // Helper method to calculate the area of a triangle
    private double area(Point a, Point b, Point c) {
        return Math.abs((a.getX() * (b.getY() - c.getY()) +
                b.getX() * (c.getY() - a.getY()) +
                c.getX() * (a.getY() - b.getY())) / 2.0);
    }

    public void render(UIContext uiContext) {
        uiContext.drawTriangle(point1, point2, point3);
    }
    @Override
    public void translate(int dx, int dy) {
        // Translate the triangle by dx and dy
        if (point1 != null && point2 != null && point3 != null) {
            point1.translate(dx, dy);
            point2.translate(dx, dy);
            point3.translate(dx, dy);
        }
    }
}
