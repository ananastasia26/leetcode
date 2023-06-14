package com.saltuk.single.number;

/**
 * 136-single-number
 */
class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}