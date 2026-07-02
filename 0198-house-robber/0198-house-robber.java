class Solution {
    public int rob(int[] nums) {
        int []dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        int ans = robUtil(nums, dp, 0);
        return ans;
    }
    static int robUtil(int []nums, int[] dp, int idx){
        if(idx == nums.length-1) return nums[idx];
        if(idx > nums.length-1) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int skip = robUtil(nums, dp, idx+1);
        int rob = nums[idx] + robUtil(nums, dp, idx+2);

        return dp[idx] = Math.max(skip, rob);
    }
}