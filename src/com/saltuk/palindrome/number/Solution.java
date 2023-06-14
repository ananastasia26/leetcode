package com.saltuk.palindrome.number;

/**
 * 09-palindrome-number
 */
class Solution {
    public boolean isPalindrome(int x) {
        var s = String.valueOf(x);

        for(var i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.isPalindrome(123));
        System.out.println(s.isPalindrome(121));
        System.out.println(s.isPalindrome(-121));
        System.out.println(s.isPalindrome(0));
        System.out.println(s.isPalindrome(10));
    }
}