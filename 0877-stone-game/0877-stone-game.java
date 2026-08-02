class Solution {
    public boolean stoneGame(int[] piles) {
        // 1. The O(1) Math Trick (Always true based on constraints)
        // Adv 1: length(piles) is even means first and last will have diff indexes,like first is odd last is even and vice versa
        // that means who starts first will have control over whether to choose from pile of all odd index or pile of all even.
        // which ever he chooses, opponent is forced to choose the other pile
        //that is why he can look up early which pile is maximum and choose the 2 choice - odd index, even index accordingly
        return true;

        // 2. The O(N^2) DP Approach (For generalized constraints)
        // return canWinDP(piles);
    }

    private boolean canWinDP(int[] piles) {
        int n = piles.length;
        // dp[i][j] stores the max relative score difference for subarray piles[i...j]
        int[][] dp = new int[n][n];
        
        // Base Case: Subarrays of length 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        
        // Build up for subarray lengths from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                
                // Current player picks left (piles[i]) or right (piles[j])
                int pickLeft = piles[i] - dp[i + 1][j];
                int pickRight = piles[j] - dp[i][j - 1];
                
                dp[i][j] = Math.max(pickLeft, pickRight);
            }
        }
        
        // If the relative score difference for the entire array is > 0, 
        // the first player (Alice) wins.
        return dp[0][n - 1] > 0;
    }
}