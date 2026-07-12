class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][]dp =new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], -1);
        }
        // return f(grid, m-1, n-1, dp);
        return f2(grid, m, n);
    }
    int f(int[][]grid, int i, int j, int[][] dp){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE; 
        if(dp[i][j] != -1) return dp[i][j];

        int up = f(grid, i-1, j, dp);
        int left = f(grid, i, j-1, dp);

        return dp[i][j] = Math.min(up, left) + grid[i][j];
    }
        int f2(int[][]grid, int m, int n){
            int dp[][] = new int[m][n];
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(i==0 && j==0) dp[i][j] = grid[0][0];
                    else{
                        int up= Integer.MAX_VALUE, left =  Integer.MAX_VALUE;
                        if(i>0) up =  dp[i-1][j];
                        if(j>0) left = dp[i][j-1];
                        dp[i][j] = Math.min(up, left) + grid[i][j];
                    }
                }
            }   
            return dp[m-1][n-1];
    }
}