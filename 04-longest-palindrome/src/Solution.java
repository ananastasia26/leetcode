public class Solution {

    public String longestPalindrome(String s) {
        var maxPalindrome = s.substring(0, 1);

        for(int i = 1; i < s.length(); ++i) {

            var evenPalindrome = "";
            if(s.charAt(i - 1) == s.charAt(i)) {
                evenPalindrome = findPalindrome(s, i - 1, i);
            }

            var oddPalindrome =  findPalindrome(s, i - 1, i + 1);

            if (evenPalindrome.length() > maxPalindrome.length()) {
                maxPalindrome = evenPalindrome;
            }
            if(oddPalindrome.length() > maxPalindrome.length()) {
                maxPalindrome = oddPalindrome;
            }
        }

        return maxPalindrome;
    }

    public static void main(String[] args) {
        var s = new Solution();
        var p1 = s.longestPalindrome("babad");
        var p2 = s.longestPalindrome("cbbd");
        var p3 = s.longestPalindrome("a");
        var p4 = s.longestPalindrome("ac");
        var p5 = s.longestPalindrome("cccc");
        var p6 = s.longestPalindrome("qwee");
        var p7 = s.longestPalindrome("qqwe");

        System.out.println(p1 + " " + p2 + " " + p3 + " " + p4 + " " + p5 + " " + p6 + " " + p7);
    }

    private String findPalindrome(String str, int leftIdx, int rightIdx) {
        while(leftIdx >= 0 && rightIdx < str.length()) {
            if(str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            --leftIdx;
            ++rightIdx;
        }

        return str.substring(leftIdx + 1, rightIdx);
    }
}
