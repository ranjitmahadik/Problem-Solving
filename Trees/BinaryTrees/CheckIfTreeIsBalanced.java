package Trees.BinaryTrees;

public class CheckIfTreeIsBalanced {

    private static boolean isBalancedSolutionOne(TreeNode root) {
        if (root == null) return true;

        boolean isLeftBalanced = isBalancedSolutionOne(root.left);
        boolean isRightBalanced = isBalancedSolutionOne(root.right);

        if (!isLeftBalanced || !isRightBalanced) return false;

        // now check if current node is balanced ?
        int leftHeight = TreeOperations.getTreeHeight(root.left);
        int rightHeight = TreeOperations.getTreeHeight(root.right);

        int finalheight = Math.abs(leftHeight - rightHeight);
        return finalheight <= 1;
    }

    private static class Ans {
        int height;
        boolean isBalanced;

        public Ans(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

        @Override
        public String toString() {
            return "Ans{" +
                    "height=" + height +
                    ", isBalanced=" + isBalanced +
                    '}';
        }
    }

    private static Ans isBalancedSolutionTwo(TreeNode root) {
        if (root == null) return new Ans(0, true);

        Ans leftSubtree = isBalancedSolutionTwo(root.left);
        Ans rightSubtree = isBalancedSolutionTwo(root.right);

        // if any of subtree is not balanced then there is no point in figuring out whether current or above node are balanced or not, hence returned false.
        if (!leftSubtree.isBalanced || !rightSubtree.isBalanced) return new Ans(-1, false);

        int finalHeight = Math.abs(leftSubtree.height - rightSubtree.height);
        boolean isCurrentNodeBalanced = (finalHeight <= 1 && leftSubtree.isBalanced && rightSubtree.isBalanced);
        int currentNodeHeight = Math.max(leftSubtree.height, rightSubtree.height) + 1;

        return new Ans(currentNodeHeight, isCurrentNodeBalanced);
    }


    private static Ans isBalancedBST(TreeNode root) {
        if (root == null) return new Ans(-1, true);

        Ans leftAns = isBalancedBST(root.left);
        Ans rightAns = isBalancedBST(root.right);

        if (!leftAns.isBalanced || !rightAns.isBalanced) return new Ans(-1, false);

        int leftHeight = leftAns.height;
        int rightHeight = rightAns.height;

        int finalHeight = Math.abs(leftHeight - rightHeight);
        boolean isBalanced = (finalHeight <= 1);

        return new Ans(Math.max(leftHeight, rightHeight) + 1, isBalanced);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance();
        System.out.println("isBalanced ? : " + isBalancedSolutionTwo(root));
    }
}
