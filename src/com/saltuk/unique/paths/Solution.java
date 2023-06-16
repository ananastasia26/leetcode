package com.saltuk.unique.paths;

/**
 * 62. Unique Paths
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[0][0] = 1;

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == 0 && j == 0) {
                    continue;
                }

                var aboveNeighbourValue = i - 1 >= 0 ? memo[i - 1][j] : 0;
                var leftNeighbourValue = j - 1 >= 0 ? memo[i][j - 1] : 0;

                memo[i][j] = aboveNeighbourValue + leftNeighbourValue;
            }
        }

        return memo[m - 1][n - 1];
    }
}
