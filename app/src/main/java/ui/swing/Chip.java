package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;

public class Chip extends JComponent implements jFrame{

    int[] storingChips = {0, -2, 0, 0, 0, 0, 5, 0, 3, 0, 0, 0, -5, 5, 0, 0, 0, -3, 0, -5, 0, 0, 0, 0, 2};
    JButton[] chip = new JButton[30];
    Color Palette1, Palette2;
    private JLabel label;

    public Chip(int xA, int yA, Color C1, Color C2, Graphics2D g, int i) {
//        super();
//        chip[i].addMouseListener(new java.awt.event.MouseAdapter()
//        {
//            public void mousePressed(java.awt.event.MouseEvent evt)
//            {
//                System.out.println("Clicker ME");
//            }
//        });
//        enableInputMethods(true);
//        addMouseListener((MouseListener) this);
        setColor(C1, C2);
        callPG(g, xA, yA, C1, i);
    }


    int h = 0;

    public void callPG(Graphics2D g, int xA, int yA, Color color, int i){
        if (storingChips[i] > 0) {
            for (int j = 0; j < storingChips[i]; j++) {
                if (i < 13) {
                    yA -= h = 25;
                }
                else{
                    yA += h = 25;
                }
                setChips(g, xA, yA, h, Palette2, i);
            }
        }
        if(storingChips[i] < 0){
            for (int j = 0; j > storingChips[(i)]; j--) {
                if (i < 13)
                    yA -= h = 25;
                else {
                    yA += h = 25;
                }
                setChips(g, xA, yA, h, Palette1, i);
            }
        }
    }

    public void setColor(Color color1, Color color2) {
        Palette1 = color1;
        Palette2 = color2;
    }

    public class ClickListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event) {
            label.setText("I was clicked."); }

    }

    public void setChips(Graphics2D g, int xA, int yA, int h, Color color, int i) {
        Ellipse2D.Double paletteT1 = new Ellipse2D.Double(xA, yA, 50, h);

        g.setColor(color);
        g.fill(paletteT1);
    }
}
