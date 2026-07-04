class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper2(n, dp);
    }
    //Memo
    public static int helper(int n, int[] dp){
        if(n==0 || n==1) return 1;
        //noWays(n) = noWays(n-1) + noWays(n-2) since u can climb 1/2 steps at a time
        if(dp[n]!=-1) return dp[n];
        return dp[n] = helper(n-1, dp) + helper(n-2, dp);
    }
    //Tab
    public static int helper2(int n, int[]dp){
        Arrays.fill(dp, 0);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}