import java.util.Stack;

/**
 * A binary search tree is a binary tree where the value of a left child is less than or equal
 * to the parent node and value of the right child is greater than or equal to the parent node.
 * <p/>
 * Since its a binary tree, it can only have 0, 1 or two children.
 * <p/>
 * See http://javarevisited.blogspot.cz/2015/10/how-to-implement-binary-search-tree-in-java-example.html.
 *
 * @since 2016-12-26
 */
public class BinarySearchTree {

    private static class Node {
        private int data;
        private Node left, right;

        public Node(int value) {
            data = value;
            left = right = null;
        }
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return this.root;
    }

    public boolean isEmpty() {
        return null == root;
    }

    public int size() {
        Node current = root;
        int size = 0;
        Stack<Node> stack = new Stack<Node>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                size++;
                current = stack.pop();
                current = current.right;
            }
        }
        return size;
    }

    public void clear() {
        root = null;
    }
}
