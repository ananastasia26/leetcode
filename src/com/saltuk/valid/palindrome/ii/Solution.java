package com.saltuk.valid.palindrome.ii;

/**
 * 680. Valid Palindrome II
 */
class Solution {
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length() - 1, true);
    }

    private boolean check(String str, int left, int right, boolean canRemove) {
        if (left >= right) {
            return true;
        }

        if(str.charAt(left) == str.charAt(right)) {
            return check(str, left + 1, right - 1, canRemove);
        }

        if (!canRemove) {
            return false;
        }

        var removeLeft = check(str, left + 1, right, false);
        var removeRight = check(str, left, right - 1, false);

        return removeLeft || removeRight;

    }
}