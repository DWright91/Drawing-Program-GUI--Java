import java.awt.*;

public class Polygon extends Item {
	private Point point1;
    private Point point2;
    private Point point3;
    private Point point4;
    private Point point5;

    public Polygon(Point point1, Point point2, Point point3, Point point4, Point point5) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.point5 = point5;
    }

    public boolean includes(Point point) {
        Point[] polyPoints = { point1, point2, point3, point4, point5 };
        int i, j;
        boolean result = false;
        for (i = 0, j = 4; i < 5; j = i++) {
            if ((polyPoints[i].getY() > point.getY()) != (polyPoints[j].getY() > point.getY()) &&
                (point.getX() < (polyPoints[j].getX() - polyPoints[i].getX()) * (point.getY() - polyPoints[i].getY()) /
                        (polyPoints[j].getY() - polyPoints[i].getY()) + polyPoints[i].getX())) {
                result = !result;
            }
        }
        return result;
    }

    public void render(UIContext uiContext) {
        uiContext.drawPolygon(point1, point2, point3, point4, point5);
    }
    @Override
    public void translate(int dx, int dy) {
        // Translate the polygon by dx and dy
        if (point1 != null && point2 != null && point3 != null && point4 != null && point5 != null) {
            point1.translate(dx, dy);
            point2.translate(dx, dy);
            point3.translate(dx, dy);
            point4.translate(dx, dy);
            point5.translate(dx, dy);
        }
    }
}

