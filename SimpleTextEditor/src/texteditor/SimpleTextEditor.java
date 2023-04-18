package texteditor;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

// SimpleTextEditor class extends JFrame and implements the ActionListener interface
public class SimpleTextEditor extends JFrame implements ActionListener {
    // Declare GUI components
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menu;
    JMenuItem open, save, exit;

    // Constructor for SimpleTextEditor
    public SimpleTextEditor() {
        // Initialize GUI components
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        menuBar = new JMenuBar();
        menu = new JMenu("File");
        open = new JMenuItem("Open");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        // Register action listeners for menu items
        open.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);

        // Add menu items to menu and menu to menu bar
        menu.add(open);
        menu.add(save);
        menu.addSeparator();
        menu.add(exit);
        menuBar.add(menu);

        // Set menu bar and add scroll pane to the frame
        setJMenuBar(menuBar);
        add(scrollPane);

        // Set frame properties
        setTitle("Simple Text Editor");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Main method
    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            SimpleTextEditor editor = new SimpleTextEditor();
            editor.setVisible(true);
        });
    }

    // Handle action events from menu items
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            openFile();
        } else if (e.getSource() == save) {
            saveFile();
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    // Method to open a file and display its content in the text area
    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                textArea.read(reader, null);
                reader.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to save the content of the text area to a file
    private void saveFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                textArea.write(writer);
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
