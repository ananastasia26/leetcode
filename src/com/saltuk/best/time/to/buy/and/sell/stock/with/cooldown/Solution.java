package com.saltuk.best.time.to.buy.and.sell.stock.with.cooldown;

class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[] free = new int[days + 1];
        int[] hold = new int[days + 1];

        hold[0] = -prices[0];
        hold[1] = -prices[0];

        free[0] = 0;
        free[1] = 0;

        for(int i = 2; i < days + 1; ++i) {
            hold[i] = Math.max(hold[i - 1], free[i - 2] - prices[i - 1]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i - 1]);
        }

        return free[days];
    }
}
