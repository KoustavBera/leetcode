class Solution {
    public void rotate(int[][] matrix) {
        //Solution: Transpose + Reverse
        //Transpose
        /**
        [[1 2 3]
         [4 5 6]
         [7 8 9]]
         becomes
        [[1 4 7]
         [2 5 8]
         [3 6 9]]

         then simply reverse each row
        [[7 4 1]
         [8 5 2]
         [9 6 3]]

         */

         //Transpose
         int m = matrix.length;
         int n = matrix[0].length;
         for(int i=0; i<m; i++){
            for(int j=i+1; j<n; j++){
                swap(matrix, i, j);
            }
         }

         //reverse rows
         for(int i=0; i<m; i++){
            int left = 0, right = n-1;
            reverse(matrix[i], left, right);
         }

    }
    void swap(int[][] matrix, int i, int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    void reverse(int[] matrix, int l, int r)
    {
        while(l < r){
            int temp = matrix[l];
            matrix[l] = matrix[r];
            matrix[r] = temp;
            l++;
            r--;
        }
    }
}