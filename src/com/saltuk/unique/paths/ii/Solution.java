package com.saltuk.unique.paths.ii;

/**
 * 63. Unique Paths II
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];

        if (obstacleGrid[0][0] == 0) {
            memo[0][0] = 1;
        }

        for(int i = 0; i < obstacleGrid.length; ++i) {
            for (int j = 0; j < obstacleGrid[0].length; ++j) {
                if (i ==0 && j == 0) {
                    continue;
                }
                if(obstacleGrid[i][j] == 1) {
                    memo[i][j] = 0;
                    continue;
                }
                int leftNeightbour = j > 0 ? memo[i][j - 1] : 0;
                int topNeightbour = i > 0 ? memo[i - 1][j] : 0;

                memo[i][j] = leftNeightbour + topNeightbour;
            }
        }

        return memo[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
