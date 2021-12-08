package Trees.BinaryTrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserialize {

    private static String serialize(TreeNode root) {
        if (root == null) return "X";

        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        return root.data + "," + leftSerialized + "," + rightSerialized;
    }

    private static TreeNode deserialize(String serializedVersion) {
        Queue<String> serializedTree = new LinkedList<>();
        serializedTree.addAll(Arrays.asList(serializedVersion.split(",")));
        return deserializeHelper(serializedTree);
    }

    private static TreeNode deserializeHelper(Queue<String> serializedTree) {
        if(serializedTree.isEmpty())    return null;
        String currentVal = serializedTree.poll();
        if (currentVal.equals("X")) return null;

        int rootVal = Integer.valueOf(currentVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = deserializeHelper(serializedTree);
        root.right = deserializeHelper(serializedTree);

        return root;
    }

    private static void printPreorder(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair currentNodeState = stack.pop();
            if (currentNodeState == null || currentNodeState.root == null || currentNodeState.stateCount >= 3) continue;

            TreeNode currentNode = currentNodeState.root;
            int nodeState = currentNodeState.stateCount;

            stack.push(new Pair(currentNode, nodeState + 1));

            if (nodeState == 0) System.out.print(currentNode + " ");
            else if (nodeState == 1) stack.push(new Pair(currentNode.left, 0));
            else stack.push(new Pair(currentNode.right, 0));
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance();
        String serializedVersion = serialize(root);
        System.out.println("Serialized Version : " + serializedVersion);

        TreeNode deserializedRoot = deserialize(serializedVersion);
        printPreorder(deserializedRoot);
    }
}
