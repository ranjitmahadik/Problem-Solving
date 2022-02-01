package DynamicProgramming.GridPattern;

import java.util.ArrayList;
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

    private static int uniquePathsBottomUp(int n, int m) {
        int dp[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i - 1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    private static int uniquePathsBottomUpOptimal(int n, int m) {
        ArrayList<Integer> prev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) curr.add(j, 1);
                else {
                    int up = 0, left = 0;
                    if(i > 0)   up = prev.get(j);
                    if(j > 0)   left = curr.get(j-1);

                    curr.add(j, up + left);
                }
            }
            prev = curr;
        }
        return prev.get(m - 1);
    }

    public static void main(String[] args) {
        numberOfWaysToReachTarget(7, 3);
    }
}
