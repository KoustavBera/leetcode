class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;

int n = grid[0].length;

int[][]dp =new int[m][n];

for(int i=0; i<m; i++){

Arrays.fill(dp[i], -1);

}
return f(grid, m-1, n-1, dp, 0);
    }
    int f(int[][]grid, int i, int j, int[][] dp, int ans){
        if(i==0 && j==0) return grid[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE; 
        if(dp[i][j] != -1) return dp[i][j];

        int up = f(grid, i-1, j, dp, ans);
        int left = f(grid, i, j-1, dp , ans);

        ans +=  (int) Math.min(up, left) + grid[i][j];
        return dp[i][j] = ans;
    }
}