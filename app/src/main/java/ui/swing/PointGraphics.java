package ui.swing;

import java.awt.*;
import java.awt.geom.Path2D;

public class PointGraphics{

    PointGraphics(Graphics2D g, int xA, int yA, int yB, Color color){
        paintCar( g, xA, yA, yB, color);
    }
    void paintCar(Graphics2D g, int xA, int yA, int yB, Color color)
    {
        int xB = xA+20;
        int xC=xA+40;

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
}
