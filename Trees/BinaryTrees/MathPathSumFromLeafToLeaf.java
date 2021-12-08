package Trees.BinaryTrees;

public class MathPathSumFromLeafToLeaf {

    private static int finalAns = Integer.MIN_VALUE;

    private int getMaxPathSum(TreeNode root) {
        if (root == null) return 0;
        else if (root.left == null && null == root.right) return root.data;

        int l = getMaxPathSum(root.left);
        int r = getMaxPathSum(root.right);

        if (root.left != null && root.right != null) {
            finalAns = Math.max(finalAns, root.data + l + r);
            return Math.max(l, r) + root.data;
        }
        return root.left != null ? root.data + l : root.data + r;
    }

    private static boolean hasPath(TreeNode root, int targetSum) {
        if (root != null && root.left == null && root.right == null) return targetSum - root.data == 0;
        else if (root == null) return false;

        int newSum = targetSum - root.data;
        boolean isLeft = hasPath(root.left, newSum);
        boolean isRight = hasPath(root.right, newSum);

        return (isLeft || isRight);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println("hasPath(root,1) = " + hasPath(root, 1));
    }
}
