import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TriangleButton extends JButton implements ActionListener {
    private JPanel drawingPanel;
    private View view;
    private MouseHandler mouseHandler;
    private TriangleCommand triangleCommand;
    private UndoManager undoManager;

    public TriangleButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
        super("Triangle");
        this.undoManager = undoManager;
        addActionListener(this);
        view = jFrame;
        drawingPanel = jPanel;
        mouseHandler = new MouseHandler();
    }

    public void actionPerformed(ActionEvent event) {
        view.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        drawingPanel.addMouseListener(mouseHandler);
    }

    private class MouseHandler extends MouseAdapter {
        private int pointCount = 0;
        private Point[] points = new Point[3];

        public void mouseClicked(MouseEvent event) {
            if (pointCount < 3) {
                points[pointCount] = View.mapPoint(event.getPoint());
                pointCount++;
            }

            if (pointCount == 3) {
                triangleCommand = new TriangleCommand(points[0], points[1], points[2]);
                undoManager.beginCommand(triangleCommand);
                pointCount = 0;
                drawingPanel.removeMouseListener(this);
                view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                undoManager.endCommand(triangleCommand);
            }
        }
    }
}
