class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
       
        return solve(prices);
    }


    // Memoization
    // int solve(int i,int flag,int prices[],int dp[][]){
    //     if(i>=prices.length)
    //     return 0;

    //     if(dp[i][flag]!=-1)
    //     return dp[i][flag];
    //     int profit=0;
    //     if(flag==1){
    //         int buy=-prices[i]+solve(i+1,0,prices,dp);
    //         int skip=solve(i+1,1,prices,dp);
    //          profit=Math.max(buy,skip);
    //     }
    //     else{
    //         int sell=prices[i]+solve(i+1,1,prices,dp);
    //         int skip1=solve(i+1,0,prices,dp);
    //          profit=Math.max(sell,skip1);
    //     }
    //     dp[i][flag]=profit;
    //     return dp[i][flag];
    // }


    // tabulation
    // int solve(int prices[]){
    //     int n=prices.length;
    //      int dp[][]=new int[n+1][2];
    //     for(int i=n-1;i>=0;i--){
    //         dp[i][1]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);

    //         dp[i][0]=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
    //     }
    //     return dp[0][1];
    // }


    // Optimization
    int solve(int prices[]) {
    int n = prices.length;

    int[] next = new int[2]; 
    int[] curr = new int[2];

    for (int i = n - 1; i >= 0; i--) {
       
        curr[1] = Math.max(-prices[i] + next[0], next[1]);

     
        curr[0] = Math.max(prices[i] + next[1], next[0]);

        next[0] = curr[0];
        next[1] = curr[1];
    }
    return next[1]; 
}

}