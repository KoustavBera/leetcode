class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return f2(str1, str2);
    }
     String f2(String text1, String text2){
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
        StringBuilder ans = new StringBuilder();
        int i=m, j=n;
        while(i>0 && j>0){
            if(dp[i-1][j] == dp[i][j-1] && text1.charAt(i-1) == text2.charAt(j-1)){
                ans.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                /*      2
                        ^
                        |
                  1<---[2]
                */
                //thinking.... 
                // we should go up and add 1 to ans
                ans.append(text1.charAt(i-1));
                i = i - 1;
            }
            else{
                ans.append(text2.charAt(j-1));
                j = j - 1;
            }
        }

        while(i-- >0) ans.append(text1.charAt(i));
        while(j-- >0) ans.append(text2.charAt(j));

        return ans.reverse().toString();

    }
}