package Trees.BinaryTrees;

public class TreeDiameter {


    private static int treeDiameterSolutionOne(TreeNode root) {
        if (root == null) return 0;

        int leftDiameter = treeDiameterSolutionOne(root.left);
        int rightDiameter = treeDiameterSolutionOne(root.right);

        int leftSubtreeHeight = TreeOperations.getTreeHeight(root.left);
        int rightSubtreeHeight = TreeOperations.getTreeHeight(root.right);


        return Math.max(leftDiameter, Math.max(rightDiameter, leftSubtreeHeight + rightSubtreeHeight + 2));
    }

    private static int finalDiameter = Integer.MIN_VALUE;

    private static int treeDiameterSolutionTwo(TreeNode root) {
        if (root == null) return 0;

        int left = treeDiameterSolutionTwo(root.left);
        int right = treeDiameterSolutionTwo(root.right);

        finalDiameter = Math.max(finalDiameter, left + right);

        return Math.max(left, right) + 1;
    }

    static class Ans {
        int height;
        int diameter;

        public Ans(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    private static Ans treeDiameterSolutionThree(TreeNode root) {
        if (root == null) return new Ans(-1, 0);

        Ans leftDiameter = treeDiameterSolutionThree(root.left);
        Ans rightDiamter = treeDiameterSolutionThree(root.right);

        // calculate for current root node based on it's children's.
        int currentNodeDiameter = leftDiameter.height + rightDiamter.height + 2;
        int currentNodeHeight = Math.max(leftDiameter.height, rightDiamter.height) + 1;
        Ans currentNodeAns = new Ans(currentNodeHeight, currentNodeDiameter);


        return currentNodeAns;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance1();
        int res = treeDiameterSolutionOne(root);
        System.out.println("Diameter of Solution One is : " + res);
        System.out.print("Diameter of Tree is : " + finalDiameter);

//        Ans ans = treeDiameterSolutionThree(root);
//        System.out.println("Solution 3 is : " + ans.diameter);
    }
}
