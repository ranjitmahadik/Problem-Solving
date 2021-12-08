package Trees.BinarySearchTree;

public class FindClosestValue {
    private static final int NOT_FOUND = -1;
    private static int possibleAns = Integer.MAX_VALUE;

    private static void findClosest(TreeNode root, final int target) {
        if (root == null) return;

        if (Math.abs(target - root.val) <= Math.abs(possibleAns - target)) {
            possibleAns = root.val;
            return;
        }

        findClosest(root.left, target);
        findClosest(root.right, target);

    }

    private static void findClosestOptimal(TreeNode root, int target) {
        if (root == null) return;

        if (Math.abs(target - root.val) <= Math.abs(possibleAns - target)) {
            possibleAns = root.val;
            return;
        }

        if(root.val < target)   findClosest(root.right,target);
        else    findClosest(root.left,target);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance();
        findClosestOptimal(root, 16);
        System.out.println("possibleAns = " + possibleAns);
    }
}
