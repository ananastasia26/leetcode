package com.saltuk.coin.change;

import java.util.*;

/**
 * 322-coin-change
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];

        Arrays.fill(memo, -1);
        memo[0] = 0;

        findMinCoins(coins, 0, 0, memo);

        return memo[amount];
    }

    private void findMinCoins(int[] coins, int idx, int sum, int[] memo) {
        if(idx >= coins.length) {
            return;
        }

        var coin = coins[idx];
        var newSum = sum + (long)coin;
        if (newSum < memo.length) {
            var counter = memo[sum];

            var cnewSum = (int)newSum;

            if (memo[cnewSum] == -1 || counter + 1 < memo[cnewSum]) {
                memo[cnewSum] = counter + 1;
                findMinCoins(coins, idx, cnewSum, memo);
            }
        }

        findMinCoins(coins, idx + 1, sum, memo);
    }

}