class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length+1];
        for(int[] rows : dp) Arrays.fill(rows, -1);
        return f(nums, nums.length-1, -1, dp);
    }
    int f(int[]nums, int idx, int prev,  int[][]dp){
        if(idx<0) return 0;
        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];

        int notPick = f(nums, idx-1, prev, dp);
        int pick=0;
        if(prev==-1 || nums[idx]<nums[prev])
        pick = 1+ f(nums, idx-1, idx, dp);

        return dp[idx][prev+1] = Math.max(pick, notPick);
    }
}