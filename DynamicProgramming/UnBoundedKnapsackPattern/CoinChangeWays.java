package DynamicProgramming.UnBoundedKnapsackPattern;

//max ways
public class CoinChangeWays {
    /**
     * coins array has length 0 and coinSum > 0 ;   then there are 0 ways to make sum = 5;
     */
    private static int maxWaysToChangeCoins(int[] coins, int coinSum, int idx) {
        if (coinSum == 0) return 1;
        else if (idx <= 0) return 0;
        else if (coinSum - coins[idx - 1] >= 0) {
            int opt1 = maxWaysToChangeCoins(coins, coinSum - coins[idx - 1], idx);
            int opt2 = maxWaysToChangeCoins(coins, coinSum, idx - 1);
            return opt1 + opt2;
        }
        return maxWaysToChangeCoins(coins, coinSum, idx - 1);
    }

    private static int maxWaysToChangeCoinsTopDown(int[] coins, int coinSum) {
        int[][] dp = new int[coins.length + 1][coinSum + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            for (int j = 0; j < coinSum + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[coins.length][coinSum];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int coinSum = 5;

        int recursiveSolution = maxWaysToChangeCoins(coins, coinSum, coins.length);
        int topDownSolution = maxWaysToChangeCoinsTopDown(coins, coinSum);

        System.out.println("recursive : " + recursiveSolution + "\ntopDown : " + topDownSolution);
    }
}
/**
 * 1 + 1 + 1 + 1 + 1 = 5
 * 1 + 1 + 1 + 2 = 5
 * 2 + 2 + 1 = 5
 * 5 = 5
 */