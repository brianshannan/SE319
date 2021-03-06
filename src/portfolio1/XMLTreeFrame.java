package portfolio1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;

/**
 * Controller for representing an xml file as a JTree
 */
public class XMLTreeFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private XMLTree tree;
    private JScrollPane treePane;

    public XMLTreeFrame(File file) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 300);

        JPanel buttonPanel = getButtonPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        tree = new XMLTree(file);
        tree.setShowsRootHandles(true);
        tree.setEditable(true);
        tree.setRootVisible(true);
        tree.setDragEnabled(true);
        tree.setDropMode(DropMode.ON_OR_INSERT);
        // Only allow one thing to be selected at once... Simplifies drag and
        // drop
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // Control editting
        tree.setCellEditor(new XMLTreeCellEditor(tree, (DefaultTreeCellRenderer) tree
                .getCellRenderer()));
        // Enable drag and drop
        tree.setTransferHandler(new XMLTreeTransferHandler());

        treePane = new JScrollPane(tree);
        treePane.setPreferredSize(new Dimension(700, 220));
        getContentPane().add(treePane, BorderLayout.NORTH);
    }

    private JPanel getButtonPanel() {
        JPanel panel = new JPanel();
        JButton addChildElement = new JButton("Add Child Element");
        addChildElement.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                // Identify the node that has been selected
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();

                if(selected == null) {
                    return;
                }

                String elementName = JOptionPane
                        .showInputDialog("Please enter the name for the element");
                if(elementName == null) {
                    return;
                }

                tree.addChildElement(selected, elementName);
            }
        });

        JButton addAttribute = new JButton("Add Attribute");
        addAttribute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Identify the node that has been selected
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();

                if(selected == null) {
                    return;
                }

                String attributeName = JOptionPane
                        .showInputDialog("Please enter the name for the attribute");

                String attributeValue = JOptionPane
                        .showInputDialog("Please enter the value for the attribute");
                if(attributeName == null || attributeValue == null) {
                    return;
                }

                tree.addAttribute(selected, attributeName, attributeValue);
            }
        });

        JButton addText = new JButton("Add Text");
        addText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Identify the node that has been selected
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();

                if(selected == null) {
                    return;
                }

                String value = JOptionPane
                        .showInputDialog("Please enter the name for the text node");
                if(value == null) {
                    return;
                }

                tree.addTextNode(selected, value);
            }
        });

        JButton removeNode = new JButton("Remove Node");
        removeNode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Identify the node that has been selected
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode) tree
                        .getLastSelectedPathComponent();

                // Don't allow removal of the root node
                if(selected == null || selected.getParent() == null) {
                    return;
                }

                tree.removeNode(selected);
            }
        });

        JButton saveFile = new JButton("Save To File");
        saveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                tree.writeTreeToFile();
            }
        });

        panel.add(addChildElement, BorderLayout.WEST);
        panel.add(addAttribute);
        panel.add(addText);
        panel.add(removeNode);
        panel.add(saveFile);
        return panel;
    }
}
