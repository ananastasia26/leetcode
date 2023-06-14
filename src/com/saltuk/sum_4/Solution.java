package com.saltuk.sum_4;

import java.util.*;

/**
 * 18-4Sum
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return sumK(nums, 0, 4, target);
    }

    private List<List<Integer>> sumK(int[] nums, int startIdx, int k, long target) {
        var res = new ArrayList<List<Integer>>();

        if(startIdx == nums.length) {
            return res;
        }

        if (k == 2) {
            return sum2(nums, startIdx, target);
        }

        for(int i = startIdx; i < nums.length; ++i) {
            if(i != startIdx && nums[i] == nums[i - 1]) {
                continue;
            }
            for(var subSum : sumK(nums, i + 1, k - 1, target - (long)nums[i])) {
                var newSubSum = new ArrayList<>(subSum);
                newSubSum.add(nums[i]);
                res.add(newSubSum);
            }
        }
        return res;
    }

    private List<List<Integer>> sum2(int[] nums, int startIdx, long target) {
        int leftIdx = startIdx;
        int rightIdx = nums.length - 1;

        var res = new ArrayList<List<Integer>>();

        while (leftIdx < rightIdx) {
            long diff = target - (long)nums[leftIdx] - (long)nums[rightIdx];

            if(diff > 0) {
                leftIdx++;
            } else if (diff < 0) {
                rightIdx--;
            } else if (leftIdx != startIdx && nums[leftIdx - 1] == nums[leftIdx] && rightIdx != nums.length - 1 && nums[rightIdx + 1] == nums[rightIdx]) {
                leftIdx++;
                rightIdx--;
            } else {
                res.add(List.of(nums[leftIdx], nums[rightIdx]));
                leftIdx++;
                rightIdx--;
            }
        }

        return res;

    }
}