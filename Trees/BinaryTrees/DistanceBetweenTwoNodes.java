package Trees.BinaryTrees;

public class DistanceBetweenTwoNodes {
    private static TreeNode getLCA(TreeNode root, int l1, int l2) {
        if (root == null) return null;

        if (root.data == l1 || root.data == l2) return root;

        TreeNode left = getLCA(root.left, l1, l2);
        TreeNode right = getLCA(root.right, l1, l2);

        if (left != null && right != null)
            if ((left.data == l1 && right.data == l2) || (left.data == l2 && right.data == l1)) return root;
        return left != null ? left : right;
    }

    private static int findNodeFromLCA(TreeNode root, int target) {
        if (root == null) return -1;

        if (root.data == target) return 0;

        int left = findNodeFromLCA(root.left, target);
        int right = findNodeFromLCA(root.right, target);

        if (left != -1) return left + 1;
        if (right != -1) return right + 1;
        return left;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance2();
        TreeNode LCA = getLCA(root, 8, 11);
        int eightDistance = findNodeFromLCA(LCA, 8);
        int elevenDistance = findNodeFromLCA(LCA, 11);
        System.out.println("8 : " + eightDistance + "\n 11 : " + elevenDistance);
    }
}
