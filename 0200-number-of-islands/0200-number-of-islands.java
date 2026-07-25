class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int isIsland = 0;

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c]=='1'){
                    //we are in helicopter and we detected island
                    isIsland++;
                    //island detected, explore all its adjacent and sink the islands
                    dfs(grid, r, c, rows, cols);
                }
            }
        }
        return isIsland;
    }
    void dfs(char[][]grid, int r, int c, int rows, int cols){
        //Base case : if we are out of boundary ->
        //r<0 || c<0 || r>=rows || c>=cols
        if(r<0||c<0 || r >=rows || c>=cols) return;
        if(grid[r][c]=='0') return;
        //sink the island
        grid[r][c] = '0';

        //explore all paths
        dfs(grid, r-1, c, rows, cols);//up
        dfs(grid, r+1, c, rows, cols);//down
        dfs(grid, r, c-1, rows, cols);//left
        dfs(grid, r, c+1, rows, cols);//right
    }
}