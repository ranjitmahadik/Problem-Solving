package DynamicProgramming.Misc;

import java.util.ArrayList;

public class TriangularMinSum {
    private static int minSum(int[][] arr, int i, int j) {
        if (i == arr.length) return 0;

        int moveDown = minSum(arr, i + 1, j);
        int moveDownRight = minSum(arr, i + 1, j + 1);

        return Math.min(moveDown, moveDownRight) + arr[i][j];
    }

    private static int minSumTopDown(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
//                int moveDown = dp[i + 1][j];
//                int moveDownRight = dp[i + 1][j + 1];
//                dp[i][j] = Math.min(moveDown, moveDownRight) + arr[i][j];

                int moveDown = arr[i][j] + dp[i + 1][j];
                int moveRight = arr[i][j] + dp[i + 1][j + 1];
                dp[i][j] = Math.min(moveDown, moveRight);
            }
        }
        return dp[0][0];
    }

    private static int minSumOptimal(int[][] arr) {
        int n = arr.length;
        ArrayList<Integer> nextState = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nextState.add(arr[n - 1][i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            ArrayList<Integer> currState = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                int moveDown = arr[i][j] + nextState.get(j);
                int moveDownRight = arr[i][j] + nextState.get(j + 1);
                currState.add(Math.min(moveDown, moveDownRight));
            }
            nextState = currState;
        }

        return nextState.get(0);
    }

    public static void main(String[] args) {
        int[][] arr = {{1}, {2, 3}, {4, 5, 6}, {7, 8, 9, 10}};
        System.out.println(minSum(arr, 0, 0));
        System.out.println(minSumTopDown(arr));
        System.out.println(minSumOptimal(arr));
    }
}
