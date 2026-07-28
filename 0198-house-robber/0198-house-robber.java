class Solution {
    public int rob(int[] nums) {
        int sum=0;
        for(int i:nums) sum+=i;
        int[]dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return f(nums, nums.length-1, dp);
    }
    int f(int[] nums, int idx,  int[] dp){
        //dp[i]-> max amount of money from house i
        if(idx<0)
            return 0;
        if(idx==0)
            return nums[0];
        if(dp[idx]!=-1) return dp[idx];

        int notpick = f(nums, idx-1,  dp);
        int pick = nums[idx]+f(nums, idx-2,  dp);
        return dp[idx]=Math.max(pick, notpick);
    }
}