import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FunctionFile {
    GUI gui;
    String FileName=null , FileAddress=null;
    public FunctionFile(GUI gui) {
        this.gui=gui;
    }
    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        FileName=null;
        FileAddress=null; // save as for the first time   , save for a file that already exist
    }
public void open() {
    FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
    fd.setVisible(true);

    if (fd.getFile() != null) {
        FileAddress = fd.getDirectory() + fd.getFile();  // Set the file path
        FileName = fd.getFile();
        gui.window.setTitle(FileName);
    }
    try {
        BufferedReader br = new BufferedReader(new FileReader(FileAddress));
        gui.textArea.setText("");
        String line;
        while ((line = br.readLine()) != null) {
            gui.textArea.append(line + "\n");
        }
        br.close();
    } catch (Exception e) {
        System.out.println("No file has been selected or file cannot be opened.");
    }
    System.out.println("FileName after open: " + FileName);
    System.out.println("FileAddress after open: " + FileAddress);
}


    public void save() {
        System.out.println("FileName before save: " + FileName);
        System.out.println("FileAddress before save: " + FileAddress);

        if (FileAddress == null || FileName == null) {
            SavaAS();
        } else {
            try {
                FileWriter fw = new FileWriter(FileAddress);
                fw.write(gui.textArea.getText());
                fw.close();
                System.out.println("Saved successfully to: " + FileAddress);
            } catch (Exception e) {
                System.out.println("Failed to save the file: " + e.getMessage());
            }
        }
    }

    public void SavaAS() {
        FileDialog fd = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        fd.setVisible(true);  // Display the dialog


        if (fd.getFile() != null) {

            FileAddress = fd.getDirectory() + fd.getFile();
            FileName = fd.getFile();
            gui.window.setTitle(fd.getFile());

            System.out.println("FileAddress after SaveAS: " + FileAddress);
            System.out.println("FileName after SaveAS: " + FileName);

            try {
                FileWriter fw = new FileWriter(FileAddress);
                fw.write(gui.textArea.getText());
                fw.close();
                System.out.println("File saved successfully at: " + FileAddress);
            } catch (Exception e) {
                System.out.println("File save failed: " + e.getMessage());
            }
        }
    }

    public void Exit(){
        System.exit(0);
}
}
