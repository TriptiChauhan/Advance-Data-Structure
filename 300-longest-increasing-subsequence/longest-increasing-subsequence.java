class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxlen=0;
        int n=nums.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[j]<nums[i]&& dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
                
            }
            if(dp[i]>maxlen)
                maxlen=dp[i];
        }
    return maxlen;
    }
}