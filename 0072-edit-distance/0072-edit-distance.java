class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int[] rows: dp) Arrays.fill(rows, -1);
        return f(word1, word2, word1.length(), word2.length(), dp);
        // return f2(word1, word2, 0, 0);
    }
    int f(String word1, String word2, int i, int j, int[][] dp){
        if(i<0) return j ;
        if(j<0) return i;
        if(dp[i][j]!=-1) return dp[i][j];

        int ans = 0;
        //recurse
        if(i>0 && j>0 && word1.charAt(i-1) == word2.charAt(j-1)){
            ans = f(word1, word2, i-1, j-1,dp);
        }
        else{
            ans = 1 + Math.min(
                f(word1, word2, i-1, j,dp),
                Math.min(
                f(word1, word2, i, j-1,dp),
                f(word1, word2, i-1, j-1,dp)
                )
            );
        }
        return dp[i][j] = ans;
    }
}