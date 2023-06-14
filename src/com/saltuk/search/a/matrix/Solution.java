package com.saltuk.search.a.matrix;

/**
 * 74-search-a-matrix
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int height = matrix.length;
        int width = matrix[0].length;

        int left = 0;
        int right = height * width;
        int middle = -1;

        while(left < right) {
            middle = (left + right) / 2;

            int value = getValueOnPlace(matrix, width, middle);

            if(value == target) {
                return true;
            }
            if (target < value) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return false;
    }

    private int getValueOnPlace(int[][] matrix, int width, int place) {
        int i = place / width;
        int j = place % width;

        return matrix[i][j];
    }
}