class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int middle = -1;

        while (left < right) {
            middle = (left + right) / 2;

            var leftValue = nums[left];
            var middleValue = nums[middle];
            var rightValue = nums[right - 1];

            if (middleValue == target) {
                return middle;
            }

            if(middleValue > target) {
                if (middleValue < rightValue) {
                    right = middle;
                } else {
                    if (leftValue > target) {
                        left = middle + 1;
                    } else {
                        right = middle;
                    }
                }
            } else {
                if (middleValue > leftValue) {
                    left = middle + 1;
                } else {
                    if (leftValue > target) {
                        left = middle + 1;
                    } else {
                        right = middle;
                    }
                }
            }
        }

        return -1;
    }
}