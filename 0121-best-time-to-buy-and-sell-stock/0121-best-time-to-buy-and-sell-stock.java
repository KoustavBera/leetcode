class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int min = 0;
        for(int i=0; i<n; i++){
            //track the min
            min = (prices[i]<prices[min]) ? i : min;
            //
            int  profit = 0;
            if(min != i){
               profit = prices[i] - prices[min];
            }
            
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}