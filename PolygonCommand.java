import java.awt.*;

public class PolygonCommand extends Command {
    private Polygon polygon;

    public PolygonCommand(Point point1, Point point2, Point point3, Point point4, Point point5) {
        this.polygon = new Polygon(point1, point2, point3, point4, point5);
    }

    public void execute() {
        model.addItem(polygon);
    }

    public boolean undo() {
        model.removeItem(polygon);
        return true;
    }

    public boolean redo() {
        execute();
        return true;
    }
}

