package portfolio1;

import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * Custom editor so the xml format is kept, doesn't lose focus right away, must
 * do that manually.
 */
public class XMLTreeCellEditor extends DefaultTreeCellEditor {

    public XMLTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer, getEditor());
    }

    @Override
    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected,
            boolean expanded, boolean leaf, int row) {

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getSelectionPath()
                .getLastPathComponent();
        Object content = node.getUserObject();
        if(content instanceof XMLAttribute) {
            String name = JOptionPane.showInputDialog("Enter attribute name");
            String val = JOptionPane.showInputDialog("Enter attribute value");
            ((XMLAttribute) content).setName(name);
            ((XMLAttribute) content).setValue(val);
        } else if(content instanceof XMLElement) {
            String name = JOptionPane.showInputDialog("Enter element name");
            ((XMLElement) content).setName(name);
        } else {
            String text = JOptionPane.showInputDialog("Enter text value");
            ((XMLTextNode) content).setValue(text);
        }

        node.setUserObject(content);
        return super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
    }

    public static DefaultCellEditor getEditor() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return new DefaultCellEditor(textField);
    }
}
