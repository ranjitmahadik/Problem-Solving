package Trees.BinaryTrees;

public class kthAncestor {
    private static int[] parent = new int[20];

    //    o(n) time complexity of dfs
    private static void dfs(TreeNode root, int par) {
        if (root == null) return;

        parent[root.data] = par;
        dfs(root.left, root.data);
        dfs(root.right, root.data);
    }

    // returns kth ancestor of node u. this also takes o(n) is worst case.
    private static int getKthAncestor(int u, int k) {
        if (k == 0) return u;

        while (k > 0) {
            u = parent[u];
            k--;
        }

        return u;
    }

    private static int[][] optiParent = new int[20][20];
    // o(n*logn)
    private static void optimizedDfs(TreeNode root, int par) {
        if (root == null) return;

        optiParent[root.data][0] = par;
        for (int i = 1; i < 20; i++) {
            optiParent[root.data][i] = optiParent[optiParent[root.data][i - 1]][i - 1];
        }
        optimizedDfs(root.left, root.data);
        optimizedDfs(root.right, root.data);
    }
    // o(logn)
    private static int getKthAncestorOptimized(int u, int k) {
        if (k == 0) return u;
        for (int i = 14; i >= 0; i--) {
            if ((k & (1 << i)) > 0) {
                u = optiParent[u][i];
            }
        }
        return u;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getInstance2();

        /**
         *  Time complexity  => O(2n)
         *  Space complexity => O(n)
         * */
        dfs(root, 0);
        System.out.println("kth ancestor = " + getKthAncestor(14, 5));


        /**
         *  Time complexity  => O(n + log(n))
         *  Space complexity => O(n*log(n))
         *
         *  binary uplifting technique used.
         * */
        optimizedDfs(root, 0);
        System.out.println("kth ancestor = " + getKthAncestorOptimized(14, 5));

    }
}
