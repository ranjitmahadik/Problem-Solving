package DynamicProgramming.Misc;

import java.util.Arrays;

public class BestTimetoBuyandSellStockwithCooldown {
    private static int maxProfit(int[] stocks, int idx, int k, int canSell) {
        if (idx >= stocks.length || k <= 0) return 0;

        if (canSell == 1) {
            //1.we decide to sell stock today with cooldown period of 1 day.
            int sellStock = stocks[idx] + maxProfit(stocks, idx + 2, k - 1, 0);
            //2.we don't decide to sell stock today.
            int notSellStock = maxProfit(stocks, idx + 1, k, 1);

            return Math.max(sellStock, notSellStock);
        } else {
            int buyedStock = maxProfit(stocks, idx + 1, k, 1) - stocks[idx];
            int notBuyed = maxProfit(stocks, idx + 1, k, 0);

            return Math.max(buyedStock, notBuyed);
        }
    }

    /**
     *  if we think clearly then we can see that transactions (k) is not required as we not bounded by k.
     *  so we can reduce space to n * 2
     * */
    private static int[][][] dp;
    private static int maxProfitMemo(int[] stocks, int idx, int k, int canSell) {
        if (idx >= stocks.length || k <= 0) return 0;
        else if (dp[idx][k][canSell] != -1) return dp[idx][k][canSell];

        if (canSell == 1) {
            //1.we decide to sell stock today with cooldown period of 1 day.
            int sellStock = stocks[idx] + maxProfit(stocks, idx + 2, k - 1, 0);
            //2.we don't decide to sell stock today.
            int notSellStock = maxProfit(stocks, idx + 1, k, 1);

            return dp[idx][k][canSell] = Math.max(sellStock, notSellStock);
        } else {
            int buyedStock = maxProfit(stocks, idx + 1, k, 1) - stocks[idx];
            int notBuyed = maxProfit(stocks, idx + 1, k, 0);

            return dp[idx][k][canSell] = Math.max(buyedStock, notBuyed);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {};
        int k = (int) 1e3;
        dp = new int[stocks.length + 1][k + 1][2];
        for (int[][] dpArr : dp) {
            for (int[] arr : dpArr) Arrays.fill(arr, -1);
        }
    }
}
