package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ClickListener implements ActionListener{



        @Override
        public void actionPerformed(ActionEvent event) {
            JLabel label = new JLabel();
            label.setText("I was clicked."); }

    }

