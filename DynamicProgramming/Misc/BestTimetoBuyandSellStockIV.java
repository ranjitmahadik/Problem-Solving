package DynamicProgramming.Misc;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIV {

    private static int maxProfit(int[] stocks, int idx, int k, int canSell) {
        if (idx >= stocks.length || k <= 0) return 0;

        if (canSell == 1) {
            //1.we decide to sell the stock today
            int selled = stocks[idx] + maxProfit(stocks, idx + 1, k - 1, 0);
            //2.we don't decide to sell stock today.
            int doNotSell = maxProfit(stocks, idx + 1, k, canSell);

            return Math.max(selled, doNotSell);
        } else {
            //1.We decide to buy stock today.
            int buyed = maxProfit(stocks, idx + 1, k, 1) - stocks[idx];
            int notBuyed = maxProfit(stocks, idx + 1, k, 0);

            return Math.max(buyed, notBuyed);
        }
    }


    private static int[][][] dp;

    private static int maxProfitMemo(int[] stocks, int idx, int k, int canSell) {
        if (idx >= stocks.length || k <= 0) return 0;
        else if (dp[idx][k][canSell] != -1) return dp[idx][k][canSell];

        if (canSell == 1) {
            //1.we decide to sell the stock today
            int selled = stocks[idx] + maxProfitMemo(stocks, idx + 1, k - 1, 0);
            //2.we don't decide to sell stock today.
            int doNotSell = maxProfitMemo(stocks, idx + 1, k, canSell);

            return dp[idx][k][canSell] = Math.max(selled, doNotSell);
        } else {
            //1.We decide to buy stock today.
            int buyed = maxProfitMemo(stocks, idx + 1, k, 1) - stocks[idx];
            int notBuyed = maxProfitMemo(stocks, idx + 1, k, 0);

            return dp[idx][k][canSell] = Math.max(buyed, notBuyed);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {3, 2, 6, 5, 0, 3};
        int k = 2;
        dp = new int[stocks.length + 1][k + 1][2];
        for (int[][] dpArr : dp) {
            for (int[] arr : dpArr) Arrays.fill(arr, -1);
        }
        System.out.println(maxProfit(stocks, 0, k, 0));
    }
}
