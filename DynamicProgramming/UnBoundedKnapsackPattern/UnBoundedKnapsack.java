package DynamicProgramming.UnBoundedKnapsackPattern;

public class UnBoundedKnapsack {
    private static int unBoundedKnapsack(int[] weight, int[] profit, int capacity, int idx) {
        if (idx <= 0 || capacity == 0) return 0;
        else if (capacity - weight[idx - 1] >= 0) {
            return Math.max(profit[idx - 1] + unBoundedKnapsack(weight, profit, capacity - weight[idx - 1], idx), unBoundedKnapsack(weight, profit, capacity, idx - 1));
        }
        return unBoundedKnapsack(weight, profit, capacity, idx - 1);
    }

    private static int unBoundedKnapsackTopDown(int[] weight, int[] profit, int capacity) {
        int[][] dp = new int[weight.length + 1][capacity + 1];

        for (int i = 0; i < weight.length + 1; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                if (j == 0 || i == 0) dp[i][j] = 0;
                else if (j - weight[i - 1] >= 0)
                    dp[i][j] = Math.max(profit[i - 1] + dp[i][j - weight[i - 1]], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[weight.length][capacity];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 5};
        int[] profit = {1, 4, 5, 7};
        int weightLimit = 7;
        System.out.println("unBoundedKnapsack(weight,profit,weightLimit,profit.length) = " + unBoundedKnapsack(weight, profit, weightLimit, profit.length));
        System.out.println("unBoundedKnapsackTopDown(weight, profit, weightLimit) = " + unBoundedKnapsackTopDown(weight, profit, weightLimit));
    }
}
