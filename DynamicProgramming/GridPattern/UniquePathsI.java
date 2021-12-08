package DynamicProgramming.GridPattern;

import java.util.Arrays;

public class UniquePathsI {

    private static int dfs(int m, int n, int i, int j) {
        if (m == i && n == j) return 1;
        else if (i > m || j > n) return 0;

        //1. move down
        int down = dfs(m, n, i + 1, j);
        //2.move to right side;
        int right = dfs(m, n, i, j + 1);

        return down + right;
    }

    private static void numberOfWaysToReachTarget(int m, int n) {
        System.out.println("dfs(3, 2, 0, 0) = " + dfs(m, n, 1, 1));
    }

    private static int[][] dp;

    private static int dfsMemo(int m, int n, int i, int j) {
        if (m == i && n == j) return 1;
        else if (i > m || j > n) return 0;
        else if (dp[i][j] != -1) return dp[i][j];

        //1. move down
        int down = dfsMemo(m, n, i + 1, j);
        //2.move to right side;
        int right = dfsMemo(m, n, i, j + 1);

        return dp[i][j] = down + right;
    }


    public static int uniquePaths(int m, int n) {
        dp = new int[m + 1][n + 1];
        for (int[] dpArr : dp) Arrays.fill(dpArr, -1);
        return dfs(m, n, 1, 1);
    }

    public static void main(String[] args) {
        numberOfWaysToReachTarget(7, 3);
    }
}
