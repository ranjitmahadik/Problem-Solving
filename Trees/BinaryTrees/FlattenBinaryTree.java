package Trees.BinaryTrees;

import util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class FlattenBinaryTree {


    private static void FlattenBinaryTreeInOrder(TreeNode root) {
        List<Integer> elementList = new ArrayList<>();
        flattenBinaryTreeHelper(root, elementList);
        TreeNode tempNode = new TreeNode(elementList.get(0)), rootNode;
        rootNode = tempNode;
        for (int i = 1; i < elementList.size(); i++) {
            tempNode.right = new TreeNode(elementList.get(i));
            tempNode = tempNode.right;
        }
    }

    private static void flattenBinaryTreeHelper(TreeNode root, List<Integer> elementList) {
        if (root == null) return;
        flattenBinaryTreeHelper(root.left, elementList);
        elementList.add(root.data);
        flattenBinaryTreeHelper(root.right, elementList);
    }

    private static TreeNode secondaryRoot, primaryRoot;
    private static void flattenTree(TreeNode root) {
        if (root == null) return;

        flattenTree(root.left);
        if (secondaryRoot == null) {
            secondaryRoot = root;
            primaryRoot = root;
        } else {
            secondaryRoot.left = null;
            secondaryRoot.right = root;
            secondaryRoot = secondaryRoot.right;
        }
        flattenTree(root.right);
    }

    //  ----------------------PreOrder-------------------------------------
    private static TreeNode tempNode = new TreeNode(0);
    private static TreeNode ansNode = tempNode;

    private static void flattenTreePreOrder(TreeNode root) {
        if (root == null) return;
        tempNode.right = new TreeNode(root.data);
        tempNode.left = null;
        tempNode = tempNode.right;
        flattenTreePreOrder(root.left);
        flattenTreePreOrder(root.right);
    }

    private static void flattenTreePreOrderOptimal(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (secondaryRoot == null) {
            secondaryRoot = root;
            primaryRoot = root;
        } else {
            secondaryRoot.right = root;
            secondaryRoot.left = null;
            secondaryRoot = secondaryRoot.right;
        }
        flattenTreePreOrderOptimal(left);
        flattenTreePreOrderOptimal(right);
    }

    // ----------------PostOrder---------------------

    /**
     * flattenTreePostOrder(root);
     * root.left = null;
     * root.right = null;
     * <p>
     * remember during postOrder lastly visited node is root node and it has left and right childs
     * hence it's important to change them to null to get solution accepted.
     */
    private static void flattenTreePostOrder(TreeNode root) {
        if (root == null) return;


        flattenTreePostOrder(root.left);
        flattenTreePostOrder(root.right);

        if (secondaryRoot == null) {
            secondaryRoot = root;
            primaryRoot = root;
            secondaryRoot.left = null;
        } else {
            secondaryRoot.right = root;
            secondaryRoot.left = null;
            secondaryRoot = secondaryRoot.right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance4();
//        flattenTreePreOrder(root);
//        ansNode = ansNode.right;
//        while (ansNode != null) {
//            System.out.print(ansNode.data + " " + ((ansNode.left != null) ? "NOTNULL" : ""));
//            ansNode = ansNode.right;
//        }

        flattenTreePostOrder(root);
        root.left = null;
        root.right = null;
        while (primaryRoot != null) {
            System.out.print(primaryRoot.data + " ");
            primaryRoot = primaryRoot.right;
        }
    }
}
