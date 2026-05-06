class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = nums[0];
        for(int i = 0; i < nums.length; i++){
            dp[i] = nums[i];
        }

        for(int j = 1; j < nums.length; j++){
            dp[j] = Math.max(nums[j], dp[j-1]+nums[j]);
            res = Math.max(dp[j], res);
        }

        return res;


    }
}
