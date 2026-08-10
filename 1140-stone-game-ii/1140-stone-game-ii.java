import java.util.Arrays;

class Solution {

    private int[][][] dp;

    private int f(int person, int i, int M, int n, int[] piles) {

        if (i >= n)
            return 0;

        // Already calculated
        if (dp[person][i][M] != -1)
            return dp[person][i][M];

        int stones = 0;

        int result = (person == 1)
                ? -1
                : Integer.MAX_VALUE;

        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {

            stones += piles[i + x - 1];

            if (person == 1) { // Alice

                result = Math.max(
                    result,
                    stones + f(
                        0,
                        i + x,
                        Math.max(x, M),
                        n,
                        piles
                    )
                );

            } else { // Bob

                result = Math.min(
                    result,
                    f(
                        1,
                        i + x,
                        Math.max(x, M),
                        n,
                        piles
                    )
                );
            }
        }

        return dp[person][i][M] = result;
    }

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[2][n][n + 1];

        for (int person = 0; person < 2; person++) {
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[person][i], -1);
            }
        }

        return f(1, 0, 1, n, piles);
    }
}