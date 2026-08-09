class Solution {
    public int numDistinct(String s, String t) {
        int[][]dp = new int[s.length()+1][t.length()+1];
        for(int[] row:dp) Arrays.fill(row, -1);
        return f2(s,t, s.length()-1, t.length()-1, dp);
    }
    //normal rec
    int f(String s, String t, int i, int j){
        if(j<0) return 1;
        if(i<0) return 0;

        if(s.charAt(i) == t.charAt(j)){
            return  f(s, t, i-1, j-1) + f(s, t, i-1, j);
        }
        else{
            return f(s,t, i-1, j);
        }

    }
    //Tabulation
    int f2(String s, String t, int i, int j, int [][]dp){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return  dp[i][j] = f2(s, t, i-1, j-1, dp) + f2(s, t, i-1, j, dp);
        }
        else{
            return dp[i][j] = f2(s,t, i-1, j,dp);
        }

    }
}