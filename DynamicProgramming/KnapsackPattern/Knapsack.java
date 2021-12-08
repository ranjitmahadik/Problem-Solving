package DynamicProgramming.KnapsackPattern;

import java.util.Arrays;

public class Knapsack {

    private static int getMaxProfit(int[] weight, int[] profit, int idx, int weightLimit) {
        if (weightLimit == 0 || idx <= 0) {
            return 0;
        } else if (weightLimit - weight[idx - 1] >= 0) {
            int opt1 = profit[idx - 1] + getMaxProfit(weight, profit, idx - 1, weightLimit - weight[idx - 1]);
            int opt2 = getMaxProfit(weight, profit, idx - 1, weightLimit);
            return Math.max(opt1, opt2);
        }
        return getMaxProfit(weight, profit, idx - 1, weightLimit);
    }

    private static int getMaxProfitMemoized(int[] weight, int[] profit, int idx, int weightLimit, int[][] dp) {
        if (weightLimit == 0 || idx == 0) return 0;
        else if (dp[idx][weightLimit] != -1) return dp[idx][weightLimit];
        else if (weightLimit - weight[idx - 1] >= 0) {
            int opt1 = profit[idx - 1] + getMaxProfitMemoized(weight, profit, idx - 1, weightLimit - weight[idx - 1], dp);
            int opt2 = getMaxProfitMemoized(weight, profit, idx - 1, weightLimit, dp);
            return dp[idx][weightLimit] = Math.max(opt1, opt2);
        }
        return dp[idx][weightLimit] = getMaxProfitMemoized(weight, profit, idx - 1, weightLimit, dp);
    }

    /***                0   1   2   3   4   5   6   7       
     *              0   0   0   0   0   0   0   0   0
     *              1   0
     *              2
     *              3
     *              4
     *
     * */

    private static int getMaxProfitTopDown(int[] weight, int[] profit, int weightLimit) {
        int[][] dp = new int[weight.length + 1][weightLimit + 1];
        for (int i = 0; i < weight.length + 1; i++) {
            for (int j = 0; j < weightLimit + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (j - weight[i - 1] >= 0) {
                    int opt1 = profit[i - 1] + dp[i - 1][j - weight[i - 1]];
                    int opt2 = dp[i - 1][j];

                    dp[i][j] = Math.max(opt1, opt2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weight.length][weightLimit];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] profit = {1, 4, 5, 7};
        int weightLimit = 7;
        System.out.println("getMaxProfit(weight,profit,len,weightLimit) = " + getMaxProfit(weight, profit, weight.length, weightLimit));

        int[][] dp = new int[weight.length + 1][weightLimit + 1];
        for (int i = 0; i < weight.length + 1; i++) Arrays.fill(dp[i], -1);

        System.out.println("getMaxProfitMemoized(weight,profit,weight.length,weightLimit,dp) = " + getMaxProfitMemoized(weight, profit, weight.length, weightLimit, dp));
        System.out.println("getMaxProfitTopDown(weight, profit, weightLimit) = " + getMaxProfitTopDown(weight, profit, weightLimit));
    }
}
