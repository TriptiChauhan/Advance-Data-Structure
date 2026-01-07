class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                dp[i][j]=-1;
            }
        }
        return solve(0,1,prices,dp);
    }

    int solve(int i,int flag,int prices[],int dp[][]){
        if(i>=prices.length)
        return 0;

        if(dp[i][flag]!=-1)
        return dp[i][flag];
        int profit=0;
        if(flag==1){
            int buy=-prices[i]+solve(i+1,0,prices,dp);
            int skip=solve(i+1,1,prices,dp);
             profit=Math.max(buy,skip);
        }
        else{
            int sell=prices[i]+solve(i+1,1,prices,dp);
            int skip1=solve(i+1,0,prices,dp);
             profit=Math.max(sell,skip1);
        }
        dp[i][flag]=profit;
        return dp[i][flag];
    }
}