class Solution {
    public int closedIsland(int[][] grid) {
        
        // rudimentary
        if(grid==null || grid.length==0) return 0;

        //get rows and column lengths
        int rows = grid.length;
        int columns = grid[0].length;

        //Step 1: Sink all islands connected to the boundary
        //top and bottom rows
        for(int j=0; j<columns; j++){
            // check if part of island connected to top edge
            if(grid[0][j]==0) dfs(grid, 0, j, rows, columns); //if yes, sink all connected neighbours
            if(grid[rows-1][j]==0) dfs(grid, rows-1, j, rows, columns);// sink the bottom similarly
        }
        //left and right edges
        for(int i=0; i<rows; i++){
            //left
            if(grid[i][0]==0) dfs(grid, i, 0, rows, columns);
            //right
            if(grid[i][columns-1]==0) dfs(grid, i, columns-1, rows, columns);
        }

        //Step 2: count all rest islands that are not connected to boundary and then sink them
        int countClosed = 0;
        for(int i=1; i<rows-1; i++){
            for(int j=1; j<columns-1; j++){
                if(grid[i][j]==0){
                    countClosed++;
                    //now once u find a closed island pixel, sink the connected neighbours to discard the counted island so that it is not double counted
                    dfs(grid, i, j, rows, columns);
                }
            }
        }
        return countClosed;
    }

    private static void dfs(int[][]grid, int i, int j, int rows, int cols){
        //base case
        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==1){
            return;
        }
        //Sink the current cell
        grid[i][j]=1;

        //explore all verticals and horizontals
        dfs(grid, i+1, j, rows, cols);
        dfs(grid, i-1, j, rows, cols);
        dfs(grid, i, j+1, rows, cols);
        dfs(grid, i, j-1, rows, cols);
    }

}