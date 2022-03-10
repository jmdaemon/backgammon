package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class Board extends JComponent{

    int width;
    int height;

    public Board(int w, int h){
        height = h;
        width = w;
    }

    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);

        //Background
        Rectangle2D.Double r = new Rectangle2D.Double(0,0,width,height);
        g2d.setColor(new Color(61, 72, 222));
        g2d.fill(r);

        //backgammon.Board
        Rectangle2D.Double pr = new Rectangle2D.Double(200,175,600,400);
        g2d.setColor(new Color(243, 154, 88));
        g2d.fill(pr);

        //Bar Line
        Line2D.Double l1 = new Line2D.Double(490,175, 490, 575);
        g2d.setColor(Color.BLACK);
        g2d.draw(l1);


        l1 = new Line2D.Double(510,175, 510, 575);
        g2d.setColor(Color.BLACK);
        g2d.draw(l1);

        //Points
        int xA = 200, yA = 175, yB = 325, row = 0;
        Color color1 = new Color(176, 227, 176);
        Color color2 = new Color(127, 224, 114);


        Color T1 = Color.BLACK;
        Color T2 = Color.WHITE;

        for(int i = 0; i < 24; i++){
            if(row%2 == 0){
                Point points = new Point(g2d, xA, yA, yB, color1);
                Palette chips = new Palette(xA, yA, T1, T2, g2d, i+1);
            }

            else if(row%2 != 0){
                Point points = new Point(g2d, xA, yA, yB, color2);
                Palette chips = new Palette(xA, yA, T1, T2, g2d, i+1);
            }

            xA += 50;
            row++;

            if(i == 5 || i == 17)
                xA = 510;
            else if(i == 11){
                xA = 200;
                yA = 575;
                yB = 425;
                row = 1;
            }
        }
    }
}
