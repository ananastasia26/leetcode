package com.saltuk.house.robber;

import java.util.*;

/**
 * 198-house-robber
 */
class Solution {
    public int rob(int[] nums) {
        var maxSumForIdx = new int[nums.length];
        Arrays.fill(maxSumForIdx, -1);
        return Math.max(countMoney(0, 0, nums, maxSumForIdx), countMoney(1, 0, nums, maxSumForIdx));
    }

    private int countMoney(int idx, int currentSum, int[] nums, int[] maxSumForIdx) {
        if(idx >= nums.length) {
            return currentSum;
        }

        var newSum = currentSum + nums[idx];

        if(maxSumForIdx[idx] < newSum) {
            maxSumForIdx[idx] = newSum;

            var resNext = countMoney(idx + 2, newSum, nums, maxSumForIdx);
            var resNext2 = countMoney(idx + 3, newSum, nums, maxSumForIdx);

            return Math.max(resNext, resNext2);
        } else {
            //do not compute further since we have already had better solution for this index
            return maxSumForIdx[idx];
        }
    }

//    Time Limit Exceeded because pretty brute-force
//    public int rob(int[] nums) {
//        return Math.max(countMoney(0, 0, nums), countMoney(1, 0, nums));
//    }
//
//    private int countMoney(int idx, int currentSum, int[] nums) {
//        if(idx >= nums.length) {
//            return currentSum;
//        }
//
//        var newSum = currentSum + nums[idx];
//
//        var resNext = countMoney(idx + 2, newSum, nums);
//        var resNext2 = countMoney(idx + 3, newSum, nums);
//
//        return Math.max(resNext, resNext2);
//    }
}