import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        var letterToMinIdx = new HashMap<Character, Integer>();
        for(var i = 0; i < s.length(); ++i) {
            var letter = s.charAt(i);
            letterToMinIdx.putIfAbsent(letter, i);
        }
        var res = new ArrayList<Integer>();
        var minSubStrIdx = letterToMinIdx.get(s.charAt(s.length() - 1));
        var prevPartitionStart = s.length();

        for(var i = s.length() - 1; i >= 0; --i) {

            if(i < minSubStrIdx) {
                var partitionStart = i + 1;
                res.add(prevPartitionStart - partitionStart);
                prevPartitionStart = partitionStart;
            }

            var letter = s.charAt(i);
            var currentLetterMin = letterToMinIdx.get(letter);
            minSubStrIdx = Math.min(currentLetterMin, minSubStrIdx);
        }
        res.add(prevPartitionStart);

        for (int i = 0; i < res.size() / 2; ++i) {
            var pairIdx = res.size() - 1 - i;
            var temp = res.get(i);
            res.set(i, res.get(pairIdx));
            res.set(pairIdx, temp);
        }

        return res;
    }
}