package com.doms.javaprogramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TaskRenderer extends JPanel implements ListCellRenderer<TaskItem> {
    private JCheckBox checkBox;
    private JButton deleteButton;

    public TaskRenderer() {
        setLayout(new BorderLayout());

        checkBox = new JCheckBox();
        deleteButton = new JButton("X");

        deleteButton.setMargin(new Insets(2, 8, 2, 8)); 
        deleteButton.setForeground(Color.RED);
        deleteButton.setFocusable(false);

        // 🛑 Stop the JList from processing the delete button click
        deleteButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                e.consume();  // Prevents the event from propagating
            }
        });

        add(checkBox, BorderLayout.WEST);
        add(deleteButton, BorderLayout.EAST);
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends TaskItem> list, TaskItem value, int index, boolean isSelected, boolean cellHasFocus) {
        
        checkBox.setText(value.getText());
        checkBox.setSelected(value.isChecked());

        return this;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
