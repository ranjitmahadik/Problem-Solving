package Trees.BinaryTrees;

public class LCA {

    private static TreeNode getLCA(TreeNode root, int target1, int target2) {
        if (root == null) return null;

        if (root.data == target1 || root.data == target2) return root;

        TreeNode left = getLCA(root.left, target1, target2);
        TreeNode right = getLCA(root.right, target1, target2);
        if (left != null && right != null)
            if (left.data == target1 && right.data == target2 || left.data == target2 && right.data == target1)
                return root;
        return left != null ? left : right;
    }

    static int[] level = new int[10];
    static int[][] p = new int[30][30];

    private static void dfs(int src, int par, int lvl, int[][] graph) {
        level[src] = lvl;
        for (int child : graph[src]) {
            if (child != par) {
                dfs(child, src, lvl + 1, graph);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance1();
        TreeNode ans = getLCA(root, 3, 8);
        System.out.println(ans);
    }
}

