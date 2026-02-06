class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++){
            dfs(grid,i,0,visited);
            dfs(grid,i,m-1,visited);
        }
        for(int j=0;j<m;j++){
            dfs(grid,0,j,visited);
            dfs(grid,n-1,j,visited);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j])
                count++;
            }
        }
        

        return count;
    }
    void dfs(int grid[][],int i,int j,boolean visited[][]){
        int n=grid.length;
        int m=grid[0].length;
        if(i<0 || i>n-1 || j<0 || j>m-1 || grid[i][j]!=1 || visited[i][j])
        return;

        visited[i][j]=true;

        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);
        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
    }
}