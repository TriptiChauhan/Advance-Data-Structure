class Solution {
    public int rob(int[] nums) {
        
        // top-down

        // if(i>=nums.length)
        // return 0;
        //  if(dp[i]!=-1)
        //  return dp[i];

        //  int case1=nums[i]+solve(i+2,nums,dp);

        //  int case2=solve(i+1,nums,dp);

        //  dp[i]=Math.max(case1,case2);

        //  return dp[i]
        int n=nums.length;
        if(n==1)
        return nums[0];
        int dp[]=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);

        }
        
        return dp[n-1];


    }

}