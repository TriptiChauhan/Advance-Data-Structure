class Solution {
    int dp[];
    public boolean canJump(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,nums,n);
    }
    boolean solve(int i,int nums[],int n){
        if(i>=n-1)
        return true;

        if(nums[i]==0)
        return false;

        if(dp[i]!=-1)
        return dp[i]==1;

        for(int j=1;j<=nums[i];j++){
            
           if(solve(i+j,nums,n))
           {
            dp[j]=1;
             return true;
           }
       
        }
    dp[i]=0;
    return false;
    }
}