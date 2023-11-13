/**
 * TreeNode represents a node in a binary tree.
 *
 * @param <T> the type of data stored in the node
 */
public class TreeNode<T> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    /**
     * Constructs a new TreeNode with the specified data.
     *
     * @param dataNode the data to be stored in the node
     */
    public TreeNode(T dataNode) {
        this.data = dataNode;
    }

    /**
     * Constructs a new TreeNode by copying the values from an existing node.
     *
     * @param node the node to be copied
     */
    public TreeNode(TreeNode<T> node) {
        this.data = node.getData();
        // Ensure left and right are also copied
        if (node.getLeft() != null) {
            this.left = new TreeNode<>(node.getLeft());
        }
        if (node.getRight() != null) {
            this.right = new TreeNode<>(node.getRight());
        }
    }

    /**
     * Sets the data of the node.
     *
     * @param x the new data to be set
     */
    public void setData(T x) {
        this.data = x;
    }

    /**
     * Gets the data stored in the node.
     *
     * @return the data of the node
     */
    public T getData() {
        return this.data;
    }

    /**
     * Sets the left child of the node.
     *
     * @param x the new left child node
     */
    public void setLeft(TreeNode<T> x) {
        this.left = x;
    }

    /**
     * Gets the left child of the node.
     *
     * @return the left child of the node
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Sets the right child of the node.
     *
     * @param x the new right child node
     */
    public void setRight(TreeNode<T> x) {
        this.right = x;
    }

    /**
     * Gets the right child of the node.
     *
     * @return the right child of the node
     */
    public TreeNode<T> getRight() {
        return right;
    }
}
