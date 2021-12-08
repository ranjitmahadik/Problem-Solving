package DynamicProgramming.Misc;

import java.util.Arrays;

public class BestTimetoBuyandSellStockwithTransactionFee {
    private static int maxProfit(int[] stocks, int idx, int canSell, int fee) {
        if (idx >= stocks.length) return 0;

        if (canSell == 1) {
            //1.Sell stock today with required fee.
            int sellStock = stocks[idx] + maxProfit(stocks, idx + 1, 0, fee) - fee;
            //2.don't sell stock today.
            int doNotSell = maxProfit(stocks, idx + 1, 1, fee);

            return Math.max(sellStock, doNotSell);
        } else {
            //1.can buy stock today.
            int buyedStockToday = maxProfit(stocks, idx + 1, 1, fee) - stocks[idx];
            //2.don't buy stock today.
            int notBuyStockToday = maxProfit(stocks, idx + 1, 0, fee);

            return Math.max(buyedStockToday, notBuyStockToday);
        }
    }

    private static int[][] dp;

    private static int maxProfitMemo(int[] stocks, int idx, int canSell, int fee) {
        if (idx >= stocks.length) return 0;
        else if (dp[idx][canSell] != -1) return dp[idx][canSell];

        if (canSell == 1) {
            //1.Sell stock today with required fee.
            int sellStock = stocks[idx] + maxProfitMemo(stocks, idx + 1, 0, fee) - fee;
            //2.don't sell stock today.
            int doNotSell = maxProfitMemo(stocks, idx + 1, 1, fee);

            return dp[idx][canSell] = Math.max(sellStock, doNotSell);
        } else {
            //1.can buy stock today.
            int buyedStockToday = maxProfitMemo(stocks, idx + 1, 1, fee) - stocks[idx];
            //2.don't buy stock today.
            int notBuyStockToday = maxProfitMemo(stocks, idx + 1, 0, fee);

            return dp[idx][canSell] = Math.max(buyedStockToday, notBuyStockToday);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {};
        int fee = 2;
        dp = new int[stocks.length + 1][2];
        for (int[] dpArr : dp) Arrays.fill(dpArr, -1);
        maxProfitMemo(stocks,0,0,fee);
    }

}
