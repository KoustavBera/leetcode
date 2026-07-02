class Solution {
    public int rob(int[] nums) {
       int []dp = new int[nums.length+2];
        Arrays.fill(dp, -1);
        if(nums.length<2)
         return nums[0];
        int firstHouseRobbed = robUtil(nums, dp, 0, nums.length-2);

        Arrays.fill(dp, -1);
        int firstHouseNotRobbed = robUtil(nums, dp, 1, nums.length-1);
        return Math.max(firstHouseRobbed, firstHouseNotRobbed);
    }
    //memoization
    static int robUtil(int []nums, int[] dp, int idx, int end){
        if(idx == end) return nums[idx];
        if(idx > end) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int skip = robUtil(nums, dp, idx+1, end);
        int rob = nums[idx] + robUtil(nums, dp, idx+2, end);

        return dp[idx] = Math.max(skip, rob);
    }
}