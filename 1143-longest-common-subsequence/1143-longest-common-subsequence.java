class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][]dp = new int[text1.length()+1][text2.length()+1];
        for(int[] row : dp) Arrays.fill(row, -1);
       return f(text1, text2, text1.length()-1, text2.length()-1, dp);
    }
    int f(String text1, String text2,int i, int j, int[][] dp){
        if(i<0 || j<0) return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) return 1 + f(text1, text2, i-1, j-1, dp);
        return dp[i][j] = Math.max(f(text1, text2, i-1, j,dp), f(text1, text2, i, j-1, dp));

    }
    int f2(String text1, String text2){
         int m =text1.length();
        int n = text2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); //pick the better choice
                }
            }
        }
        int lcs = dp[m][n];
        return lcs;
    }
}