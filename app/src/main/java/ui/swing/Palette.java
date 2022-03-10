package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

public class Palette extends JButton implements jFrame{
    int[] storingChips = {0, 5, 0, 0, 0, -3, 0, -5, 0, 0, 0, 0, 2, -5, 0, 0, 0, 3, 0, 5, 0, 0, 0, 0, -2};
    Color Palette1, Palette2;
    private JLabel label;

    public Palette(int xA, int yA, Color C1, Color C2, Graphics2D g, int i) {
        setColor(C1, C2);
        callPG(g, xA, yA, C1, i);
    }

    int h = 0;

    public void callPG(Graphics2D g, int xA, int yA, Color color, int i){
        if (storingChips[i] > 0) {
            for (int j = 0; j < storingChips[i]; j++) {
                if (i < 13)
                    yA += h = 20;
                else{
                    yA -= h = 20;
                }
                setPalette(g, xA, yA, h, Palette2);
            }
        }
        if(storingChips[i] < 0){
            for (int j = 0; j > storingChips[i]; j--) {
                if (i < 13)
                    yA += h = 20;
                else{
                    yA -= h = 20;
                }
                setPalette(g, xA, yA, h, Palette1);
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
    public void setPalette(Graphics2D g, int xA, int yA, int h, Color color) {
        Ellipse2D.Double paletteT1 = new Ellipse2D.Double(xA, yA, 40, h);
        JButton b=new JButton();
        ActionListener listener = new ClickListener();
        b.addActionListener(listener);
        b.setBounds(xA,yA,40,h);
        JPanel p1 = new JPanel();
        p1.add(b);
        //b.setBackground(color);
        add(p1);
        g.setColor(color);
        g.fill(paletteT1);
    }
}
