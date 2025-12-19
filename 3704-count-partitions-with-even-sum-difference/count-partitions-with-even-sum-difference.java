class Solution {
    public int countPartitions(int[] nums) {
        int total=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        int left=0;
        int right,count=0;
        for(int j=0;j<nums.length-1;j++){
            left+=nums[j];
            right=total-left;
            if((left-right)%2==0)
            count++;
        }
        return count;
    }
}