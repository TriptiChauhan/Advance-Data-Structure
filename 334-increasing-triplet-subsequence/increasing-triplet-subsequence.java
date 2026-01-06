class Solution {
    // public boolean increasingTriplet(int[] nums) {
    //    return solve(-1,0,nums)>=3;
    // }

    // int solve(int prev,int i,int nums[]){
    //     if(i>=nums.length)
    //     return 0;

    //     int take=0;

    //     if(prev==-1 || nums[prev]<nums[i])
    //     take=1+solve(i,i+1,nums);

    //     int skip=solve(prev,i+1,nums);

    //     return Math.max(take,skip);
    // }


    public boolean increasingTriplet(int[] nums)
{
  
    int num1=Integer.MAX_VALUE;
    int num2=Integer.MAX_VALUE;

    for(int i=0;i<nums.length;i++){
        int num3=nums[i];
    if(num3<=num1){
        num1=num3;
    }else if(num3<=num2){
        num2=num3;
    }
    else{
        return true;
    }
    }
   
    return false;
}
    
}