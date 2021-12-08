package Trees.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class NextPointerPopulation {
    static class Node {
        int data;
        Node left, right, next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    private static Node getInstance() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(7);
        return root;
    }
    // 1 ,2 ,3 ,4 ,5

    private static void populateNextPointers() {
        Node root = getInstance();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int currentLevelSize = q.size();
            for (int i = 0; i < currentLevelSize; i++) {
                Node currentNode = q.poll();
                Node nextNode = null;

                if (i + 1 == currentLevelSize) nextNode = null;
                else nextNode = q.peek();

                currentNode.next = nextNode;

                if (currentNode.left != null) q.add(currentNode.left);
                if (currentNode.right != null) q.add(currentNode.right);
            }
        }
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node-i
    private static void populateNextPointersSpaceOptimized() {
        Node root = getInstance();

        Node startNode = root;
        while (startNode != null) {
            Node currentNode = startNode;
            while (currentNode != null) {
                if (currentNode.left != null) currentNode.left.next = currentNode.right;
                if (currentNode.right != null && currentNode.next != null)
                    currentNode.right.next = currentNode.next.left;

                currentNode = currentNode.next;
            }

            startNode = startNode.left;
        }
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii
    private static void populateNextPointers2SpaceOptimized(Node root) {
        Node startNode = root;
        while (startNode != null) {
            Node iteratorNode = startNode;
            while (iteratorNode != null) {

                iteratorNode = iteratorNode.next;
            }
        }
    }

    /***
     *                      1
     *                 2        3
     *             4     -   -       5
     *
     *
     */

    private static void mutate(TreeNode root, TreeNode parent, boolean isLeft) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        mutate(left, root, true);
        if (parent == null) {
            root.right = parent;
        } else if (isLeft) {
            root.right = parent.right;
        } else {
            if (parent.right != null) root.right = parent.right.left;
            else root.right = null;
        }
        mutate(right, root, false);
    }


    private static void populateNextPointersDFS(Node root, Node parent, boolean isLeft) {
        if (root == null) return;

        if (isLeft && parent != null) {
            root.next = parent.right;
        }
        populateNextPointersDFS(root.left, root, true);
        populateNextPointersDFS(root.right, root, false);
    }

    public static void main(String[] args) {
//        populateNextPointers();
    }
}
