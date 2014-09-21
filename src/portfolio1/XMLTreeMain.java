package portfolio1;

import java.awt.EventQueue;
import java.io.File;

import javax.swing.JOptionPane;

/**
 * Main class to represent an xml file as a JTree and do basic editing. The file
 * you wish to represent is obtained through a dialog box.
 */
public class XMLTreeMain {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    String fileName = JOptionPane.showInputDialog("Please enter the file");
                    File file = new File(fileName);
                    if(!file.exists()) {
                        System.out.println("File doesn't exist, exiting");
                        return;
                    }
                    XMLTreeFrame frame = new XMLTreeFrame(file);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
