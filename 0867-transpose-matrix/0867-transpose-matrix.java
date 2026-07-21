class Solution {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;//2
        int n = matrix[0].length;//3
/**
[[1,2,3],
 [4,5,6],
 [7,8,9]]

[[1,4,7],
 [4,5,8],
[ 7,8,9]]

[[1,2,3],
 [4,5,6]]


 [[1,4],
  [2,5],
  [3,6]]
 */
        int[][] ans = new int[n][m];//3*2
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                   ans[i][j] = matrix[j][i];
                
            }
        }
        return ans;
    }
}