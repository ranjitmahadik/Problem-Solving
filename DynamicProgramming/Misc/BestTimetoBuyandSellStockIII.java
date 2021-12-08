package DynamicProgramming.Misc;

import util.Util;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIII {
    private static int maxProfit(int[] stocks, int idx, int k, boolean canSell) {
        if (idx >= stocks.length || k <= 0) return 0;

        if (canSell) {
            //1.we decide to sell it.
            int sell = stocks[idx] + maxProfit(stocks, idx + 1, k - 1, false);
            //2.we don't decide to sell it.
            int doNotSell = maxProfit(stocks, idx + 1, k, canSell);

            return Math.max(sell, doNotSell);
        } else {
            //1. we decide to buy stock today.
            int buy = maxProfit(stocks, idx + 1, k, true) - stocks[idx];

            //2. we don't decide to buy stock today.
            int doNotBuy = maxProfit(stocks, idx + 1, k, false);
            return Math.max(buy, doNotBuy);
        }
    }


    private static int[][][] dp;

    private static int maxProfitMemo(int[] stocks, int idx, int k, boolean canSell) {
        if (idx >= stocks.length || k <= 0) return 0;
        else if (dp[idx][Util.convertBoolToInt(canSell)][k] != -1) return dp[idx][Util.convertBoolToInt(canSell)][k];

        if (canSell) {
            //1.we decide to sell it.
            int sell = stocks[idx] + maxProfitMemo(stocks, idx + 1, k - 1, false);
            //2.we don't decide to sell it.
            int doNotSell = maxProfitMemo(stocks, idx + 1, k, canSell);

            return dp[idx][Util.convertBoolToInt(canSell)][k] = Math.max(sell, doNotSell);
        } else {
            //1. we decide to buy stock today.
            int buy = maxProfitMemo(stocks, idx + 1, k, true) - stocks[idx];

            //2. we don't decide to buy stock today.
            int doNotBuy = maxProfitMemo(stocks, idx + 1, k, false);
            return dp[idx][Util.convertBoolToInt(canSell)][k] = Math.max(buy, doNotBuy);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {3, 3, 5, 0, 0, 3, 1, 4};
        dp = new int[stocks.length + 1][2][3];
        for (int[][] dArr : dp) {
            for (int[] arr : dArr) {
                Arrays.fill(arr, -1);
            }
        }
        System.out.println(maxProfit(stocks, 0, 2, false) + " : " + maxProfitMemo(stocks, 0, 2, false));
    }

}
