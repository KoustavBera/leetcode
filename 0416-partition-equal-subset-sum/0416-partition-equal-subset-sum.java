class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int num: nums){
            target += num;
        }
        if((target&1) == 1) return false;
        target = target/2;
        Boolean[][] dp = new Boolean[nums.length][target+1];
        return f(nums, nums.length-1, target, dp);
    }
    boolean f(int[] nums,int idx,int target,Boolean[][] dp){
        if(target == 0) return true;
        if(idx == 0) return nums[0] == target;
        if(dp[idx][target] != null) return dp[idx][target];

        boolean keep_in_subset = f(nums, idx-1, target, dp);
        boolean not_keep = false;
        if(nums[idx] <= target){
            not_keep = f(nums, idx-1, target-nums[idx], dp);
        }

        return dp[idx][target] = not_keep || keep_in_subset;
    }
}