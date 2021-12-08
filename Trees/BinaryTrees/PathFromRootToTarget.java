package Trees.BinaryTrees;

import java.util.ArrayList;

public class PathFromRootToTarget {

    private static boolean findPathFromRootToTarget(TreeNode root, int target, ArrayList<Integer> ans) {
        if (root == null) return false;

        ans.add(root.data);
        if (root.data == target) return true;

        if (findPathFromRootToTarget(root.left, target, ans) ||
                findPathFromRootToTarget(root.right, target, ans)) return true;

        ans.remove(ans.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        findPathFromRootToTarget(TreeNode.getInstance1(), 4, arr);
        for (int i : arr) System.out.print(i + " ");
    }
}
