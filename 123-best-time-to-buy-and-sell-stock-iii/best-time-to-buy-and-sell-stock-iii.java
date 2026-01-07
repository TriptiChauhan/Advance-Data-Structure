// class Solution {
//     public int maxProfit(int[] prices) {
//         return solve(0,1,prices,2);
//     }

//     int solve(int i,int flag,int prices[],int limit){
//         if(i>=prices.length)
//         return 0;
        
//         if(limit==0)
//         return 0;
        
//         int profit=0;
//         if(flag==1){
//             int buy=-prices[i]+solve(i+1,0,prices,limit);
//             int skip=solve(i+1,1,prices,limit);
//             profit=Math.max(buy,skip);
//         }
//         else{
//             int sell=prices[i]+solve(i+1,1,prices,limit-1);
//             int skip1=solve(i+1,0,prices,limit);
//             profit=Math.max(sell,skip1);
           
//         }

//         return profit;
//     }
// }



class Solution {
    int[][][] dp;

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++)
                    dp[i][j][k] = -1;

        return solve(0, 1, prices, 2);
    }

    int solve(int i, int flag, int[] prices, int limit) {
        if (i == prices.length || limit == 0)
            return 0;

        if (dp[i][flag][limit] != -1)
            return dp[i][flag][limit];

        int profit;
        if (flag == 1) {
            profit = Math.max(
                -prices[i] + solve(i + 1, 0, prices, limit),
                solve(i + 1, 1, prices, limit)
            );
        } else {
            profit = Math.max(
                prices[i] + solve(i + 1, 1, prices, limit - 1),
                solve(i + 1, 0, prices, limit)
            );
        }

        return dp[i][flag][limit] = profit;
    }
}
