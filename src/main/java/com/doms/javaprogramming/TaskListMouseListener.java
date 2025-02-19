package com.doms.javaprogramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskListMouseListener extends MouseAdapter {
    private final JList<TaskItem> taskList;
    private final DefaultListModel<TaskItem> taskListModel;

    public TaskListMouseListener(JList<TaskItem> taskList, DefaultListModel<TaskItem> taskListModel) {
        this.taskList = taskList;
        this.taskListModel = taskListModel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int index = taskList.locationToIndex(e.getPoint());

        if (index != -1) {
            Rectangle bounds = taskList.getCellBounds(index, index);
            if (bounds != null && bounds.contains(e.getPoint())) {
                TaskItem item = taskListModel.get(index);
                item.setChecked(!item.isChecked());
                taskList.repaint(); // Refresh UI
            }
        }
    }
}
