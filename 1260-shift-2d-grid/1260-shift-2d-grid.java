class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for(int l=1; l<=k; l++){
        int last = grid[m-1][n-1];
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(j>0)
                grid[i][j] = grid[i][j-1];
                else{
                    if(i!=0)
                    grid[i][j] = grid[i-1][j+n-1];
                }
            }
        }
        grid[0][0] = last;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<m; i++){
            List<Integer> mini = new ArrayList<>();
            for(int j=0; j<n; j++){
                mini.add(grid[i][j]);
            }
            ans.add(mini);
        }
        return ans;
    }
}