class Solution {
    public int uniquePaths(int m, int n) {
        // return f(m-1,n-1); --> simple recursion(TLE)
       
       
        // int[][]dp = new int[m][n]; --> Memoization
        // for(int i=0; i<m; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return f2(m-1, n-1, dp);
        
        // return f3(m, n); --> tabulation

        return f4(m, n); //--> space optimised


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


    //tabulation 
    int f3(int m, int n){
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) dp[0][0]=1;
                else{
                    int up=  0, down = 0;
                    if(i>0) 
                    up = dp[i-1][j];
                    if(j>0)
                    down = dp[i][j-1];
                    dp[i][j]=up+down;
                }
            }
        }
        return dp[m-1][n-1];
    }

    // space optimised
    int f4(int m, int n){
        int[] prev = new int[n];
        Arrays.fill(prev, 1);
        for(int i=0; i<m; i++){
            int[] cur = new int[n];
            for(int j=0; j<n; j++){
                if(i==0 && j==0) cur[j]=1;
                else{
                    int up=0, down = 0;
                    if(i>0) 
                    up = prev[j];
                    if(j>0)
                    down = cur[j-1];
                    cur[j]=up+down;
                }
            }
            prev = cur;
        }
        return prev[n-1];
    }
}
        
    


