package portfolio1;

import java.io.File;
import java.io.IOException;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XMLTree extends JTree {
    private static final long serialVersionUID = 1L;

    private DefaultTreeModel model;

    public XMLTree(String fileName) {
        super();
        loadTreeFromFile(fileName);
        model = (DefaultTreeModel) this.getModel();
        this.setShowsRootHandles(true);
        this.setEditable(true);
        this.setRootVisible(true);
    }

    public void loadTreeFromFile(String fileName) {
        SAXParser parser;
        try {
            parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(new File(fileName), new XMLTreeHandler(this));
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    public void addChildElement(DefaultMutableTreeNode parentNode, String name) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(name);
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
