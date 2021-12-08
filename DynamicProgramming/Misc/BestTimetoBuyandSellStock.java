package DynamicProgramming.Misc;

public class BestTimetoBuyandSellStock {

    private static int maxProfit(int[] stocks, int idx, boolean didWeBuy) {
        if (idx >= stocks.length) return 0;

        if (didWeBuy) {
            // we don't sell on idx'th day.
            int option1 = maxProfit(stocks, idx + 1, didWeBuy);
            //we sell it ons idx'th day.
            int option2 = stocks[idx - 1];
            return Math.max(option1, option2);
        } else {
            // we don't buy stock on idx'th day.
            int buyed = maxProfit(stocks, idx + 1, true) - stocks[idx];
            int doNotBuy = maxProfit(stocks, idx + 1, false);
            return Math.max(buyed, doNotBuy);
        }
    }

    public static void main(String[] args) {
        int[] stocks = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(stocks, 0, false));
    }
}
