class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]dp = new int[nums.length][nums.length+1];
        for(int[] rows : dp) Arrays.fill(rows, -1);
        // return f(nums, nums.length-1, -1, dp);
        return f2(nums);
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
    int f2(int[] nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        for(int i=0; i<n; i++) dp[i] = 1;
        int maxi = 1;
        for(int i=0; i<n; i++){
            for(int prev = 0; prev < i; prev++){
                if(nums[prev] < nums[i]){
                    dp[i] = Math.max(dp[i], 1+dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
        }
}