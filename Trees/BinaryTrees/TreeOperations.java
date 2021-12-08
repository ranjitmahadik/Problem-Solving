package Trees.BinaryTrees;

import java.util.*;

public class TreeOperations {

    public static int getNodeCount(TreeNode root) {
        if (root == null) return 0;

        int left = getNodeCount(root.left);
        int right = getNodeCount(root.right);

        return left + right + 1;
    }

    public static int getSubOrdinates(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSubOrdinates(root.left);
        int right = getSubOrdinates(root.right);

        System.out.println(root.data + " : " + (left + right));

        return left + right + 1;
    }

    public static int getTreeHeight(TreeNode root) {
        if (root == null) return -1;

        int left = getTreeHeight(root.left);
        int right = getTreeHeight(root.right);

        return Math.max(left, right) + 1;
    }

    public static void preOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(TreeNode root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode + " ");
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }

    public static void iterativeTraversal(TreeNode root) {
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, 0));
        while (!s.isEmpty()) {
            Pair currentPair = s.peek();
            TreeNode currentNode = currentPair.root;
            int currentNodeState = currentPair.stateCount;
            s.pop();

            if (currentNode == null || currentNodeState == 3) continue;

            s.push(new Pair(currentNode, currentNodeState + 1));

            if (currentNodeState == 0) s.push(new Pair(currentNode.left, 0));
            else if (currentNodeState == 1) s.push(new Pair(currentNode.right, 0));
            else System.out.print(currentNode + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getInstance();
//        int nodeCount = getNodeCount(treeNode);
//        System.out.println("Total Number of Nodes in Tree : " + nodeCount);
//        getSubOrdinates(treeNode);
//        int treeHeight = getTreeHeight(treeNode);
//        System.out.println("TreeHeight : " + treeHeight);

//        preOrderTraversal(treeNode);
//        inOrderTraversal(treeNode);
//        postOrderTraversal(treeNode);
//        levelOrderTraversal(treeNode);
        iterativeTraversal(treeNode);
    }
}
