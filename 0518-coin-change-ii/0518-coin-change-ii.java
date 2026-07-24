class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];//dp state -> 
        //represents the number of unique ways to create amount,
        //using coins from idx to length
        for(int i=0; i<dp.length; i++)
            Arrays.fill(dp[i], -1);
        int ans =  f(coins,0, amount, dp);
        return ans;
    }
    //lets assume f(coins, amount, dp) -> returns the number of comb -> amount
    int f(int[] coins,int idx, int amount,int[][] dp){
         if(amount==0) return 1;
        if(idx == coins.length) return 0;
       
        if(dp[idx][amount]!=-1) return dp[idx][amount]; 
        int ways = 0;
        int notTake = f(coins, idx+1, amount, dp);
        int take = 0;
        if(amount>=coins[idx]){
            take = f(coins, idx, amount-coins[idx], dp);
        }
        return dp[idx][amount] = take + notTake;
    }
}