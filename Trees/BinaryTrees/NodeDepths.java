package Trees.BinaryTrees;

import util.Pair;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NodeDepths {
    private static int finalAns = 0;

    private static void getNodeDepths(TreeNode root, int depth) {
        if (root == null) return;
        finalAns += depth;
        getNodeDepths(root.left, depth + 1);
        getNodeDepths(root.right, depth + 1);
    }

    private static int getNodeDepthsRecursive(TreeNode root, int depth) {
        if (root == null) return 0;

        int leftChildDepth = getNodeDepthsRecursive(root.left, depth + 1);
        int rightChildDepth = getNodeDepthsRecursive(root.right, depth + 1);

        return depth + leftChildDepth + rightChildDepth;
    }

    private static int findNodeDepthsBFS(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        int finalSum = 0;
        while (!q.isEmpty()) {
            TreeNode currentNode = q.peek().getFirst();
            int currentNodeDepth = q.peek().getSecond();
            q.poll();

            finalSum += currentNodeDepth;

            if (currentNode.left != null) q.add(new Pair<>(currentNode.left, currentNodeDepth + 1));
            if (currentNode.right != null) q.add(new Pair<>(currentNode.right, currentNodeDepth + 1));
        }
        return finalSum;
    }

    private static int findNodeDepthsStack(TreeNode root) {
        if (root == null) return 0;

        Stack<Pair<TreeNode, Integer>> s = new Stack<>();
        s.push(new Pair<>(root, 0));
        int sumOfDepths = 0;
        while (!s.isEmpty()) {
            TreeNode currentNode = s.peek().getFirst();
            int currentNodeDepth = s.peek().getSecond();
            s.pop();

            sumOfDepths += currentNodeDepth;

            if (currentNode.left != null) s.push(new Pair<>(currentNode.left, currentNodeDepth + 1));
            if (currentNode.right != null) s.push(new Pair<>(currentNode.right, currentNodeDepth + 1));
        }
        return sumOfDepths;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance();
        getNodeDepths(root, 0);
        System.out.println("Sum = " + finalAns);
        System.out.println("getNodeDepthsRecursive(root,0) = " + getNodeDepthsRecursive(root, 0));
        System.out.println("findNodeDepthsBFS(root) = " + findNodeDepthsBFS(root));
        System.out.println("findNodeDepthsStack(root) = " + findNodeDepthsStack(root));
    }
}
