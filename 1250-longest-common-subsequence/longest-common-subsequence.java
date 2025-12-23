class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j]=-1;
            }
        }
        return solve(n,m,text1,text2);
    }

    int solve(int n,int m,String text1,String text2){
        if(n==0 || m==0)
        return 0;

        if(dp[n][m]!=-1)
        return dp[n][m];

        if(text1.charAt(n-1)==text2.charAt(m-1)){
            dp[n][m]=1+solve(n-1,m-1,text1,text2);
        return dp[n][m];
        }
        else{
        dp[n][m]=Math.max(solve(n-1,m,text1,text2),solve(n,m-1,text1,text2));
       
        }
        return dp[n][m];
    }
}