package DynamicProgramming.UnBoundedKnapsackPattern;

public class MaxCoinsForCoinSum {

    private static int maxCoinsRecursion(int[] coins, int coinSum, int idx) {
        if (coinSum == 0) return 0;
        else if (idx <= 0) return Integer.MIN_VALUE;
        else if (coinSum - coins[idx - 1] >= 0) {
            int opt1 = 1 + maxCoinsRecursion(coins, coinSum - coins[idx - 1], idx);
            int opt2 = maxCoinsRecursion(coins, coinSum, idx - 1);

            return Math.max(opt1, opt2);
        }
        return maxCoinsRecursion(coins, coinSum, idx - 1);
    }

    private static int maxCoins(int[] coins, int coinSum) {
        int[][] dp = new int[coins.length + 1][coinSum + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < coinSum + 1; j++) {
                if (j == 0) {       // when coins sum = 0 ? we always have 1 way to make it.
                    dp[i][j] = 0;
                } else if (i == 0 && j > 0) {   // if coinsSUm > 0 and we have array with zero size then to make sum we need -inf coins.
                    dp[i][j] = Integer.MIN_VALUE;
                } else if (j - coins[i - 1] >= 0) {
                    int opt1 = 1 + dp[i][j - coins[i - 1]];
                    int opt2 = dp[i - 1][j];

                    dp[i][j] = Math.max(opt1, opt2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][coinSum];
    }

    public static void main(String[] args) {
        int[] coins = { 2,3, 5, 10};
        int coinSum = 5;
        System.out.println("maxCoinsRecursion(coins, coinSum, coins.length) = " + maxCoinsRecursion(coins, coinSum, coins.length));
        System.out.println("maxCoins(coins, coinSum) = " + maxCoins(coins, coinSum));
    }
}
