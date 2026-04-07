class Solution {
    long mod=1000000007;
    int dp[][][];
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m=group.length;
        dp=new int[n+1][minProfit+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=minProfit;j++){
                for(int k=0;k<=m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(n,minProfit,group,profit,0);
    }
    int solve(int n,int minprofit,int group[],int profit[],int i){
        
        if(i==group.length){
           if(minprofit<=0)
           return 1;
           else
           return 0;

        }

        if(dp[n][minprofit][i]!=-1)
        return dp[n][minprofit][i];

        int skip=solve(n,minprofit,group,profit,i+1);
        int take=0;
        if(group[i]<=n){
            take=solve(n-group[i],Math.max(0,minprofit-profit[i]),group,profit,i+1);
        }
       
        
        return dp[n][minprofit][i]=(int)((take+skip)%mod);
    }
}