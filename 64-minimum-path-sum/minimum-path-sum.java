class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,0,grid,dp);
    }

    int solve(int r,int c,int grid[][],int dp[][]){
        int m=grid.length;
        int n=grid[0].length;
        if(r>=m || c>=n )
        return Integer.MAX_VALUE;
        if(r==m-1 && c==n-1)
        return grid[r][c];

        if(dp[r][c]!=-1)
        return grid[r][c];
        
        int left=solve(r,c+1,grid,dp);
        int right=solve(r+1,c,grid,dp);

        grid[r][c]+=Math.min(left,right);
        dp[r][c]=grid[r][c];
        return dp[r][c];
    }
}