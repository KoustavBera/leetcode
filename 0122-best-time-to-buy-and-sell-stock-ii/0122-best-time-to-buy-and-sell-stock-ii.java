class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int netProfit = 0;
        for(int i=1; i<n; i++){
            if(prices[i-1]>prices[i]) continue;
            else{
                netProfit += prices[i] - prices[i-1];
            }
        }
        return netProfit ;     }
}