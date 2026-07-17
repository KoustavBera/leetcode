class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int i = triangle.size();
        int j = triangle.get(i-1).size();
        int[][] dp = new int[i][j];
        for(int s=0; s<i; s++){
        Arrays.fill(dp[s], Integer.MAX_VALUE);
        }
        return f(triangle, 0, 0, i,  dp);
    }
    int f(List<List<Integer>>  triangle,int i, int j, int n, int[][]dp){
        //base case : if i am in n-1 row return 
        if(i==n-1) return triangle.get(i).get(j);
        if(dp[i][j]!= Integer.MAX_VALUE) return dp[i][j];

        int d = triangle.get(i).get(j) + f(triangle, i+1, j, n, dp);
        int dg = triangle.get(i).get(j) + f(triangle, i+1, j+1, n, dp);

        return dp[i][j] = Math.min(d, dg);
    }

}