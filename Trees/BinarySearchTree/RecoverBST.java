package Trees.BinarySearchTree;

public class RecoverBST {

    private static TreeNode firstNode = null, secondNode = null, prevNode;

    private static void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        if (prevNode != null && prevNode.val > root.val) {
            if(firstNode == null)
                firstNode = prevNode;
            secondNode = root;
        }
        prevNode = root;
        inOrder(root.right);
    }
}
