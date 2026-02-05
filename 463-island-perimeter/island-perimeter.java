class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][]=new boolean[m][n];
        

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                 return dfs(i,j,grid,visited);
            }
        }
    return 0;
    }

    int dfs(int i,int j,int grid[][],boolean visited[][]){
        int m = grid.length;
        int n = grid[0].length;
        int perimeter = 0;
        if(i>=m || i<0 ||j>=n||j<0||grid[i][j]!=1)
        return 1;
        if(visited[i][j]==true)
        return 0;

        visited[i][j]=true;

        perimeter+= dfs(i,j+1,grid,visited);
        perimeter+=dfs(i,j-1,grid,visited);
        perimeter+=dfs(i+1,j,grid,visited);
        perimeter+=dfs(i-1,j,grid,visited);

        return perimeter;

    }
}
