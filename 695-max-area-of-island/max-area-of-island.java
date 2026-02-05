// class Solution {
//     public int maxAreaOfIsland(int[][] grid) {
    
//         int m=grid.length;
//         int n=grid[0].length;
//         int count=0;
//         int area=Integer.MIN_VALUE;
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==1){
//                 dfs(i,j,grid);
//                 count++;
//                 }
               

//             }
//              if(count>area)
//                 area=count;
//         }
//         return area;
//     }
//     void dfs(int i,int j,int grid[][]){
//         int m=grid.length;
//         int n=grid[0].length;
//         if(i<0||i>=m||j<0||j>=n||grid[i][j]!=1)
//         return;

//         grid[i][j]='$';
        
        
//         dfs(i,j+1,grid);
//         dfs(i,j-1,grid);
//         dfs(i+1,j,grid);
//         dfs(i-1,j,grid);
//     }
// }











class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    int dfs(int i, int j, int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
            return 0;

       
        grid[i][j] = 0;

        int area = 1;

        area += dfs(i, j + 1, grid);
        area += dfs(i, j - 1, grid);
        area += dfs(i + 1, j, grid);
        area += dfs(i - 1, j, grid);

        return area;
    }
}

    