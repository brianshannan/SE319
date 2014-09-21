package portfolio1;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Writes the JTree back out to the file
 */
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

            List<DefaultMutableTreeNode> nonAttributes = new LinkedList<DefaultMutableTreeNode>();
            Enumeration<DefaultMutableTreeNode> children = node.children();
            while (children.hasMoreElements()) {
                DefaultMutableTreeNode child = children.nextElement();
                Object obj = child.getUserObject();

                // Write attributes first, defer elements and text until later;
                if(obj instanceof XMLAttribute) {
                    try {
                        writer.writeAttribute(((XMLAttribute) obj).getName(),
                                ((XMLAttribute) obj).getValue());
                    } catch (XMLStreamException e) {
                        e.printStackTrace();
                    }
                } else {
                    nonAttributes.add(child);
                }
            }

            for(DefaultMutableTreeNode nonAttribute : nonAttributes) {
                Object obj = nonAttribute.getUserObject();
                if(obj instanceof XMLElement) {
                    writeTree(nonAttribute);
                } else {
                    writer.writeCharacters(obj.toString());
                }
            }

            writer.writeEndElement();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
