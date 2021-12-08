package DynamicProgramming.Misc;

import util.Util;

import java.util.Arrays;

public class BestTimetoBuyandSellStockII {

    private static int[][] dp;



    private static int maxProfit(int[] stocks, int idx, boolean canWeBuy) {
        if (idx >= stocks.length) return 0;
        else if (dp[idx][Util.convertBoolToInt(canWeBuy)] != -1) return dp[idx][Util.convertBoolToInt(canWeBuy)];

        if (canWeBuy) {
            //1. we buy today.
            int opt1 = maxProfit(stocks, idx + 1, false) - stocks[idx];
            //2. we don't buy today.
            int opt2 = maxProfit(stocks, idx + 1, true);

            return dp[idx][Util.convertBoolToInt(canWeBuy)] = Math.max(opt1, opt2);
        } else {
            //1. we sell today.
            int opt1 = stocks[idx] + maxProfit(stocks, idx + 1, true);

            //2. we don't sell today.
            int opt2 = maxProfit(stocks, idx + 1, false);
            return dp[idx][Util.convertBoolToInt(canWeBuy)] = Math.max(opt1, opt2);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {7, 1, 5, 3, 6, 4};
        dp = new int[stocks.length + 1][2];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        System.out.println(maxProfit(stocks, 0, true));
    }
}
