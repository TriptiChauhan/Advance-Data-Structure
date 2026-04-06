class Solution {
    int dp[][][];
    int n;
    public int cherryPickup(int[][] grid) {
        n=grid.length;
        dp=new int[n][n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    dp[i][j][k]=Integer.MIN_VALUE;
                }
            }
        }
        int res=dfs(grid,0,0,0);

        return Math.max(0,res);
    }

    int dfs(int grid[][],int r1,int r2,int c1){
        int c2=r1+c1-r2;


        if(r1>=n || r2>=n || c1>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1)
        return -10000000;

        if(r1==n-1 && c1==n-1)
        return grid[r1][c1];

        if(dp[r1][r2][c1]!=Integer.MIN_VALUE)
        return dp[r1][r2][c1];

        

        int cherries=grid[r1][c1];

        if(r1!=r2)
        cherries+=grid[r2][c2];

        int max=Math.max(Math.max(dfs(grid,r1+1,r2+1,c1),dfs(grid,r1,r2,c1+1)),
                        Math.max(dfs(grid,r1+1,r2,c1),dfs(grid,r1,r2+1,c1+1)));

        cherries+=max;
        return dp[r1][r2][c1]=cherries;



    }
}