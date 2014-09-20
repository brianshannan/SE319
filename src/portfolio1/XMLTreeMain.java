package portfolio1;

import java.awt.EventQueue;

public class XMLTreeMain {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    XMLTreeFrame frame = new XMLTreeFrame("testXML.xml");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
