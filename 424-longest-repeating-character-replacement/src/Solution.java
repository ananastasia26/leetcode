import java.util.*;

class Solution {
    public int characterReplacement(String s, int k) {
        int[] stat = new int[26];

        var startIdx = 0;
        var maxRepeatableLetterCount = 0;
        var maxLength = 0;

        for(int i = 0; i < s.length(); ++i) {
            var letter = s.charAt(i);
            int letterIdx = letter - 'A';
            stat[letterIdx]++;
            maxRepeatableLetterCount = Math.max(maxRepeatableLetterCount, stat[letterIdx]);

            if(i - startIdx + 1 - maxRepeatableLetterCount > k) {
                int startLetterIdx = s.charAt(startIdx) - 'A';
                stat[startLetterIdx]--;
                maxRepeatableLetterCount = Arrays.stream(stat).max().getAsInt();
                startIdx++;
            }
            maxLength = Math.max(maxLength, i - startIdx + 1);
        }
        return maxLength;
    }
}