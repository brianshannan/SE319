package portfolio1;

import java.util.Stack;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class XMLTreeHandler extends DefaultHandler {

    private JTree tree;
    private Stack<DefaultMutableTreeNode> nodeStack;

    public XMLTreeHandler(JTree tree) {
        super();
        this.tree = tree;
        nodeStack = new Stack<DefaultMutableTreeNode>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(qName);
        // No current node so it must be the root, make a new model
        if(nodeStack.empty()) {
            tree.setModel(new DefaultTreeModel(newNode));
        } else {
            // Just add the node as a child to the current node
            nodeStack.peek().add(newNode);
        }

        for(int i = 0; i < attributes.getLength(); i++) {
            DefaultMutableTreeNode attributeNode = new DefaultMutableTreeNode('@'
                    + attributes.getQName(i) + '[' + attributes.getValue(i) + ']');
            newNode.add(attributeNode);
        }

        nodeStack.push(newNode);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        // Finished the element so go back to it's parent
        nodeStack.pop();
    }

    @Override
    public void characters(char ch[], int start, int length) {
        // Straight text, so add a node with the text
        String text = new String(ch, start, length);
        text = text.trim();
        if(text.isEmpty()) {
            return;
        }
        System.out.println(text);

        DefaultMutableTreeNode textNode = new DefaultMutableTreeNode(text);
        nodeStack.peek().add(textNode);
    }

}
