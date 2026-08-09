class Solution {
    public int numDistinct(String s, String t) {
        int[][]dp = new int[s.length()+1][t.length()+1];
        for(int[] row:dp) Arrays.fill(row, -1);
        return f3(s,t);
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
    //Memo
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

//     //Tabulation
//         int f3(String s, String t){
//         int[][]dp = new int[s.length()+1][t.length()+1];
//         //here we cant take -1 as a index to check so we will use 1 based indexing
//         // if(j<0) return 1;
//         for(int i=0; i<s.length(); i++){
//             dp[i][0] = 1;
//         }
//         //it becomes
//         for(int i=1; i<=s.length(); i++ ){
//             for(int j=1; j<=t.length(); j++){
//                 if(s.charAt(i-1) == t.charAt(j-1)){
// //  dp[i][j] = f2(s, t, i-1, j-1, dp) + f2(s, t, i-1, j, dp);
//                     dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//                 }
//                 else
//                 dp[i][j] = dp[i-1][j];
//         }
//             }
//         return dp[s.length()][t.length()];
    
//     }
    int f3(String s, String t){
        int[] prev = new int[t.length()+1];
        prev[0] = 1;
        for(int i=1; i<=s.length(); i++ ){
        int[] cur = new int[t.length()+1];
        cur[0]=1;
            for(int j=1; j<=t.length(); j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    cur[j] = prev[j-1] + prev[j];
                }
                else
                cur[j] = prev[j];
        }
        prev = cur;
        }
        return prev[t.length()];
    }

}