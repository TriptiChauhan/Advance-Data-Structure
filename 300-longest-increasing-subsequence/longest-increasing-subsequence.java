class Solution {
    public int lengthOfLIS(int[] nums) {
        return solve(nums);
    }
    // int solve(int prev,int i,int nums[]){
    //     if(i>=nums.length)
    //     return 0;

    //     int take=0,skip;
    //     if(prev==-1||nums[prev]<nums[i])
    //     take=1+solve(i,i+1,nums);
    //     skip=solve(prev,i+1,nums);

    //     return Math.max(take,skip);
    // }


    int solve(int nums[]){
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        

        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int take=0,skip;
                if(j==-1||nums[i]>nums[j])
                take=1+dp[i+1][i+1];
                skip=dp[i+1][j+1];
                dp[i][j+1]=Math.max(take,skip);
            }
        }

        return dp[0][0];

    }

    

    


    
}