package com.saltuk.container.with.most.water.v2;

/**
 * 11-container-with-most-water
 */
class Solution {
    public int maxArea(int[] height) {
        var leftIndex = 0;
        var rightIndex = height.length - 1;
        var maxWater = 0;

        while (leftIndex < rightIndex) {
            var leftHeight = height[leftIndex];
            var rightHeight = height[rightIndex];

            var currentWater = Math.min(leftHeight, rightHeight) * (rightIndex - leftIndex);
            if (currentWater > maxWater) {
                maxWater = currentWater;
            }
            if (leftHeight < rightHeight) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return maxWater;
    }
}