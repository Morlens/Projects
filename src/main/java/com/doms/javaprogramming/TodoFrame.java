package com.doms.javaprogramming;

import javax.swing.*;
import java.awt.*;

public class TodoFrame {

    JFrame frame;
    JLabel label;
    JPanel titlePanel;
    JMenuBar menu;
    Font myFont = new Font("Helvetica", Font.BOLD, 20);   
    
    JList<TaskItem> taskList;
    private DefaultListModel<TaskItem> taskListModel;

    public TodoFrame() {
        //Frame
        frame = new JFrame();
        frame.setTitle("Todo's");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 525);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        
        // Title Panel
        titlePanel = new JPanel();
        label = new JLabel("Desart's Todo List");
        label.setFont(myFont);
        titlePanel.setBounds(0, 20, 500, 50);
        titlePanel.add(label);
        frame.add(titlePanel);
        

        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setCellRenderer(new TaskRenderer()); // Use custom renderer

        // Attach the mouse listener from the new class
        taskList.addMouseListener(new TaskListMouseListener(taskList, taskListModel));
           
        // Add Menu Bar
        Menubar menubar = new Menubar(taskListModel);
        menu = menubar.createMenuBar();
        frame.setJMenuBar(menu);

     
        // Scroll Pane (To scroll through tasks)
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(50, 80, 400, 350);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        frame.add(scrollPane);

      
        frame.setVisible(true);
    }
}
