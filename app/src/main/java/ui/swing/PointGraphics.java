package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class PointGraphics{

  PointGraphics(Graphics2D g, int xA, int yA, int yB, Color color){
    paintTriangle( g, xA, yA, yB, color);
  }
  PointGraphics(Graphics2D g2d, int from, int dieReading){
    highlightTriangle(g2d, from, dieReading);
  }

  void paintTriangle(Graphics2D g, int xA, int yA, int yB, Color color)
  {
    int xB = xA+25;
    int xC=xA+50;

    g.setStroke(new BasicStroke(1.0f));
    g.setColor(Color.BLACK);

    // Build the triangle
    Path2D.Double path = new Path2D.Double();
    path.moveTo(xA,yA);
    path.lineTo(xB,yB);
    path.lineTo(xC, yA);
    path.closePath();

    // Draw the triangle
    g.draw(path);

    // Fill the triangle, with a different color
    g.setColor(color);
    g.fill(path);
  }

  public void highlightTriangle(Graphics2D g2d, int from, int dieReading){
    if(from > 12){
      int xA = 0, yA = 0, yB = 200;
      for(int i = 13; i < 25; i++){
        if(from == i)
          paintTriangle(g2d, xA, yA, yB, Color.YELLOW);
        xA += 60;
        if(i == 18)
          xA = 400;
      }
    }
    else if(from < 12){
      int xA = 0, yA = 500, yB = 300;
    }
  }
}

