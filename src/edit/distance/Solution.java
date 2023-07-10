package edit.distance;

/**
 * 72. Edit Distance
 */

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] distances = new int[word1.length() + 1][word2.length() + 1];

        for(int i = 0; i < word1.length() + 1; ++i) {
            for(int j = 0; j < word2.length() + 1; ++j) {
                if (i == 0) {
                    distances[i][j] = j;
                    continue;
                }
                if (j == 0) {
                    distances[i][j] = i;
                    continue;
                }
                int removeCnt = distances[i - 1][j] + 1;
                int insertCnt = distances[i][j - 1] + 1;
                int replaceCnt = distances[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);
                distances[i][j] = Math.min(removeCnt, Math.min(insertCnt, replaceCnt));
            }


        }
        return distances[word1.length()][word2.length()];
    }
}