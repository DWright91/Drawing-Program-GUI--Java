import java.util.Enumeration;

public class MoveCommand extends Command {
    private int dx;
    private int dy;

    public MoveCommand(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void execute() {
        // Move all selected items by dx and dy
        Enumeration enumeration = model.getSelectedItems();
        while (enumeration.hasMoreElements()) {
            Item item = (Item) enumeration.nextElement();
            item.translate(dx, dy);
        }
    }

    public boolean undo() {
        // Undo the move by translating items in the opposite direction
        Enumeration enumeration = model.getSelectedItems();
        while (enumeration.hasMoreElements()) {
            Item item = (Item) enumeration.nextElement();
            item.translate(-dx, -dy);
        }
        return true;
    }

    public boolean redo() {
        // Redo the move by reapplying the translation
        execute();
        return true;
    }
}