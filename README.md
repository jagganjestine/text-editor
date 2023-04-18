# Simple Text Editor

## Summary
This project is a basic text editor created using Java and the Swing library. The application allows users to create, open, edit, and save text files. It provides a user-friendly interface with a simple menu to access these features.

## Features
The Simple Text Editor application includes the following features:

Create and edit text: The text editor provides a JTextArea where users can write and edit text as they would in any other text editor.

Open existing files: Users can open existing text files from their local file system by selecting the "Open" option in the "File" menu. The contents of the selected file will be displayed in the text area for editing.

Save files: Users can save the contents of the text area to a new or existing file by selecting the "Save" option in the "File" menu. A file dialog will appear, allowing users to choose the desired file location and name.

Exit the application: Users can close the application by selecting the "Exit" option in the "File" menu or by clicking the close button on the application window.

Implementation Details
The Simple Text Editor is built using Java and the Swing library for its graphical user interface. It extends the JFrame class and implements the ActionListener interface to handle user interactions.

The application's GUI consists of a JTextArea, a JScrollPane, a JMenuBar, a JMenu, and three JMenuItems (open, save, and exit). The JTextArea is used for text editing, while the JScrollPane provides scrolling functionality. The JMenuBar, JMenu, and JMenuItems create the menu structure that allows users to access the different features of the text editor.

The actionPerformed method handles the user's interaction with the menu items. Depending on the user's selection, it calls either the openFile, saveFile, or System.exit(0) method.

The openFile and saveFile methods utilize JFileChooser to display file dialogs that enable users to open and save files, respectively. These methods handle file input/output operations using the BufferedReader and BufferedWriter classes.

## Usage
To run the Simple Text Editor, ensure that you have a compatible Java Development Kit (JDK) installed and set up on your system. Compile the code using a Java IDE, such as Eclipse or IntelliJ IDEA, or use the command line to compile and run the application.

Enjoy using the Simple Text Editor to create and edit your text files!
