package com.saltuk.house.robber.ii;

/**
 * 213. House Robber II
 */
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        var maxProfitFirst = countProfit(nums, 0, nums.length - 1);
        var maxProfitSecond = countProfit(nums, 1, nums.length);

        return Math.max(maxProfitFirst, maxProfitSecond);
    }

    private int countProfit(int[] nums, int startIdx, int endIdx) {
        int[] memo = new int[endIdx - startIdx + 2];

        for(int i = startIdx; i < endIdx; ++i) {
            var k = i + 2 - startIdx;

            memo[k] = Math.max(memo[k - 1], memo[k - 2] + nums[i]);
        }

        return memo[endIdx - startIdx + 1];
    }
}
