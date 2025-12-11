class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=Integer.MIN_VALUE;
            }
        }

        return solve(0,0,triangle,dp);
    }

    int solve(int r,int c,List<List<Integer>> triangle,int dp[][]){
        if(r==triangle.size()-1)
        return triangle.get(r).get(c);
        int sum=Integer.MAX_VALUE;

        if(dp[r][c]!=Integer.MIN_VALUE)
        return dp[r][c];

        int down=solve(r+1,c,triangle,dp);
        int right=solve(r+1,c+1,triangle,dp);

        dp[r][c]=triangle.get(r).get(c)+Math.min(down,right);

        return dp[r][c];
    }
}