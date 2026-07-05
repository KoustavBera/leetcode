class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return helper(nums, dp, nums.length-1);
    }
    int helper(int [] nums, int[] dp, int n){
        if(n<0) return 0;
        if(dp[n] != -1){
            return dp[n];
        }
        int rob = nums[n] + helper(nums, dp, n-2);
        int skip = helper(nums, dp, n-1);

        return dp[n]=Math.max(rob, skip);


    }
}