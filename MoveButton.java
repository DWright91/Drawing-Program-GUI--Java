import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MoveButton extends JButton implements ActionListener {
    protected JPanel drawingPanel;
    protected View view;
    private MouseHandler mouseHandler;
    private UndoManager undoManager;

    public MoveButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
        super("Move");
        this.undoManager = undoManager;
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
        mouseHandler = new MouseHandler();
    }

    public void actionPerformed(ActionEvent event) {
        view.setCursor(new Cursor(Cursor.MOVE_CURSOR)); // Change cursor when button is clicked
        drawingPanel.addMouseListener(mouseHandler); // Start listening for mouse clicks on the drawing panel
    }

    private class MouseHandler extends MouseAdapter {
        private Point initialPoint;

        public void mousePressed(MouseEvent event) {
            initialPoint = event.getPoint();
        }

        public void mouseReleased(MouseEvent event) {
            Point finalPoint = event.getPoint();
            int dx = finalPoint.x - initialPoint.x;
            int dy = finalPoint.y - initialPoint.y;

            if (dx != 0 || dy != 0) {
                MoveCommand moveCommand = new MoveCommand(dx, dy);
                undoManager.beginCommand(moveCommand);
                moveCommand.execute();
                undoManager.endCommand(moveCommand);
            }

            initialPoint = null;
            drawingPanel.removeMouseListener(this);
            view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }
}