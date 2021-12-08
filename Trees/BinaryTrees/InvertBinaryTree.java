package Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    private static TreeNode invertBinaryTree(TreeNode root) {
        if (root == null) return null;

        TreeNode leftSubTree = invertBinaryTree(root.left);
        TreeNode rightSubTree = invertBinaryTree(root.right);

        root.left = rightSubTree;
        root.right = leftSubTree;

        return root;
    }

    private static TreeNode invertBinaryTreeBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            TreeNode leftSubTree = currentNode.left;
            TreeNode rightSubTree = currentNode.right;

            currentNode.left = rightSubTree;
            currentNode.right = leftSubTree;

            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);

        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance4();
        TreeOperations.levelOrderTraversal(root);
        System.out.println("");
        TreeNode invertedTree = invertBinaryTree(root);
        TreeOperations.levelOrderTraversal(invertedTree);
        System.out.println("");
        TreeOperations.levelOrderTraversal(invertBinaryTreeBFS(TreeNode.getInstance4()));
    }
}
