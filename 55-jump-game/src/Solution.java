class Solution {
    public boolean canJump(int[] nums) {
        var maxReachableStep = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i <= maxReachableStep) {
                var currentMaxReachableStep = i + nums[i];

                if(currentMaxReachableStep >= nums.length - 1) {
                    return true;
                }
                maxReachableStep = Math.max(maxReachableStep, currentMaxReachableStep);
            }
        }
        return false;
    }
}