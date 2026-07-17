class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int i = triangle.size();
        int j = triangle.get(i-1).size();
        int[][] dp = new int[i][j];
        for(int s=0; s<i; s++){
        Arrays.fill(dp[s], Integer.MAX_VALUE);
        }
        // return f(triangle, 0, 0, i,  dp);
        //tabulation
        // return f2(triangle);
        return f3(triangle);

    }
    int f(List<List<Integer>>  triangle,int i, int j, int n, int[][]dp){
        //base case : if i am in n-1 row return 
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!= Integer.MAX_VALUE) return dp[i][j];

        int d = triangle.get(i).get(j) + f(triangle, i+1, j, n, dp);
        int dg = triangle.get(i).get(j) + f(triangle, i+1, j+1, n, dp);

        return dp[i][j] = Math.min(d, dg);
    }

    int f2(List<List<Integer>>  triangle){
        int n = triangle.size();
        int[][] dp = new int[n][triangle.get(n-1).size()];
        for(int i=0; i<triangle.get(n-1).size(); i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }
        for(int i=triangle.size()-2; i>=0; i--){
            for(int j=i; j>=0; j--){
               int d = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(d, dg);
            }
        }
        return dp[0][0];
    }

 int f3(List<List<Integer>>  triangle){
        int n = triangle.size();
        int[] future = new int[n];
        for(int i=0; i<triangle.get(n-1).size(); i++){
            future[i] = triangle.get(n-1).get(i);
        }
        for(int i=triangle.size()-2; i>=0; i--){
            int[] curr = new int[n];
            for(int j=i; j>=0; j--){
               int d = triangle.get(i).get(j) + future[j];
                int dg = triangle.get(i).get(j) + future[j+1];
                curr[j] = Math.min(d, dg);
            }
            future = curr;
        }
        return future[0];
    }
}