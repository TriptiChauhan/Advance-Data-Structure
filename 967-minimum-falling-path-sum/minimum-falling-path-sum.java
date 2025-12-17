
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

       
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int down = dp[i - 1][j];
                int downLeft = Integer.MAX_VALUE;
                int downRight = Integer.MAX_VALUE;

                if (j > 0) {
                    downLeft = dp[i - 1][j - 1];
                }

                if (j < n - 1) {
                    downRight = dp[i - 1][j + 1];
                }

                dp[i][j] = matrix[i][j] +
                           Math.min(down, Math.min(downLeft, downRight));
            }
        }

       
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m - 1][j]);
        }

        return ans;
    }
}
