package com.saltuk.reverse.intgr.v2;

/**
 * 07-reverse-int
 */
class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        var sign = x < 0 ? -1 : 1;
        var a = Math.abs(x);
        var res = 0;
        var maxFactor = 9;
        for (int i = 0; a > 0; ++i) {
            var digit = a % 10;
            if (i == maxFactor && isOverflow(res, digit, sign)) {
                return 0;
            }

            res = res * 10 + digit;

            a = a / 10;
        }

        return sign * res;
    }

    private boolean isOverflow(int currentRes, int digit, int sign) {
        if (currentRes > Integer.MAX_VALUE / 10) {
            return true;
        }
        var maxDigit = sign > 0 ? 7 : 8;
        return digit > maxDigit;
    }
}