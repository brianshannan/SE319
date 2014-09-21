package portfolio1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.tree.DefaultMutableTreeNode;

public class XMLTreeFrame extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private XMLTree tree;
    private JScrollPane treePane;
    private String fileName;

    public XMLTreeFrame(String fileName) {
        this.fileName = fileName;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        JPanel buttonPanel = getButtonPanel();
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        tree = new XMLTree(fileName);
        treePane = new JScrollPane(tree);
        treePane.setPreferredSize(new Dimension(450, 200));
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

                tree.addAttribute(selected, attributeName, attributeValue);
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

        panel.add(addChildElement, BorderLayout.WEST);
        panel.add(addAttribute);
        panel.add(removeNode);
        return panel;
    }
}
