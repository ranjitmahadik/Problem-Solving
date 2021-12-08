package Trees.BinaryTrees;

public class MaxPathSum {

    /**
     *
     *
     *              int leftMaxSum = findMaxPath(root.left);
     *              int rightMaxSum = findMaxPath(root.right);
     *
     *              int temp = Math.max({max(leftMaxSum,rightMaxSum) + root.data, root.data});
     *              int tempTemp = Math.max(temp,leftMaxSum + rightMaxSum + root.data);
     *
     *              finalAns = Math.max(finalAns,tempTemp);
     *
     *              return temp;
     *
     *
     * */

    private static int finalSum = Integer.MIN_VALUE;

    private static int getMaxPathSum(TreeNode root) {
        if (root == null) return 0;

        int leftSum = Math.max(0, getMaxPathSum(root.left));
        int rightSum = Math.max(0, getMaxPathSum(root.right));

        finalSum = Math.max(finalSum, leftSum + rightSum + root.data);

        return Math.max(leftSum, rightSum) + root.data;
    }

    private static int getMaxSumPath(TreeNode root) {
        if (root == null) return 0;

        int leftSum = getMaxSumPath(root.left);
        int rightSum = getMaxSumPath(root.right);

        int temp = Math.max(Math.max(leftSum, rightSum) + root.data, root.data);
        int ans = Math.max(temp, leftSum + rightSum + root.data);

        finalSum = Math.max(ans, finalSum);

        return temp;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance();
        System.out.println("getMaxPathSum(root) = " + getMaxPathSum(root));
        System.out.println("finalSum = " + finalSum);
    }
}
