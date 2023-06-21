package com.saltuk.minimum.path.sum;

/**
 * 64. Minimum Path Sum
 */
class Solution {
    public int minPathSum(int[][] grid) {
        var width = grid[0].length;
        var height = grid.length;
        int[][] memo = new int[height][width];

        memo[0][0] = grid[0][0];

        for(int i = 0; i < height; ++i) {
            for(int j = 0; j < width; ++j) {
                if(i == 0 && j == 0) {
                    continue;
                }
                var top = i > 0 ? memo[i - 1][j] + grid[i][j] : Integer.MAX_VALUE;
                var left = j > 0 ? memo[i][j - 1] + grid[i][j] : Integer.MAX_VALUE;

                memo[i][j] = Math.min(top, left);
            }
        }

        return memo[height - 1][width - 1];
    }
}
