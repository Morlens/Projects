package com.doms.javaprogramming;

import javax.swing.*;
import java.awt.event.*;

public class ExitWindow extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        JLabel message = new JLabel("Are you sure you want to exit?", SwingConstants.CENTER);
        int confirm = JOptionPane.showConfirmDialog(
            null,   
            message,
            "Exit Confirmation",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE
        );

        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0); // Close the app
        }
    }
}


