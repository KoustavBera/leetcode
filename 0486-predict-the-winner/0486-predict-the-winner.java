class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][]dp = new int[nums.length+1][nums.length+1];
        for(int[] rows : dp) Arrays.fill(rows, -1);
        //we hope our rec will give curr - f(next) situation
        return f(nums, 0, nums.length-1, dp) >= 0;
    }
    int f(int nums[], int l, int r, int[][]dp){
     //if only one element then just return it
        if(l == r) return nums[l];
        if(dp[l][r] != -1) return dp[l][r];

        //at each stage we branch into two decisions
        //either pick left or pick right
        //which ever we pick we take curr - f() where f() represents our
        //opponent
        //and we take the max
        //if after all rec, the return is +ve, then player 1 wins or else
        //player 2 wins.

        return dp[l][r] = Math.max(
            nums[l] - f(nums, l+1, r, dp),
            nums[r] - f(nums, l, r-1, dp)
        );

    }
}