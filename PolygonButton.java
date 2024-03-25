import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class PolygonButton extends JButton implements ActionListener {
    private JPanel drawingPanel;
    private View view;
    private MouseHandler mouseHandler;
    private PolygonCommand polygonCommand;
    private UndoManager undoManager;

    public PolygonButton(UndoManager undoManager, View jFrame, JPanel jPanel) {
        super("Polygon");
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
        private Point[] points = new Point[5];

        public void mouseClicked(MouseEvent event) {
            if (pointCount < 5) {
                points[pointCount] = View.mapPoint(event.getPoint());
                pointCount++;
            }

            if (pointCount == 5) {
                polygonCommand = new PolygonCommand(points[0], points[1], points[2], points[3], points[4]);
                undoManager.beginCommand(polygonCommand);
                pointCount = 0;
                drawingPanel.removeMouseListener(this);
                view.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                undoManager.endCommand(polygonCommand);
            }
        }
    }
}
