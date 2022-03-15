package ui.swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.*;

public class homePage extends JComponent implements  ActionListener {

    JFrame frame = new JFrame();
    JTextField header = new JTextField();
    JPanel titlePanel = new JPanel();
    JPanel introPanel = new JPanel();
    JPanel yourChoice = new JPanel();
    JLabel textField = new JLabel();
    JLabel introField = new JLabel();
    int width;
    int height;

    public homePage(int w, int h){
        width = w;
        height = h;

        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free", Font.BOLD,30));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Backgammon by Decaffeinators");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,1000,100);
        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);

        introField.setBackground(new Color(215, 174, 91));
        introField.setForeground(new Color(0, 38, 89));
        introField.setFont(new Font("Ink Free", Font.BOLD,15));
        introField.setText("MADE BY:-\nPriyank Ray ");

        introPanel.setLayout(new BorderLayout());
        introPanel.setBounds(0,100,1000,500);
        introPanel.add(introField);
        frame.add(introField,BorderLayout.CENTER);


        JButton button = new JButton("Play");
        button.setBounds(0,0,10,10);
        button.setBackground(Color.red);
        button.setHorizontalAlignment(JButton.LEFT);
        button.setOpaque(true);

        yourChoice.setLayout(new BorderLayout());
        yourChoice.setBounds(100,800,10,10);
        yourChoice.add(button);
        frame.add(yourChoice,BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
class RoundedBorder implements Border {

    private int radius;
    RoundedBorder(int radius) {
        this.radius = radius;
    }
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius, this.radius, this.radius, this.radius);
    }
    public boolean isBorderOpaque() {
        return true;
    }
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
