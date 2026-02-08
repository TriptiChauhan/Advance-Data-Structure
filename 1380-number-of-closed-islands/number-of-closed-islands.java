class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
      
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                if (grid[i][j] == 0) {
                    
                    if (dfs(i, j, grid)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    boolean dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

       
        if (i < 0 || i >= n || j < 0 || j >= m)
            return false;

       
        if (grid[i][j] == 1)
            return true;

       
        grid[i][j] = 1;

        
        boolean right = dfs(i, j + 1, grid);
        boolean left  = dfs(i, j - 1, grid);
        boolean down  = dfs(i + 1, j, grid);
        boolean up    = dfs(i - 1, j, grid);

       
        if (!right || !left || !down || !up)
            return false;

        return true;
    }
}
