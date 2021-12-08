package Trees.BinaryTrees;

import util.Pair;

import java.util.Stack;

public class FindSuccessor {
    private static int successor = -1, tempSuccessor;

    private static void inOrderTraversal(TreeNode root, int node) {
        if (root == null) return;

        inOrderTraversal(root.left, node);
        if (tempSuccessor == node) successor = root.data;
        tempSuccessor = root.data;
        inOrderTraversal(root.right, node);
    }

    private static int findSuccessor(TreeNode root, int node) {
        if (root == null) return -1;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.add(new Pair<>(root, 0));

        int successor = -1, tempSuccessor = -1;

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek().getFirst();
            int processState = stack.peek().getSecond();
            stack.pop();

            if (currentNode == null || processState == 3) continue;

            stack.add(new Pair<>(currentNode, processState + 1));

            if (processState == 0 && currentNode.left != null) stack.add(new Pair<>(currentNode.left, 0));
            else if (processState == 1) {
                if (tempSuccessor == node) successor = currentNode.data;
                tempSuccessor = currentNode.data;
            } else if (processState == 2 && currentNode.right != null) stack.add(new Pair<>(currentNode.right, 0));
        }
        return successor;
    }


    static class Node {
        public Node left;
        public Node right;
        public Node parent;
        public int val;

        public Node(int val) {
            this.val = val;
        }

        public static Node getInstance() {
            Node root = new Node(1);
            root.left = new Node(2);
            root.left.parent = root;

            root.right = new Node(3);
            root.right.parent = root;

            root.left.left = new Node(4);
            root.left.left.parent = root.left;

            root.left.right = new Node(5);
            root.left.right.parent = root.left;

            root.left.left.left = new Node(6);
            root.left.left.left.parent = root.left.left;

            return root;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }


    private static void getSuccessor(Node root) {
        if (root.right != null) System.out.println("Successor is : " + getLeftMostNode(root.right));
        else System.out.println("Successor is : " + getCorrectParent(root));
    }

    private static Node getCorrectParent(Node root) {
        while (root.parent != null && root.parent.right == root) root = root.parent;
        return root.parent;
    }

    private static Node getLeftMostNode(Node root) {
        while (root.left != null) root = root.left;
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = TreeNode.getInstance4();
//        int node = 1;
//        inOrderTraversal(root, node);
//        System.out.println("successor is = " + successor);
//        System.out.println("findSuccessor(root, " + node + ") = " + findSuccessor(root, node));
//

        Node root1 = Node.getInstance();
        getSuccessor(root1.right);
    }

}
