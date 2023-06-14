package com.saltuk.container.with.most.water;

/**
 * 11-container-with-most-water
 */
class Solution {
    public int maxArea(int[] height) {
        var leftIdx = 0;
        var rightIdx = height.length - 1;

        var maxRes = 0;

        while(leftIdx < rightIdx) {
            var h = Math.min(height[leftIdx], height[rightIdx]);
            maxRes = Math.max(maxRes, h * (rightIdx - leftIdx));
            if (height[leftIdx] < height[rightIdx]) {
                leftIdx += 1;
            } else {
                rightIdx -= 1;
            }
        }
        return maxRes;
    }

    public static void main(String[] args) {
        var s = new Solution();
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(s.maxArea(heights));

        heights = new int[]{1, 1};
        System.out.println(s.maxArea(heights));

        heights = new int[]{4,3,2,1,4};
        System.out.println(s.maxArea(heights));

        heights = new int[]{1, 2, 1};
        System.out.println(s.maxArea(heights));

        heights = new int[]{1, 2, 4, 3};
        System.out.println(s.maxArea(heights));

        heights = new int[]{2, 3, 10, 5, 7, 8, 9};
        System.out.println(s.maxArea(heights));
    }
}