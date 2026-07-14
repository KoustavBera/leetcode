class Solution {
    public int maxProfit(int[] prices) {
        int mx = 0;
        // for(int i=0; i<prices.length; i++){
        //     for(int j=i+1; j<prices.length; j++){
        //         int diff = prices[j] - prices[i];
        //         mx = Math.max(mx, diff);
        //     }
        // }
        // return mx;
        int n = prices.length;
        int minPointer = 0;
        int maxPointer = 0;
        int mxd = 0;
        for(int i=0; i<n; i++){
            if(prices[i] < prices[minPointer]) minPointer = i;
            mxd = Math.max(mxd, prices[i]-prices[minPointer]);
        }
        return mxd;
    }
}