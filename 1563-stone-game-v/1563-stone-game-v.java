class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];
        for(int i=1; i<n; i++){
            prefixSum[i] =prefixSum[i-1] + stoneValue[i];
        }
        int[][] dp = new int[n+1][n+1];
        for(int[]row: dp) Arrays.fill(row, -1);
        return f(0, n-1, prefixSum, dp);
    }
    int f(int l, int r, int[] prefixSum, int[][]dp){
        int score = 0;
        if(dp[l][r] != -1) return dp[l][r];
        for(int mid = l; mid <r; mid++){
            int leftSum = prefixSum[mid];
            if(l!=0)
            leftSum = prefixSum[mid] - prefixSum[l-1];
            int rightSum = prefixSum[r] - prefixSum[mid];
            //Note out of both sums Bob discards the max
            if(leftSum < rightSum){ //Bob discards right
            score = Math.max(score, leftSum + f(l, mid, prefixSum,dp));
            }
            else if(leftSum > rightSum){     //Bob discards left
                score = Math.max(score, rightSum + f(mid+1, r, prefixSum,dp));
            }else{
                score = Math.max(score,Math.max( leftSum + f(l, mid, prefixSum,dp), rightSum + f(mid+1, r, prefixSum,dp)));
            }
        }
        return dp[l][r] = score;
    }
}