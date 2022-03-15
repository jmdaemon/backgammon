package extra;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonFrame1 extends JFrame {

    public class MyGraphics extends JComponent {

        private static final long serialVersionUID = 1L;

        MyGraphics() {
            setPreferredSize(new Dimension(500, 100));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.fillRect(200, 62, 30, 10);
        }
    }

    private static final int FRAME_WIDTH = 100;
    private static final int FRAME_HEIGHT = 60;

    public ButtonFrame1() {
        //createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    private void createComponents(Graphics g) {
        JButton button = new JButton("Click me!");
        JPanel panel = new JPanel();
        panel.add(button);
        add(panel);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.RED);
        ActionListener listener = new ClickListener();
        button.addActionListener(listener); }
}