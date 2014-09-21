package portfolio1;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class XMLTreeWriter {

    private XMLStreamWriter writer;

    public XMLTreeWriter(XMLStreamWriter writer) {
        this.writer = writer;
    }

    public void writeTree(XMLTree tree) {
        try {
            writer.writeStartDocument();
            writeTree((DefaultMutableTreeNode) tree.getModel().getRoot());
            writer.writeEndDocument();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void writeTree(DefaultMutableTreeNode node) {
        try {
            writer.writeStartElement(node.getUserObject().toString());

            List<DefaultMutableTreeNode> elements = new LinkedList<DefaultMutableTreeNode>();
            Enumeration<DefaultMutableTreeNode> children = node.children();
            while (children.hasMoreElements()) {
                DefaultMutableTreeNode child = children.nextElement();

                if(child.isLeaf()) {
                    writeLeaf(child.getUserObject().toString());
                } else {
                    // Attributes must be written before child elements
                    elements.add(child);
                }
            }

            for(DefaultMutableTreeNode element : elements) {
                writeTree(element);
            }

            writer.writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private void writeLeaf(String text) {
        if(text.startsWith("@")) {
            // It's an attribute
            try {
                int bracketIndex = text.indexOf('[');
                String name = text.substring(1, bracketIndex);
                String value = text.substring(bracketIndex + 1, text.length() - 1);
                writer.writeAttribute(name, value);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        } else {
            // It's just text
            try {
                writer.writeCharacters(text);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
    }
}
