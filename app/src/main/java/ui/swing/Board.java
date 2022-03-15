package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

public class Board extends JComponent implements jFrame{

  JPanel board = new JPanel();
  JButton[] triangles = new JButton[24];
  int width;
  int height;

  public Board(int w, int h){
    height = h;
    width = w;
    this.setLayout(null);
  }

  protected void paintComponent(Graphics g){
    Graphics2D g2d = (Graphics2D) g;

    RenderingHints rh = new RenderingHints(
      RenderingHints.KEY_ANTIALIASING,
      RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setRenderingHints(rh);



    //backgammon.Board
    board.setBounds(0,0,800,500);
    board.setBackground(new Color(243, 154, 88));
    f.add(board);

        /*
        //Button
        for(int i = 0;i<24;i++){
            triangles[i] = new JButton("i");
        }
        triangles[0].setBounds(200,175,40,325);
        f.add(triangles[0]);
        */

    //Bar Line
    Path2D.Double l1 = new Path2D.Double();
    l1.moveTo(355,0);
    l1.lineTo(355,500);
    l1.lineTo(395,500);
    l1.lineTo(395,0);
    l1.closePath();
    g2d.setColor(Color.BLACK);
    g2d.draw(l1);

    //Blot
    l1.moveTo(750,0);
    l1.lineTo(750,500);
    l1.lineTo(800,500);
    l1.lineTo(800,0);
    l1.closePath();
    g2d.draw(l1);

    Color color1 = new Color(176, 227, 176);
    Color color2 = new Color(127, 224, 114);

    Color T1 = Color.BLACK;
    Color T2 = Color.WHITE;


    int xA = 0, yA = 0, yB = 200, row = 0;

    for(int i = 13; i < 25; i++){
      if(i == 24) {
        //If white selects 24th point for die = 3;
        PointGraphics suggest = new PointGraphics(g2d, 24, 3);
      }
      else {
        if (row % 2 == 0) {
          Point points = new Point(g2d, xA, yA, yB, color1);
        } else if (row % 2 != 0) {
          Point points = new Point(g2d, xA, yA, yB, color2);
        }
      }
      Chip chip = new Chip(xA, yA, T1, T2, g2d, i);
      xA += 60;
      row++;
      if(i == 18)
        xA = 400;
    }

    xA = 0; yA = 500; yB = 300; row = 0;
    for(int i = 12; i > 0; i--){
      if(i == 24) {
        //If white selects 24th point for die = 3;
        PointGraphics suggest = new PointGraphics(g2d, 24, 3);
      }
      else {
        if (row % 2 == 0) {
          Point points = new Point(g2d, xA, yA, yB, color1);
        } else if (row % 2 != 0) {
          Point points = new Point(g2d, xA, yA, yB, color2);
        }
      }
      Chip chip = new Chip(xA, yA, T1, T2, g2d, i);
      xA += 60;
      row++;
      if(i == 7)
        xA = 400;
    }
  }
}
