package com.doms.javaprogramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menubar implements ActionListener {
    
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu editMenu;
    JMenu helpMenu;
    JMenuItem addItem;
    JMenuItem loadItem;
    JMenuItem saveItem;
    JMenuItem exitItem;
    ImageIcon addIcon;
    ImageIcon loadIcon;
    ImageIcon saveIcon;
    ImageIcon exitIcon;
    private DefaultListModel<TaskItem> taskListModel;

    public Menubar(DefaultListModel<TaskItem> taskListModel) {
        this.taskListModel = taskListModel;
    }

    
    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        
        
        addIcon = resizeIcon(new ImageIcon("src/resources/add-file.png"));
        loadIcon = resizeIcon(new ImageIcon("src/resources/folder.png"));
        saveIcon = resizeIcon(new ImageIcon("src/resources/diskette.png"));
        exitIcon = resizeIcon(new ImageIcon("src/resources/logout.png"));
        
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        helpMenu = new JMenu("Help");
        
        addItem = new JMenuItem("Add");
        loadItem = new JMenuItem("Load");
        saveItem = new JMenuItem("Save");
        exitItem = new JMenuItem("Exit");
        
        addItem.addActionListener(this);
        loadItem.addActionListener(this);
        saveItem.addActionListener(this);
        exitItem.addActionListener(this);
        
        // Set the icons after resizing
        addItem.setIcon(addIcon);
        loadItem.setIcon(loadIcon);
        saveItem.setIcon(saveIcon);
        exitItem.setIcon(exitIcon);
        
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt + f for file
        editMenu.setMnemonic(KeyEvent.VK_E); // Alt + e for edit
        helpMenu.setMnemonic(KeyEvent.VK_H); // Alt + h for help
        addItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        loadItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        
        fileMenu.add(addItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);
       
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        return menuBar;
    }
    
    // Method to resize icons to a fixed size
    private ImageIcon resizeIcon(ImageIcon icon) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addItem){
           AddTask addTask =  new AddTask(taskListModel);
           addTask.showActionInformation();
        }
        if (e.getSource() == loadItem) {
              SaveAndLoadManager.loadTasks(taskListModel);
            }
        if (e.getSource() == saveItem) {
            SaveAndLoadManager.saveTasks(taskListModel);

        }
        if (e.getSource() == exitItem) {
            new ExitWindow().windowClosing(null);
        }
    }
}
