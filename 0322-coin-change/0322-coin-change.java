class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        int ans = f(coins, amount, dp) ;
        return ans== 1000000 ? -1 : ans;
    }
    int f(int[]coins, int amount, int[]dp){
        //dp(amount) -> shows the minimum coints needed to form amount X
        if(amount == 0) return 0;
        if(amount < 0 ) return 1000000;
        if(dp[amount]!= -1) return dp[amount];
        int min = 1000000;
        for(int coin: coins){
        
            int candidate = 1+ f(coins, amount-coin, dp);;
            min = Math.min(min, candidate);
            
        }
        
        return dp[amount] = min;
    }
}