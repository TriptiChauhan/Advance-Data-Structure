class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int result = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            result = Math.min(result, solve(0, j, matrix, dp));
        }
        return result;
    }

    int solve(int r, int c, int[][] matrix, int[][] dp) {
        int n = matrix.length;
        if(c < 0 || c >= n) return Integer.MAX_VALUE;
        if(r == n - 1) return matrix[r][c];
        if(dp[r][c] != Integer.MAX_VALUE) return dp[r][c];
        int down = solve(r + 1, c, matrix, dp);
        int downLeft = solve(r + 1, c - 1, matrix, dp);
        int downRight = solve(r + 1, c + 1, matrix, dp);
        dp[r][c] = matrix[r][c] + Math.min(down, Math.min(downLeft, downRight));
        return dp[r][c];
    }
}

