package Trees.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    private static List<Integer> branchSums = new ArrayList<>();

    // O(n) in time and O(n) in space complexity.
    private static void sumBranches(TreeNode root, int sum) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            branchSums.add(sum + root.data);
            return;
        }

        sumBranches(root.left, sum + root.data);
        sumBranches(root.right, sum + root.data);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance();
        sumBranches(root, 0);
        for (int i : branchSums) {
            System.out.print(i + " ");
        }
    }
}
