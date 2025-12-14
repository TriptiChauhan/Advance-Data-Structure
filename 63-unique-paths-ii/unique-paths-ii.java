class Solution {

    int[][] dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;

        dp = new int[m][n];

       
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, 0, obstacleGrid);
    }

    int solve(int r, int c, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

       
        if (r >= m || c >= n || grid[r][c] == 1)
            return 0;

        
        if (r == m - 1 && c == n - 1)
            return 1;

        
        if (dp[r][c] != -1)
            return dp[r][c];

        
        dp[r][c] = solve(r + 1, c, grid) + solve(r, c + 1, grid);

        return dp[r][c];
    }
}
