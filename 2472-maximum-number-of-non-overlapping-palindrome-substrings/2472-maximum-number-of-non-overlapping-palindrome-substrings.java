class Solution {
    public int maxPalindromes(String s, int k) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        // palindrome[i][j] tells whether s[i...j] is a palindrome.
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        // Build the palindrome table.
        for (int i = s.length() - 1; i >= 0; i--) {

            for (int j = i; j < s.length(); j++) {

                if (s.charAt(i) == s.charAt(j)
                        && (j - i <= 1 || isPalindrome[i + 1][j - 1])) {

                    isPalindrome[i][j] = true;
                }
            }
        }
        for(int rows[] : dp){
            Arrays.fill(rows, -1);
        }
        return f(s, k, 0, 0, dp, isPalindrome);
    }
    int f(String s, int k, int i, int j, int[][]dp, boolean[][] isPalindrome){
        if(i >= s.length() || j >= s.length()){
            return 0;
        }

        if(dp[i][j] != -1) 
            return dp[i][j];

        if(j-i+1 >= k && isPalindrome[i][j]){
            //3 options
            //take it
            //since its non overlapping
            int take = 1 + f(s, k, j+1, j+k,dp,isPalindrome);
            int grow = f(s, k, i, j+1,dp,isPalindrome);
            int slide = f(s, k, i+1, j+1,dp,isPalindrome);
            return dp[i][j]=Math.max(take, Math.max(grow, slide));
        }
        int grow = f(s, k, i, j+1,dp,isPalindrome);
        int slide = f(s, k, i+1, j+1,dp,isPalindrome);
        return dp[i][j] = Math.max(grow, slide);
    }
}