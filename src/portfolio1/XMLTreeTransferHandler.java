package portfolio1;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JTree;
import javax.swing.TransferHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * Enables drag and drop behavior in the JTree
 */
public class XMLTreeTransferHandler extends TransferHandler {
    private static final long serialVersionUID = 1L;
    private DataFlavor flavor;
    private DefaultMutableTreeNode[] nodesToRemove;

    public XMLTreeTransferHandler() {
        try {
            String mimeType = DataFlavor.javaJVMLocalObjectMimeType + ";class=\""
                    + javax.swing.tree.DefaultMutableTreeNode[].class.getName() + "\"";
            flavor = new DataFlavor(mimeType);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound: " + e.getMessage());
        }
    }

    @Override
    public boolean canImport(TransferHandler.TransferSupport support) {
        JTree tree = (JTree) support.getComponent();

        // Don't allow moving the root element
        if(tree.getSelectionPath().getPathCount() == 1) {
            return false;
        }

        // Don't allow moving something to be a child of an attribute
        JTree.DropLocation dropLocation = (JTree.DropLocation) support.getDropLocation();
        DefaultMutableTreeNode destination = (DefaultMutableTreeNode) dropLocation.getPath()
                .getLastPathComponent();
        if(!destination.getAllowsChildren()) {
            return false;
        }

        return true;
    }

    @Override
    public boolean importData(TransferHandler.TransferSupport support) {
        DefaultMutableTreeNode node = null;
        Transferable transferable = support.getTransferable();
        try {
            node = (DefaultMutableTreeNode) transferable.getTransferData(this.flavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }

        JTree.DropLocation dropLocation = (JTree.DropLocation) support.getDropLocation();
        TreePath destinationPath = dropLocation.getPath();
        DefaultMutableTreeNode destinationParent = (DefaultMutableTreeNode) destinationPath
                .getLastPathComponent();
        DefaultTreeModel model = (DefaultTreeModel) ((JTree) support.getComponent()).getModel();
        model.removeNodeFromParent(node);
        int childIndex = dropLocation.getChildIndex() == -1 ? destinationParent.getChildCount()
                : dropLocation.getChildIndex();
        model.insertNodeInto(node, destinationParent, childIndex);
        return true;
    }

    @Override
    protected Transferable createTransferable(JComponent component) {
        JTree tree = (JTree) component;
        TreePath[] paths = tree.getSelectionPaths();
        return new XMLTreeTransferable((DefaultMutableTreeNode) paths[0].getLastPathComponent());

    }

    @Override
    public int getSourceActions(JComponent component) {
        return COPY_OR_MOVE;
    }

    public class XMLTreeTransferable implements Transferable {
        DefaultMutableTreeNode node;

        public XMLTreeTransferable(DefaultMutableTreeNode node) {
            this.node = node;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[] { flavor };
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return XMLTreeTransferHandler.this.flavor.equals(flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException,
                IOException {
            return node;
        }

    }

}
