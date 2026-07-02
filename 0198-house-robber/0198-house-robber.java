class Solution {
    public int rob(int[] nums) {
        int []dp = new int[nums.length+2];
        Arrays.fill(dp, -1);
        // int ans = robUtil(nums, dp, 0);
        int ans = robUtilTab(nums, dp);
        return ans;
    }
    //memoization
    static int robUtil(int []nums, int[] dp, int idx){
        if(idx == nums.length-1) return nums[idx];
        if(idx > nums.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int skip = robUtil(nums, dp, idx+1);
        int rob = nums[idx] + robUtil(nums, dp, idx+2);

        return dp[idx] = Math.max(skip, rob);
    }
    //tabulation
    static int robUtilTab(int [] nums, int[] dp){
        Arrays.fill(dp, 0);
        for(int i = nums.length-1; i>=0; i--){
            int skip = dp[i+1];
            int rob = nums[i] + dp[i+2];
            dp[i] = Math.max(skip, rob);
        }
        return dp[0];
    }
}