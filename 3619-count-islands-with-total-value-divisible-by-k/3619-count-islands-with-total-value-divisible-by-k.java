class Solution {
    public int countIslands(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Tracks which land cells we have already included in an island sum
        boolean[][] visited = new boolean[rows][cols];
        int divisibleIslandCount = 0;

        //initialise direction arrays
        int[] dr = {-1, 1, 0, 0}; //dr->delta rows, u can go {up, down}
        int[] dc = {0, 0, -1, 1}; //dr->delta cols, u can go {left, right}
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j]>0 && !visited[i][j]){
                    long sum = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    
                    //Initialise BFS for this island
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    
                    while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        int r = curr[0];
                        int c = curr[1];

                        //Since current is a valid island cell add it to sum
                        sum += grid[r][c];
                        //Next explore all neighbors in 4 directions
                        for(int d=0; d<4; d++){
                            int new_r = r + dr[d];
                            int new_c = c + dc[d];

                            if(new_r>=0 && new_r < rows && new_c>=0 && new_c<cols && grid[new_r][new_c]>0 && !visited[new_r][new_c]){
                                //neighbor is also not visited
                                queue.offer(new int[]{new_r, new_c});
                                visited[new_r][new_c] = true;
                            }
                        }
                    }
                    if(sum %k==0){
                        divisibleIslandCount++;
                    }
                }
            }
        }
        return divisibleIslandCount;
    }
}