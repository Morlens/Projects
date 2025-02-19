package com.doms.javaprogramming;

import javax.swing.*;
import java.awt.*;

class TaskRenderer extends JCheckBox implements ListCellRenderer<TaskItem> {
    public TaskRenderer() {
        setOpaque(false);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends TaskItem> list, TaskItem value, int index, boolean isSelected, boolean cellHasFocus) {
        setText(value.getText());
        setSelected(value.isChecked());

        // Handle selection highlighting
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        
        return this;
    }
}
