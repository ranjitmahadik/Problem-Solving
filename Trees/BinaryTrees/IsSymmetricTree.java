package Trees.BinaryTrees;

public class IsSymmetricTree {

    private static boolean isSymmetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if ((root1 == null && root2 != null) || (root2 == null && root1 != null) || root1.data != root2.data)
            return false;

        boolean isLeft = isSymmetric(root1.left, root2.right);
        boolean isRight = isSymmetric(root1.right, root2.left);

        return isLeft && isRight;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance3();
        System.out.println("isSymmetric(root,root) = " + isSymmetric(root, root));
    }
}
