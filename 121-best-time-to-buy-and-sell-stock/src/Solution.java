class Solution {
    public int maxProfit(int[] prices) {
        int[] bestPurchase = new int[prices.length];
        bestPurchase[0] = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, prices[i] - bestPurchase[i - 1]);
            bestPurchase[i] = Math.min(bestPurchase[i - 1], prices[i]);
        }

        return maxProfit;
    }

    /*
    TLE, because of recursion
    public int maxProfit(int[] prices) {
        return buy(prices, 0);
    }

    private int buy(int[] prices, int idx) {
        if(idx >= prices.length) {
            return 0;
        }
        var profitIfBuy = sell(prices, prices[idx], idx + 1);
        var profitIfMiss = buy(prices, idx + 1);
        return Math.max(profitIfBuy, profitIfMiss);
    }

    private int sell(int[] prices, int buyPrice, int idx) {
        if(idx >= prices.length) {
            return Integer.MIN_VALUE;
        }

        var profitIfSell = prices[idx] - buyPrice;
        var profitIfMiss = sell(prices, buyPrice, idx + 1);
        return Math.max(profitIfSell, profitIfMiss);
    }
     */
}