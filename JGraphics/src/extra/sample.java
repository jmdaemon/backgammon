package extra;/*

import javax.swing.*;

public class sample {
    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        JButton button = new JButton("Click me!");
//        JLabel label = new JLabel("Hello, World!");
//        JPanel panel = new JPanel();
//        panel.add(button);
//        panel.add(label);
//        frame.add(panel);
//        final int FRAME_WIDTH = 300;
//        final int FRAME_HEIGHT = 100;
//        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
//        frame.setTitle("A frame with two components");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true); }

        JFrame frame = new JFrame();
        JButton button = new JButton("Click Me");
        JLabel label = new JLabel("Sample");
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        frame.add(panel);

        final int F_W = 300;
        final int F_H = 100;

        frame.setSize(F_W, F_H);
        frame.setTitle("A frame with two components.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class sample {
    public static void main(String[] args) {
        JFrame frame = new FilledFrame();
        frame.setTitle("A frame with two components");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class FilledFrame extends JFrame {
    // Use instance variables for components private JButton button;
    private JLabel label;
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 100;

    public FilledFrame() {
        // Now we can use a helper method
        createComponents();
        // It is a good idea to set the size in the frame constructor
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createComponents() {
        JButton button = new JButton("Click me!");
        label = new JLabel("Hello, World!");
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        add(panel);

        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
    }
}

class ClickListener1 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("I was clicked.");
    }

}
class ButtonFrame2 extends JFrame {

    private JButton button;

    private JLabel label;


    private static final int FRAME_WIDTH = 300;

    private static final int FRAME_HEIGHT = 100;


    public ButtonFrame2() {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }


     * An action listener that changes the label text.

    class ClickListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            label.setText("I was clicked.");
        }
    }

    private void createComponents() {
        button = new JButton("Click me!");
        ActionListener listener = new ClickListener();
        button.addActionListener(listener);
        label = new JLabel("Hello, World!");
        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);
        add(panel);
    }


}

 * A frame that shows the growth of an investment with variable interest.

 class InvestmentFrame2 extends JFrame {
    private static final int FRAME_WIDTH = 450;
    private static final int FRAME_HEIGHT = 100;

    private static final double DEFAULT_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private JLabel resultLabel;
    private double balance;
    private JPanel panel;

    public InvestmentFrame2() {

        balance = INITIAL_BALANCE;
        resultLabel = new JLabel("Balance: " + balance);
        createTextField();
        createButton();
        createPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField() {
        rateLabel = new JLabel("Interest Rate: ");
        final int FIELD_WIDTH = 10;
        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText("" + DEFAULT_RATE);
    }

    /**
     * Adds interest to the balance and updates the display.

    class AddInterestListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double rate = Double.parseDouble(rateField.getText());
            double interest = balance * rate / 100;
            balance = balance + interest;
            resultLabel.setText("Balance: " + balance);
        }
    }

    private void createButton() {
        button = new JButton("Add Interest");
        ActionListener listener = new AddInterestListener();
        button.addActionListener(listener);
    }

    private void createPanel() {
        panel = new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(button);
        panel.add(resultLabel);
        add(panel);
    }
}
class InvestmentFrame3 extends JFrame {
    private static final int FRAME_WIDTH = 400;
    private static final int FRAME_HEIGHT = 250;

    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;

    private static final double DEFAULT_RATE = 5;
    private static final double INITIAL_BALANCE = 1000;

    private JLabel rateLabel;
    private JTextField rateField;
    private JButton button;
    private JTextArea resultArea;
    private JPanel panel;
    private double balance;

    public InvestmentFrame3() {
        balance = INITIAL_BALANCE;
        resultArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
                resultArea.setText(balance + "\n"); resultArea.setEditable(false);

        createTextField();
        createButton();
        createPanel();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    private void createTextField() {
        rateLabel = new JLabel("Interest Rate: ");
        final int FIELD_WIDTH = 10;
        rateField = new JTextField(FIELD_WIDTH);
        rateField.setText("" + DEFAULT_RATE);
    }

    class AddInterestListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            double rate = Double.parseDouble(rateField.getText());
            double interest = balance * rate / 100;
            balance = balance + interest;
            resultArea.append(balance + "\n");
        }
    }


    private void createButton() {
        button = new JButton("Add Interest");
        ActionListener listener = new AddInterestListener();
        button.addActionListener(listener);
    }

    private void createPanel() {
        panel = new JPanel();
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(button);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        panel.add(scrollPane);
        add(panel);
    }
}
*/


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class sample {
    public static void main(String[] args) {

            JFrame frame = new JFrame();
            frame.setSize(400, 200);
            frame.setTitle("A bar chart"); frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JComponent component = new ChartComponent();
            frame.add(component);
            frame.setVisible(true); }

}

 class ChartComponent extends JComponent {


    public void paintComponent(Graphics g) {
        g.fillRect(0, 10, 200, 10);
        g.fillRect(0, 30, 300, 10);
        g.fillRect(0, 50, 100, 10);
    }

}

