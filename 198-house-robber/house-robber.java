class Solution {
    public int rob(int[] nums) {
        int dp[]= new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(0,nums,dp);

    }
    int solve(int i,int nums[],int dp []){
        if(i>=nums.length)
        return 0;
         if(dp[i]!=-1)
         return dp[i];

         int case1=nums[i]+solve(i+2,nums,dp);

         int case2=solve(i+1,nums,dp);

         dp[i]=Math.max(case1,case2);

         return dp[i];
    }

}