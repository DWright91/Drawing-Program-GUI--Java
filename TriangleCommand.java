import java.awt.*;

public class TriangleCommand extends Command {
    private Triangle triangle;

    public TriangleCommand(Point point1, Point point2, Point point3) {
        this.triangle = new Triangle(point1, point2, point3);
    }

    public void execute() {
        model.addItem(triangle);
    }

    public boolean undo() {
        model.removeItem(triangle);
        return true;
    }

    public boolean redo() {
        execute();
        return true;
    }
}
