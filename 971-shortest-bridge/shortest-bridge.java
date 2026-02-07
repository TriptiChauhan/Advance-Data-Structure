import java.util.*;

class Solution {

    int n;

    public int shortestBridge(int[][] grid) {

        n = grid.length;

        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

      
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {

                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                }
            }
        }

       
        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

            
                if (r - 1 >= 0) {

                    if (grid[r - 1][c] == 1)
                        return level;

                    if (grid[r - 1][c] == 0) {
                        grid[r - 1][c] = -1;
                        queue.add(new int[]{r - 1, c});
                    }
                }

            
                if (r + 1 < n) {

                    if (grid[r + 1][c] == 1)
                        return level;

                    if (grid[r + 1][c] == 0) {
                        grid[r + 1][c] = -1;
                        queue.add(new int[]{r + 1, c});
                    }
                }

            
                if (c - 1 >= 0) {

                    if (grid[r][c - 1] == 1)
                        return level;

                    if (grid[r][c - 1] == 0) {
                        grid[r][c - 1] = -1;
                        queue.add(new int[]{r, c - 1});
                    }
                }

              
                if (c + 1 < n) {

                    if (grid[r][c + 1] == 1)
                        return level;

                    if (grid[r][c + 1] == 0) {
                        grid[r][c + 1] = -1;
                        queue.add(new int[]{r, c + 1});
                    }
                }
            }

            level++;
        }

        return -1;
    }

    
    private void dfs(int[][] grid, int r, int c, Queue<int[]> queue) {

        if (r < 0 || c < 0 || r >= n || c >= n || grid[r][c] != 1)
            return;

        grid[r][c] = -1;
        queue.add(new int[]{r, c});

        
        dfs(grid, r - 1, c, queue);

        
        dfs(grid, r + 1, c, queue);

       
        dfs(grid, r, c - 1, queue);

       
        dfs(grid, r, c + 1, queue);
    }
}
