package DynamicProgramming.GridPattern;

public class MaxFallingPathSum {
    private static int maxFallingPathSum(int[][] arr, int row, int col) {
        if (row >= arr.length || col < 0 || col >= arr[0].length) return Integer.MIN_VALUE;
        else if (row == arr.length - 1) return arr[row][col];

        int moveDown = maxFallingPathSum(arr, row + 1, col);
        int moveDownRight = maxFallingPathSum(arr, row + 1, col + 1);
        int moveDownLeft = maxFallingPathSum(arr, row + 1, col - 1);

        return Math.max(moveDown, Math.max(moveDownLeft, moveDownRight)) + arr[row][col];
    }

    private static int maxFallingPathSumRev(int[][] arr, int row, int col) {
        if (row < 0 || col < 0 || col >= arr[0].length) return Integer.MIN_VALUE;
        else if (row == 0) return arr[row][col];

        int moveUp = maxFallingPathSumRev(arr, row - 1, col);
        int moveUpRight = maxFallingPathSumRev(arr, row - 1, col + 1);
        int moveUpLeft = maxFallingPathSumRev(arr, row - 1, col - 1);

        return Math.max(moveUp, Math.max(moveUpLeft, moveUpRight)) + arr[row][col];
    }

    private static int maxFallingPathSumTopDown(int[][] arr) {
        int n = arr.length, m = arr[0].length, ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) dp[0][i] = arr[0][i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int moveUp = dp[i - 1][j];
                int moveUpRight = Integer.MIN_VALUE, moveUpLeft = Integer.MIN_VALUE;
                if (j + 1 < m)
                    moveUpRight = dp[i - 1][j + 1];
                if (j - 1 >= 0)
                    moveUpLeft = dp[i - 1][j - 1];
                dp[i][j] = Math.max(moveUpLeft, Math.max(moveUpRight, moveUp)) + arr[i][j];
                if (i == n - 1) ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};
        int ans1 = 0, ans2 = 0, ans3 = 0;
        for (int i = 0; i < arr[0].length; i++) {
            ans1 = Math.max(ans1, maxFallingPathSum(arr, 0, i));
            ans2 = Math.max(ans2, maxFallingPathSumRev(arr, 3, i));
        }
        ans3 = maxFallingPathSumTopDown(arr);
        System.out.println("Max Falling Path Sum = " + ans1 + " and " + ans2 + " and " + ans3);
    }
}
