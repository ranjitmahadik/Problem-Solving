package Trees;

import java.util.ArrayList;

public class MaxSumRootToLeaf {
    private static ArrayList<Integer>[] tree;
    private static int[] dp;
    private static int ans = 0;
    private static int n;

    private static int dfs(int src, int par) {
        int sourceNodeSum = src;
        int maxSubtree = 0;
        for (int child : tree[src]) {
            if (child != par) {
                int childSum = dfs(child, src);
                ans = Math.max(childSum + sourceNodeSum, ans);
                maxSubtree = Math.max(childSum, maxSubtree);
            }
        }
        return sourceNodeSum + maxSubtree;
    }

    private static void dfs1(int src, int par) {
        dp[src] = src;
        int maxChild = 0;
        for (int child : tree[src]) {
            if (child != par) {
                dfs1(child, src);
                maxChild = Math.max(maxChild, dp[child]);
            }
        }
        dp[src] += maxChild;
    }

    /***
     *                          3
     *                2         6           10
     *         1        3       9       11  12  13
     *      4     5             7
     *
     */
    private static void buildTree() {
        n = 15;
        tree = new ArrayList[n];
        dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = -1;
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();

        tree[3].add(2);
        tree[3].add(6);
        tree[3].add(10);

        tree[2].add(1);
        tree[2].add(3);

        tree[1].add(4);
        tree[1].add(5);

        tree[6].add(9);
        tree[9].add(8);
        tree[9].add(7);

        tree[10].add(11);
        tree[10].add(12);
        tree[10].add(13);
    }

    public static void main(String[] args) {
        buildTree();
        dfs(3, -1);
        System.out.println("ans = " + ans);
        dfs1(3, -1);
        System.out.println("dp ans : " + dp[3]);

    }
}
