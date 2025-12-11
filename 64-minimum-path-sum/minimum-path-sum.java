class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        return solve(0,0,grid,dp);
    }

    int solve(int r,int c,int grid[][],int dp[][]){
        int m=grid.length;
        int n=grid[0].length;
        if(r>=m || c>=n )
        return Integer.MAX_VALUE;
        if(r==m-1 && c==n-1)
        return grid[r][c];


        // bottom-up
       dp[0][0]=grid[0][0];
       //rowFilling
        for(int i=1;i<n;i++)
        {
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }
        for(int i=1;i<m;i++)
        {
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];



        // top-down

        // if(dp[r][c]!=-1)
        // return dp[r][c];
        
        // int right=solve(r,c+1,grid,dp);
        // int down=solve(r+1,c,grid,dp);

        // grid[r][c]+=Math.min(down,right);
        // dp[r][c]=grid[r][c];
        // return dp[r][c];
    }
}