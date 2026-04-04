class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int leftsum=0;
            int rightsum=0;
            for(int l=0;l<i;l++){
                leftsum+=nums[l];
            }
            for(int r=i+1;r<n;r++){
                rightsum+=nums[r];
            }
            if(leftsum==rightsum)
            return i;
        }
        return -1;
    }
}