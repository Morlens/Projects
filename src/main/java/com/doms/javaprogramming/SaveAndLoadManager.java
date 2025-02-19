package com.doms.javaprogramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

public class SaveAndLoadManager {
    public static void saveTasks(DefaultListModel<TaskItem> taskListModel){
         JFileChooser fileChooser = new JFileChooser();
         fileChooser.setDialogTitle("Save Task List");
         fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
         
         int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Ensure file has a .txt extension
            if (!fileToSave.getName().endsWith(".txt")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".txt");
            }
        
        try (BufferedWriter writer  = new BufferedWriter(new FileWriter(fileToSave))){
            for (int i = 0; i < taskListModel.size(); i++){
                TaskItem task = taskListModel.get(i);
                writer.write(task.isChecked() + ";" + task.getText());
                writer.newLine();
            }
            System.out.println("Task save succesfully");
            
        }catch (IOException e){
            System.out.println("Error Saving tasks: " + e.getMessage());
        }
    }
  }
    
    
    public static void loadTasks(DefaultListModel<TaskItem> taskListModel) {
    JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);

    if (returnValue == JFileChooser.APPROVE_OPTION) {
        String filename = fileChooser.getSelectedFile().getAbsolutePath();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            taskListModel.clear(); // Clear existing tasks
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";", 2); // Split by `;`
                boolean isChecked = Boolean.parseBoolean(parts[0]);
                String text = parts[1];

                TaskItem task = new TaskItem(text);
                task.setChecked(isChecked);
                taskListModel.addElement(task);
            }
            System.out.println("Tasks loaded successfully from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
  }
}