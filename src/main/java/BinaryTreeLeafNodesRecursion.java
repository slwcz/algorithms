/**
 * Counts the leaf nodes in a binary tree using recursion algorithm.<p />
 * A leaf node is a node whose left and right children are both null.<p />
 *
 * The time complexity of this algorithm is O(n) because you need to visit
 * all nodes of the binary tree to count a total number of leaf nodes.
 *
 * See http://javarevisited.blogspot.cz/2016/12/how-to-count-number-of-leaf-nodes-in-java-recursive-iterative-algorithm.html.
 *
 * @since 2016-10-25
 */
public class BinaryTreeLeafNodesRecursion {

    public static void main(String[] args) throws Exception {
        BinaryTree bt = new BinaryTree();
        bt.root = new TreeNode("a");
        bt.root.left = new TreeNode("b");
        bt.root.right = new TreeNode("f");
        bt.root.left.left = new TreeNode("c");
        bt.root.left.right = new TreeNode("e");
        bt.root.left.left.left = new TreeNode("d");
        bt.root.right.left = new TreeNode("g");
        bt.root.right.right = new TreeNode("h");
        bt.root.right.right.right = new TreeNode("k");

        System.out.println(bt.countLeafNodesRecursively());
    }

    static class TreeNode {

        String value;
        TreeNode left, right;

        TreeNode(String value) {
            this.value = value;
            left = right = null;
        }

        boolean isLeaf() {
            return left == null ? right == null : false;
        }
    }

    static class BinaryTree {

        TreeNode root;

        public int countLeafNodesRecursively() {
            return this.countLeaves(root);
        }

        private int countLeaves(TreeNode node) {
            if (node == null) {
                return 0;
            }

            if (node.isLeaf()) {
                return 1;
            } else {
                return countLeaves(node.left) + countLeaves(node.right);
            }
        }
    }
}
