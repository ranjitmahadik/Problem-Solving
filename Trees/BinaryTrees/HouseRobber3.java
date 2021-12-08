package Trees.BinaryTrees;

import util.Pair;

//337. House Robber III
public class HouseRobber3 {

    // bruteforce solution
    private static int rob(TreeNode root, boolean isParentSelected) {
        if (root == null) return 0;

        int incl = 0, excl = 0;
        if (!isParentSelected)
            incl = root.data + rob(root.left, true) + rob(root.right, true);
        excl = rob(root.left, false) + rob(root.right, false);

        return Math.max(incl, excl);
    }

    private static Pair<Integer, Integer> rob(TreeNode root) {
        if (root == null) return new Pair<>(0, 0);

        Pair<Integer, Integer> left = rob(root.left);
        Pair<Integer, Integer> right = rob(root.right);

        /**
         * ans.first = withRoot;
         * ans.second = without Root;
         * */
        Pair<Integer, Integer> ans = new Pair<>();
        ans.setFirst(root.data + left.getSecond() + right.getSecond());
        ans.setSecond(Math.max(left.getFirst(), left.getSecond()) + Math.max(right.getFirst(), right.getSecond()));
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
    }
}
