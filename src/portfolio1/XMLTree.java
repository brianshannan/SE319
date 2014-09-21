package portfolio1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.SAXException;

public class XMLTree extends JTree {
    private static final long serialVersionUID = 1L;

    private String fileName;
    private DefaultTreeModel model;
    private SAXParserFactory saxParserFactory;
    private XMLOutputFactory xmlOutputFactory;

    public XMLTree(String fileName) {
        super();
        this.fileName = fileName;
        saxParserFactory = SAXParserFactory.newInstance();
        xmlOutputFactory = XMLOutputFactory.newInstance();
        loadTreeFromFile();
        model = (DefaultTreeModel) this.getModel();
    }

    public void loadTreeFromFile() {
        SAXParser parser;
        try {
            parser = saxParserFactory.newSAXParser();
            parser.parse(new File(fileName), new XMLTreeReader(this));
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public void writeTreeToFile() {
        XMLStreamWriter writer;
        try {
            writer = xmlOutputFactory
                    .createXMLStreamWriter(new FileOutputStream(new File(fileName)));
            XMLTreeWriter treeWriter = new XMLTreeWriter(writer);
            treeWriter.writeTree(this);
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    public void addChildElement(DefaultMutableTreeNode parentNode, String name) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(new XMLElement(name));
        model.insertNodeInto(node, parentNode, parentNode.getChildCount());
    }

    public void addAttribute(DefaultMutableTreeNode parentNode, String name, String value) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode('@' + name + '[' + value + ']');
        model.insertNodeInto(node, parentNode, parentNode.getChildCount());
    }

    public void removeNode(DefaultMutableTreeNode node) {
        model.removeNodeFromParent(node);
    }
}
