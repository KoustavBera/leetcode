class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return f1(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1); //--> Recursion

        //<--------- Memo -------------->
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][]dp =new int[m][n];
        for(int i=0; i<m; i++){
        Arrays.fill(dp[i], -1);
        }
        return f2(obstacleGrid, m-1, n-1, dp);

    }
    //Using simple recursion
    int f1(int[][] arr, int m, int n){
        if(m==0 && n==0 && arr[m][n]==1) return 0;
        if(m==0 && n==0 && arr[m][n]==0) return 1;
        if(m<0 || n<0) return 0;
        if(arr[m][n]==1) return 0;
        int up = f1(arr, m-1, n);
        int left = f1(arr, m, n-1);
        return up+left;
    }


    //memoization
        int f2(int[][] arr, int m, int n, int[][]dp){
        if(m==0 && n==0 && arr[m][n]==1) return 0;
        if(m==0 && n==0 && arr[m][n]==0) return 1;
        if(m<0 || n<0) return 0;
        if(arr[m][n]==1) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int up = f2(arr, m-1, n,dp);
        int left = f2(arr, m, n-1,dp);
        return dp[m][n] = up+left;
    }
}