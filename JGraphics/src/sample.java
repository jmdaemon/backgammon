/*
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.geom.*;

public class sample extends JFrame {

    private JFrame f;
    private JPanel p;
    private JButton b1;
    private JLabel lab;

    public static void main(String[] args) {
        new sample();
    }

    public sample() {


        f = new JFrame("Simon Says");
        f.setVisible(true);
        f.setSize(500, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p = new JPanel();
        p.setBackground(Color.GRAY);

        b1 = new JButton("Click Here to Begin!");

        p.add(b1);
        f.add(p);
        f.setLocationRelativeTo(null);


        f.add(new DrawStuff(), BorderLayout.CENTER);

    }

    public class DrawStuff extends JComponent {

        public void paint(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;
            Graphics2D g3 = (Graphics2D) g;
            Graphics2D g4 = (Graphics2D) g;
            Graphics2D g5 = (Graphics2D) g;

            // assume d == 145 && e == 90

            g2.setPaint(Color.GREEN);
            g2.fill(new Arc2D.Double(150, 150, 200, 200, 145, 90, Arc2D.PIE));

            g3.setPaint(Color.BLUE);
            g3.fill(new Arc2D.Double(150, 150, 200, 200, 235, 90, Arc2D.PIE));

            g4.setPaint(Color.RED);
            g4.fill(new Arc2D.Double(150, 150, 200, 200, 325, 90, Arc2D.PIE));

            g5.setPaint(Color.YELLOW);
            g5.fill(new Arc2D.Double(150, 150, 200, 200, 55, 90, Arc2D.PIE));

            f.revalidate();
        }

    }

}*/
//import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*class fedListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Ouch! That hurt's.");
    }*/

    public class sample {
        //Button draw;
        public static JButton b = new JButton("button");

        public static void main(String[] a) {
//            JButton button = new JButton("CLICK");
//          /*  ActionListener fed = new ActionListener(){
//                @Override
//                        public void actionPerformed(ActionEvent e){
//                    System.out.println("OUCH!!!");
//                }
//            };*/
//            button.addActionListener((ActionEvent e)->{
//                    System.out.println("OUCH!!!");
//
//            });
            Button btn = new Button("Say 'Hello World'");

// circular shape scaled to Button dimensions = ellipse
           // btn.setShape(new Circle(1));

// increase distance from edges to text
           // btn.setPadding(new Insets(8));

        }
    }

/*
        JFrame f = new JFrame();

        f.setTitle("Drawing Graphics in Frames");
        f.setSize(800, 650);
        f.setLocation(200,50);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //f.add(b);

        f.setContentPane( new ContentComponent());
        //f.getContentPane.add(b);

        f.setVisible(true);
    }
    static class ContentComponent extends JComponent {
        public int activa = 1;
        // add(b);
        //this.add(b);
        public void paint(Graphics g) {


            g.setColor (Color.RED);
            g.fillRect(0, 0, 800, 650);
            if( activa == 1){

                g.setColor(Color.BLACK);
                g.drawRect(40, 20, 150, 80);
                int x = 40;
                int y= 20;
                for(int i = 0; i< 4; i++){

                    g.drawRect(x+10, y+10, 150, 80);
                    x = x+10;
                    y = y+10;
                }

            }

            // g.fillRect(20, 10, 100, 60);
            // g.drawRect(40, 20, 150, 80);
        }*/
//  }
//}