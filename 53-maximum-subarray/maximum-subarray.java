class Solution {
    // int maxsum=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {

        //optimal 
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];

            if(sum>max)
            max=sum;


            if(sum<0)
            sum=0;
        }
        return max;

        // solve(nums,0,0);
        // return maxsum;
    }


    //Brute Force
    // void solve(int nums[],int idx,int currsum){
    //     if(idx==nums.length)
    //     return;

    //     int take=nums[idx]+currsum;

    //     int skip=nums[idx];

    //     currsum=Math.max(take,skip);

    //     maxsum=Math.max(maxsum,currsum);

    //     solve(nums,idx+1,currsum);
    // }
  
}