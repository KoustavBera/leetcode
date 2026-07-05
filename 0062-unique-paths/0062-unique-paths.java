class Solution {
    public int uniquePaths(int m, int n) {
        // return f(m-1,n-1); --> simple recursion(TLE)
        int[][]dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        return f2(m-1, n-1, dp);
    }
    //simple recursion
    int f(int m, int n)
    {
        //base case
        if(m==0 && n==0) return 1;
        //exceeds boundary
        if(m<0 || n<0) return 0;
        //up means row-1
        int up = f(m-1,n);
        //left means col-1
        int left = f(m, n-1);
        //matrix[1][1]=up+left
        return up+left;
    }

    //memoization
     int f2(int m, int n, int[][]dp)
    {
        //base case
        if(m==0 && n==0) return 1;
        //exceeds boundary
        if(m<0 || n<0) return 0;
        //dp base case
        if(dp[m][n]!=-1) return dp[m][n];
        //up means row-1
        int up = f2(m-1,n, dp);
        //left means col-1
        int left = f2(m, n-1, dp);
        //matrix[1][1]=up+left
        return dp[m][n] = up+left;
    }

}