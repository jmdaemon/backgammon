import javax.swing.*;

public class DrawingTester {
    public static void main(String[] args) {
        int w = 1000;
        int h = 1000;
        JFrame f = new JFrame();
        f.setSize(w,h);
        f.setTitle("Backgammon by Decaffeinators");

        Board dc = new Board(w,h);
        f.add(dc);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
