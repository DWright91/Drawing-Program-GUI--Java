import java.awt.*;
public class NewSwingUI implements UIContext {
  private Graphics graphics;
  private static NewSwingUI swingUI;
  private NewSwingUI() {
  }
  public static NewSwingUI getInstance() {
    if (swingUI == null) {
      swingUI = new NewSwingUI();
    }
    return swingUI;
  }
  public  void setGraphics(Graphics graphics) {
    this.graphics = graphics;
  }
  public void drawLabel(String s, Point p) {
    if (p != null) {
      if (s != null) {
        graphics.drawString(s, (int) p.getX(), (int) p.getY());
      }
    }
    int length = graphics.getFontMetrics().stringWidth(s);
    graphics.drawString("_", (int)p.getX() + length, (int)p.getY());
  }
  public void drawLine(Point point1,  Point point2) {
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    if (point1 != null) {
      i1 = Math.round((float) (point1.getX())); // X1.
      i2 = Math.round((float) (point1.getY())); // Y1.
      if (point2 != null) {
        i3 = Math.round((float) (point2.getX())); // X2.
        i4 = Math.round((float) (point2.getY())); // Y2.
      } else {
        i3 = i1;
        i4 = i2;
      }
      graphics.drawLine(i1, i2, i3, i4);
    }
  }
 
  //////////////////////////////////////////////////////////////////////////////
  @Override
  public void drawTriangle(Point point1, Point point2, Point point3) {
      int x1 = (int) point1.getX();
      int y1 = (int) point1.getY();
      int x2 = (int) point2.getX();
      int y2 = (int) point2.getY();
      int x3 = (int) point3.getX();
      int y3 = (int) point3.getY();

      // Use graphics object to draw a triangle using the provided points
      graphics.drawLine(x1, y1, x2, y2);
      graphics.drawLine(x2, y2, x3, y3);
      graphics.drawLine(x3, y3, x1, y1);
  }
  @Override
  public void drawPolygon(Point point1, Point point2, Point point3, Point point4, Point point5) {
	  int x1 = (int) point1.getX();
      int y1 = (int) point1.getY();
      int x2 = (int) point2.getX();
      int y2 = (int) point2.getY();
      int x3 = (int) point3.getX();
      int y3 = (int) point3.getY();
      int x4 = (int) point4.getX();
      int y4 = (int) point4.getY();
      int x5 = (int) point5.getX();
      int y5 = (int) point5.getY();

      // Use graphics object to draw a polygon using the provided points
      graphics.drawLine(x1, y1, x2, y2);
      graphics.drawLine(x2, y2, x3, y3);
      graphics.drawLine(x3, y3, x4, y4);
      graphics.drawLine(x4, y4, x5, y5);
      graphics.drawLine(x5, y5, x1, y1);
  }
}
