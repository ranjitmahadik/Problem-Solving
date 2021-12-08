package DynamicProgramming.Misc;

import java.util.Arrays;

public class MinCostClimbingStairs {

    private static int getMinCost(int[] cost, int idx) {
        if (idx >= cost.length) return 0;

        int costAtCurrentIndex = cost[idx];

        int oneStep = getMinCost(cost, idx + 1);
        int twoStep = getMinCost(cost, idx + 2);

        return Math.min(oneStep, twoStep) + costAtCurrentIndex;
    }

    private static int getMinCostMemoized(int[] cost, int idx, int[] dp) {
        if (idx >= cost.length) return 0;
        else if (dp[idx] != -1) return dp[idx];

        int costAtCurrentIndex = cost[idx];

        int oneStep = getMinCostMemoized(cost, idx + 1, dp);
        int twoStep = getMinCostMemoized(cost, idx + 2, dp);

        return dp[idx] = Math.min(oneStep, twoStep) + costAtCurrentIndex;
    }

    private static int getMinCostTopDown(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 0; i < cost.length + 1; i++) {
            if (i == 0) dp[i] = 0;
            else if (i == 1) dp[i] = cost[i - 1];
            else {
                int currentCost = cost[i - 1];

                int oneStep = dp[i - 1];
                int twoStep = dp[i - 2];

                dp[i] = Math.min(oneStep, twoStep) + currentCost;
            }
        }

        return Math.min(dp[cost.length], dp[cost.length - 1]);
    }

    private static int getMinCostSpaceOptimized(int[] cost) {
        int prevStep = 0, prevPrevStep = 0;
        for (int i = 0; i < cost.length + 1; i++) {
            if (i == 0) prevPrevStep = 0;
            else if (i == 1) prevStep = cost[i - 1];
            else {
                int currentCost = cost[i - 1];

                int oneStep = prevStep;
                int twoStep = prevPrevStep;

                prevPrevStep = prevStep;
                prevStep = Math.min(oneStep, twoStep) + currentCost;
            }
        }

        return Math.min(prevPrevStep,prevStep);
    }

    private static void minClimbingCost(int[] cost) {
        int ans1 = Math.min(getMinCost(cost, 0),
                getMinCost(cost, 1));

        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        int ans2 = Math.min(getMinCostMemoized(cost, 0, dp),
                getMinCostMemoized(cost, 1, dp));

        int ans3 = getMinCostTopDown(cost);

        System.out.println(ans1 + " : " + ans2 + " : " + ans3);
    }


    public static void main(String[] args) {
        minClimbingCost(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    }
}
