package DynamicProgramming.Misc;

import java.util.Arrays;

public class ClimbingStairs {
    private static int climbingStairs(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;

        int oneStep = climbingStairs(n - 1);
        int twoStep = climbingStairs(n - 2);
        return oneStep + twoStep;
    }

    private static int climbingStairsMemoized(int n, int[] dp) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (dp[n] != -1) return dp[n];


        int oneStep = climbingStairsMemoized(n - 1, dp);
        int twoStep = climbingStairsMemoized(n - 2, dp);
        return dp[n] = oneStep + twoStep;
    }

    private static int climbingStairsTopDown(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i == 0) dp[i] = 0;
            else if (i == 1) dp[i] = 1;
            else if (i == 2) dp[i] = 2;
            else {
                int oneStep = dp[i - 1];
                int twoStep = dp[i - 2];
                dp[i] = oneStep + twoStep;
            }
        }
        return dp[n];
    }

    // space = o(1) and time o(n-3)
    private static int climbingStairsSpaceOptimized(int n) {
        int prevSteps = 2, prevPrevSteps = 1;
        for (int i = 3; i < n + 1; i++) {
            int oneStep = prevSteps;
            int twoStep = prevPrevSteps;

            prevPrevSteps = prevSteps;
            prevSteps = oneStep + twoStep;
        }

        return prevSteps;
    }

    public static void main(String[] args) {
        int ans = climbingStairs(45);
        int[] dp = new int[46];
        Arrays.fill(dp, -1);
        int ans2 = climbingStairsMemoized(45, dp);
        int ans3 = climbingStairsTopDown(45);

        System.out.println("ans3 = " + ans + " " + ans2 + " " + ans3);

    }
}
