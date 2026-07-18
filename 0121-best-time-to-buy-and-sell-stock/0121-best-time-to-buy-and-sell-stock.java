class Solution {
    public int maxProfit(int[] prices) {
        // int mx = Integer.MIN_VALUE;
        // int n = prices.length;
        // int s = 0;
        // for(int i=1; i<n; i++){
        //     int dif = prices[i] - prices[i-1];
        //     s += dif;
        //     mx = Math.max(mx, s);
        //     if(s<0) s=0;
        // }
        // return mx<0 ? 0 : mx;

        // or

        int minPrice = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }
        return profit; 
    }
}