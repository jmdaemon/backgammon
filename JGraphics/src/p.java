import java.awt.Color;
import javax.swing.*;

class PianoComponent extends JPanel {

    PianoComponent() {

        setLayout(null);

        for (int i = 0; i < 20; i++) {
            JButton key = new JButton();
            key.setBackground(Color.WHITE);
            key.setLocation(i * 20, 0);
            key.setSize(20, 120);
            add(key);
            setComponentZOrder(key, i);
        }

        for (int i = 0; i < 20; i++) {
            int j = i % 7;
            if (j == 2 || j == 6)
                continue;

            JButton key = new JButton();
            key.setBackground(Color.BLACK);
            key.setLocation(i * 20 + 12, 0);
            key.setSize(16, 80);
            add(key);
            setComponentZOrder(key, 0);
        }
    }
}

public class p {
    public static void main(String[] args) {
        JFrame jf = new JFrame("Piano!");
        jf.setSize(400, 200);
        jf.add(new PianoComponent());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}