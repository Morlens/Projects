package com.doms.javaprogramming;

import javax.swing.*;

public class AddTask {
    private DefaultListModel<TaskItem> taskListModel;

    public AddTask(DefaultListModel<TaskItem> taskListModel) {
        this.taskListModel = taskListModel;
    }

    public void showActionInformation() {
        String task = (String) JOptionPane.showInputDialog(
            null, 
            "Enter your task:", 
            "Add Task", 
            JOptionPane.PLAIN_MESSAGE,  // Removes question mark icon
            null, 
            null, 
            null
        );

        if (task == null) {
            return; // Exit if user clicks 'X'
        }
        if (!task.trim().isEmpty()) {
            taskListModel.addElement(new TaskItem(task)); // Store as TaskItem
        } else {
            JOptionPane.showMessageDialog(
                null, 
                "Task cannot be empty!", 
                "Error", 
                JOptionPane.PLAIN_MESSAGE  // No icon in error message
            );
        }
    }
}
