package com.saltuk.triangle;

import java.util.*;

/**
 * 120. Triangle
 */

//Top-Down DP with Memoization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        var memo = new ArrayList<Map<Integer, Integer>>();
        for(int i = 0; i < triangle.size(); ++i) {
            memo.add(new HashMap<>());
        }

        return countSum(triangle, 0, 0, 0, memo);
    }

    private int countSum(List<List<Integer>> triangle, int level, int idx, int currentSum, List<Map<Integer, Integer>> memo) {
        if (memo.get(level).get(idx) != null && currentSum >= memo.get(level).get(idx) ) {
            return Integer.MAX_VALUE;
        }
        memo.get(level).put(idx, currentSum);
        var newSum = triangle.get(level).get(idx) + currentSum;

        if(level + 1 < triangle.size()) {
            var left = countSum(triangle, level + 1, idx, newSum, memo);
            var right = countSum(triangle, level + 1, idx + 1, newSum, memo);

            return Math.min(left, right);
        } else {
            return newSum;
        }
    }
}
