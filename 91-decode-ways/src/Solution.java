import java.util.*;

class Solution {
    public int numDecodings(String s) {
        var sums = new int[s.length() + 1];

        var sumLast = getSumForLast(s);
        sums[sums.length - 1] = sumLast;

        var i = s.length() - 1;
        while(i >= 0) {
            var digit = s.charAt(i);
            if(digit == '0') {
                sums[i] = 0;
            } else if ((digit == '1' || digit == '2') && canSplit(s, i)) {
                sums[i] = sums[i + 1] + sums[i + 2];
            } else {
                sums[i] = sums[i + 1];
            }
            i--;
        }

        return sums[0];

    }

    private boolean canSplit(String s, int idx) {
        if (idx + 1 >= s.length()) {
            return false;
        }

        if(s.charAt(idx) == '1') {
            return true;
        }

        if (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7') {
            return true;
        }

        return false;

    }

    private int getSumForLast(String s) {
        var lastChar = s.charAt(s.length() - 1);
        if (lastChar != '0') {
            return 1;
        }

        var beforeLastIdx = s.length() - 2;

        if (beforeLastIdx < 0) {
            return 0;
        }

        var prevLastChar = s.charAt(beforeLastIdx);

        if (prevLastChar == '1' || prevLastChar == '2') {
            return 1;
        }

        return 0;
    }
}