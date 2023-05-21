class Solution {
    public int maxSubArray(int[] nums) {
        var maxSum = nums[0];
        var currentSum = 0;

        for(int i = 0; i < nums.length; ++i) {
            var element = nums[i];

            if(currentSum < 0 && element > 0) {
                currentSum = element;
            } else {
                currentSum += element;
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
        }

        return currentSum;
    }
}