package Trees.BinaryTrees;


import util.Pair;

public class AllKindsOfDepths {

    private static int getDepth(TreeNode root, int depth) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left, depth + 1);
        int rightDepth = getDepth(root.right, depth + 1);

        return leftDepth + rightDepth + depth;
    }

    private static int getAllKindsOfDepthsBruteForce(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getAllKindsOfDepthsBruteForce(root.left);
        int rightDepth = getAllKindsOfDepthsBruteForce(root.right);

        int currentDepth = getDepth(root, 0);

        return leftDepth + rightDepth + currentDepth;
    }


    static int finalSum = 0;

    private static Pair<Integer, Integer> getAllKindsOfDepths(TreeNode root) {
        if (root == null)
            return new Pair<Integer, Integer>(0, 0);          //{Sum Of Node Depths In Subtree,No of Nodes}

        Pair<Integer, Integer> left = getAllKindsOfDepths(root.left);
        Pair<Integer, Integer> right = getAllKindsOfDepths(root.right);

        int noOfNodes = left.getSecond() + right.getSecond() + 1;

        int currentDepthSumLeft = left.getFirst() + left.getSecond();
        int currentDepthSumRight = right.getFirst() + right.getSecond();

        finalSum += currentDepthSumLeft + currentDepthSumRight;
        return new Pair<>(currentDepthSumLeft + currentDepthSumRight, noOfNodes);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance4();
        System.out.println("getDepth(root, 0) = " + getAllKindsOfDepthsBruteForce(root));

        System.out.println("getAllKindsOfDepthsBruteForce(root) = " + getAllKindsOfDepths(root).getFirst());
        System.out.println("finalSum = " + finalSum);

    }
}
