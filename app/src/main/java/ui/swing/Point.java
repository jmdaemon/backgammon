package ui.swing;

import javax.swing.JPanel;
import java.awt.*;

public class Point extends JPanel{

    public Point(Graphics2D g, int xA, int yA, int yB, Color color){
        PointGraphics one = new PointGraphics(g, xA, yA, yB, color);
    }
}
