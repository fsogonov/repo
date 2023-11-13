import java.util.ArrayList;

/**
 * MorseCodeTree is a class that represents a binary tree used for converting Morse code to English.
 * It relies on a root (reference to the root of the tree).
 *
 * The root is set to null when the tree is empty.
 *
 * The class uses an external generic TreeNode class which consists of a reference to the data and a
 * reference to the left and right child. The TreeNode is parameterized as a String, TreeNode. This
 * class uses a private member root (reference to a TreeNode).
 *
 * The constructor will call the buildTree method.
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    TreeNode<String> root = new TreeNode<>("");

    /**
     * Default constructor for MorseCodeTree. Calls the buildTree method to construct the Morse Code tree.
     */
    public MorseCodeTree() {
        buildTree();
    }

    /**
     * Returns a reference to the root of the MorseCodeTree.
     *
     * @return reference to the root
     */
    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * Sets the root of the MorseCodeTree.
     *
     * @param newNode a newNode that will be the root of MorseCodeTree
     */
    @Override
    public void setRoot(TreeNode<String> newNode) {
        root = newNode;
    }

    /**
     * Adds an element to the correct position in the tree based on the Morse code.
     * This method will call the recursive method addNode.
     *
     * @param code   the code for the new node to be added, e.g., ".-."
     * @param letter the data of the new TreeNode to be added
     */
    @Override
    public void insert(String code, String letter) {
        addNode(this.root, code, letter);
    }

    /**
     * Recursive method that adds an element to the correct position in the tree based on the Morse code.
     *
     * @param root   the root of the tree for this particular recursive instance of addNode
     * @param code   the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() > 0) {
            if (code.startsWith(".")) {
                if (root.getLeft() == null) {
                    root.setLeft(new TreeNode<>(""));
                }
                addNode(root.getLeft(), code.substring(1), letter);
            } else if (code.startsWith("-")) {
                if (root.getRight() == null) {
                    root.setRight(new TreeNode<>(""));
                }
                addNode(root.getRight(), code.substring(1), letter);
            }
        }
        if (code.length() == 0) root.setData(letter);
    }

    /**
     * Fetches the data in the tree based on the Morse code. This method will call the recursive method fetchNode.
     *
     * @param code the code that describes the traversals to retrieve the string (letter)
     * @return the string (letter) that corresponds to the code
     */
    @Override
    public String fetch(String code) {
        return fetchNode(this.root, code);
    }

    /**
     * Recursive method that fetches the data of the TreeNode that corresponds with the code.
     *
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of addNode
     * @return the string (letter) corresponding to the code
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if (code.length() > 0) {
            if (code.startsWith(".")) {
                return fetchNode(root.getLeft(), code.substring(1));
            } else if (code.startsWith("-")) {
                return fetchNode(root.getRight(), code.substring(1));
            }
        }
        return root.getData();
    }

    /**
     * Operation not supported in the MorseCodeTree.
     *
     * @param data data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException since deleting nodes is not supported
     */
    @Override
    public MorseCodeTree delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Deleting nodes is not supported in MorseCodeTree");
    }

    /**
     * Operation not supported in the MorseCodeTree.
     *
     * @return reference to the current tree
     * @throws UnsupportedOperationException since updating is not supported
     */
    @Override
    public MorseCodeTree update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Updating nodes is not supported in MorseCodeTree");
    }

    /**
     * Builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code.
     * The root will have a value of "" (empty string).
     * Level one: insert(".", "e"); insert("-", "t");
     * Level two: insert("..", "i"); insert(".-", "a"); insert("-.", "n"); insert("--", "m");
     * etc. Look at the tree and the table of codes to letters in the assignment description.
     */
    @Override
    public void buildTree() {
        // Insert Morse code mappings for each letter
        insert(".-", "a");
        insert("-...", "b");
        insert("-.-.", "c");
        insert("-..", "d");
        insert(".", "e");
        insert("..-.", "f");
        insert("--.", "g");
        insert("....", "h");
        insert("..", "i");
        insert(".---", "j");
        insert("-.-", "k");
        insert(".-..", "l");
        insert("--", "m");
        insert("-.", "n");
        insert("---", "o");
        insert(".--.", "p");
        insert("--.-", "q");
        insert(".-.", "r");
        insert("...", "s");
        insert("-", "t");
        insert("..-", "u");
        insert("...-", "v");
        insert(".--", "w");
        insert("-..-", "x");
        insert("-.--", "y");
        insert("--..", "z");
    }

    /**
     * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order.
     * Used for testing to make sure the tree is built correctly.
     *
     * @return an ArrayList of the items in the linked Tree
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> a = new ArrayList<>();
        LNRoutputTraversal(root, a);
        return a;
    }

    /**
     * Recursive method to put the contents of the tree in an ArrayList in LNR (Inorder).
     *
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root.getLeft() != null) {
            LNRoutputTraversal(root.getLeft(), list);
        }
        list.add(root.getData());
        if (root.getRight() != null) {
            LNRoutputTraversal(root.getRight(), list);
        }
    }
}
