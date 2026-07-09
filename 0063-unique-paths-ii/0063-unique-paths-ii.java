class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return f1(obstacleGrid, obstacleGrid.length-1, obstacleGrid[0].length-1); //--> Recursion

        //<--------- Memo -------------->
        // int m = obstacleGrid.length;
        // int n = obstacleGrid[0].length;
        // int[][]dp =new int[m][n];
        // for(int i=0; i<m; i++){
        // Arrays.fill(dp[i], -1);
        // }
        // return f2(obstacleGrid, m-1, n-1, dp);

        //<---------- Tabulation  ------------>

        return f3(obstacleGrid);

    }
    //Using simple recursion
    int f1(int[][] arr, int m, int n){
        if(m==0 && n==0 && arr[m][n]==1) return 0;
        if(m==0 && n==0 && arr[m][n]==0) return 1;
        if(m<0 || n<0) return 0;
        if(arr[m][n]==1) return 0;
        int up = f1(arr, m-1, n);
        int left = f1(arr, m, n-1);
        return up+left;
    }


    //memoization
        int f2(int[][] arr, int m, int n, int[][]dp){
        if(m==0 && n==0 && arr[m][n]==1) return 0;
        if(m==0 && n==0 && arr[m][n]==0) return 1;
        if(m<0 || n<0) return 0;
        if(arr[m][n]==1) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int up = f2(arr, m-1, n,dp);
        int left = f2(arr, m, n-1,dp);
        return dp[m][n] = up+left;
    }

    //tabulation
        int f3(int[][] arr){
            int m = arr.length;
            int n = arr[0].length;

            if(arr[0][0]==1) return 0;
            if(arr[m-1][n-1]==1) return 0;
            
            int[][]dp = new int[m][n];
            //Initialise the first col
            boolean blocked = false;
            for(int i = 0 ;i<m; i++){
                if(blocked) dp[i][0]=0;
                if(arr[i][0] == 1){
                    dp[i][0]=0;
                    blocked = true;
                }
                if(!blocked && arr[i][0]==0){
                    dp[i][0]=1;
                }
            }
             //Initialise the first row
            blocked = false;
            for(int i = 0 ;i<n; i++){
                if(blocked) dp[0][i]=0;
                if(arr[0][i] == 1){
                    dp[0][i]=0;
                    blocked = true;
                }
                if(!blocked && arr[0][i]==0){
                    dp[0][i]=1;
                }
            }   
            for(int i=0; i<m; i++){
                for(int j=0; j<n; j++){
                    if(i==0 && j==0 && arr[i][j]==0) dp[0][0]=1; 
                    else if(i==0 && j==0 && arr[i][j]==1) dp[0][0]=0;
                    else{
                        int up=0, down=0;
                        if(i>0) up = dp[i-1][j];
                        if(j>0) down = dp[i][j-1];
                        if(arr[i][j]!=1)
                        dp[i][j]=up+down;
                    }
                }
            }
            return dp[m-1][n-1];
        }
}