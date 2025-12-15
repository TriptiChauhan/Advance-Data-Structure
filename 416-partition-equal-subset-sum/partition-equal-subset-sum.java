class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=nums[i];
        }
        int sum=0;
        if(totalsum%2==0){
             sum=totalsum/2;
        }
        if(totalsum%2!=0){
            return false;
        }
         boolean dp[][] = new boolean[n + 1][sum + 1];

       
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

     
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                
                dp[i][j] = dp[i - 1][j];

               
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][sum];

    }
}