package com.saltuk.counting.bits;

/**
 * 338. Counting Bits
 */

class Solution {
    public int[] countBits(int n) {
        int[] memo = new int[n + 1];

        for(int i = 0; i < n + 1; ++i) {
            memo[i] = i % 2 + memo[i / 2];
        }

        return memo;
    }
}