package DynamicProgramming.UnBoundedKnapsackPattern;

public class MinCoinsForCoinSum {

    private static int minCoins(int[] coins, int coinSum, int idx) {
        if (coinSum == 0) return 0;
        else if (idx <= 0) return Integer.MAX_VALUE - 1;
        else if (coinSum - coins[idx - 1] >= 0) {
            int opt1 = 1 + minCoins(coins, coinSum - coins[idx - 1], idx);
            int opt2 = minCoins(coins, coinSum, idx - 1);
            return Math.min(opt1, opt2);
        }
        return minCoins(coins, coinSum, idx - 1);
    }

    private static int minCoinsTopDown(int[] coins, int coinSum) {
        int[][] dp = new int[coins.length + 1][coinSum + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < coinSum + 1; j++) {
                if (j == 0) dp[i][j] = 0;
                else if (i == 0) dp[i][j] = Integer.MAX_VALUE - 1;
                else if (j - coins[i - 1] >= 0) {
                    int opt1 = 1 + dp[i][j - coins[i - 1]];
                    int opt2 = dp[i - 1][j];
                    dp[i][j] = Math.min(opt1, opt2);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][coinSum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int coinSum = 5;
        System.out.println("minCoins(coins, coinSum, coins.length) = " + minCoins(coins, coinSum, coins.length));
        System.out.println("minCoinsTopDown(coins, coinSum) = " + minCoinsTopDown(coins, coinSum));
    }
}

/**
 * {1,1,1,1,1} = 5;
 * {2,2,1} = 3
 * {3,1,1} = 3
 * {3,2} = 2
 */
