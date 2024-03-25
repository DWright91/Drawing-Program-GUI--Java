import java.awt.*;

public interface UIContext {
  //  public abstract void drawCircle(Circle circle);
  public abstract void drawLine(Point point1, Point point2 );
  public abstract void drawLabel(String s, Point p);
  
  ///////////////////////////////////////////////////////////////////////////////////
  void drawTriangle(Point point1, Point point2, Point point3);
  public abstract void drawPolygon(Point point1, Point point2, Point point3, Point point4, Point point5);


}
