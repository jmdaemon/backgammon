package ui.swing;

import javax.swing.*;
import java.awt.*;


import javax.swing.*;
import java.awt.*;

  public class DrawingTester implements jFrame {
    public static void main(String[] args) {
      int w = 1000;
      int h = 1000;

//        JFrame f = new JFrame();

      //homePage dc = new homePage(w,h);
      Board dc = new Board(w,h);
      f.setSize(w,h);
      f.setTitle("Backgammon by Decaffeinators");
      f.add(dc);

      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);

      ImageIcon image = new ImageIcon("Backgammon_Classic_Teaser.jpeg");
      f.setIconImage(image.getImage());
      f.getContentPane().setBackground(new Color(123, 129, 231));
    }
  }


