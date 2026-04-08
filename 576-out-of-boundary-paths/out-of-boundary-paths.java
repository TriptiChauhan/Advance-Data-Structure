class Solution {
    long mod=1000000007;
    Integer dp[][][];
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[maxMove+1][m][n];

        return solve(n,m,maxMove,startRow,startColumn);
    }
    int solve(int n, int m, int maxMove, int i, int j){
        long count=0;
        if(i<0 || j<0 || i>=m || j>=n)
        return 1;

        if(dp[maxMove][i][j]!=null)
        return dp[maxMove][i][j];

        if(maxMove<=0)
        return 0;

        count+=(solve(n,m,maxMove-1,i-1,j)%mod);
        count+=(solve(n,m,maxMove-1,i,j-1)%mod);
        count+=(solve(n,m,maxMove-1,i,j+1)%mod);
        count+=(solve(n,m,maxMove-1,i+1,j)%mod);

        return dp[maxMove][i][j]=(int)(count%mod);
    }
}