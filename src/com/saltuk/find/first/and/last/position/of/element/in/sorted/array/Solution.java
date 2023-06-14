package com.saltuk.find.first.and.last.position.of.element.in.sorted.array;

/**
 * 34-find-first-and-last-position-of-element-in-sorted-array
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurenceIdx = findElementIdx(nums, target);
        if(firstOccurenceIdx == -1) {
            return new int[]{-1 , -1};
        }

        int leftIdx = firstOccurenceIdx;
        while (leftIdx > 0 && nums[leftIdx - 1] == target) {
            --leftIdx;
        }

        int rightIdx = firstOccurenceIdx;
        while (rightIdx < nums.length - 1 && nums[rightIdx + 1] == target) {
            rightIdx++;
        }

        return new int[]{leftIdx, rightIdx};
    }

    private int findElementIdx(int[] nums, int target) {
        int leftIdx = 0;
        int rightIdx = nums.length;

        while(leftIdx < rightIdx) {
            int middleIdx = (leftIdx + rightIdx) / 2;
            int value = nums[middleIdx];
            if (value == target) {
                return middleIdx;
            } else if (target < value) {
                rightIdx = middleIdx;
            } else {
                leftIdx = middleIdx + 1;
            }
        }
        return -1;
    }
}