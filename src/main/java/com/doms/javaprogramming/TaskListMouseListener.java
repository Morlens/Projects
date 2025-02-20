package com.doms.javaprogramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

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

    // 🛑 Ignore clicks outside valid task rows
    if (index == -1) return;

    Rectangle bounds = taskList.getCellBounds(index, index);
    if (bounds == null || !bounds.contains(e.getPoint())) {
        return; // Ignore clicks outside row bounds
    }

    TaskRenderer renderer = (TaskRenderer) taskList.getCellRenderer()
            .getListCellRendererComponent(taskList, taskListModel.get(index), index, false, false);

    JButton deleteButton = renderer.getDeleteButton();

    if (deleteButton.getBounds().contains(e.getPoint())) {
        taskListModel.remove(index);
        return; // Stop further event handling
    }

    // Toggle checkbox only if delete button wasn't clicked
    TaskItem item = taskListModel.get(index);
    item.setChecked(!item.isChecked());
    taskList.repaint(); // Refresh UI
    }
}