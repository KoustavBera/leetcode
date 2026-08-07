class Solution {
    public int minInsertions(String s) {
        StringBuilder rev = new StringBuilder(s);
        String s2 = rev.reverse().toString();
        int longestPalindrome = lcs(s, s2);
        // if we know the longest palindrome,
        //the min ops would be to just pick the seq
        //of non palindromic subs, reverse them and insert them 
        //at desired positions
        return s.length() - longestPalindrome;
    }

    int lcs(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) 
                dp[i][j] = 1 + dp[i-1][j-1];
                else
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[m][n];
    }
}