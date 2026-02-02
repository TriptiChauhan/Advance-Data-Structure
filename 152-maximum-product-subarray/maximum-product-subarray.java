class Solution {
    public int maxProduct(int[] nums) {
        int maxproduct=Integer.MIN_VALUE;
        int n=nums.length;
        int product;
        for(int i=0;i<n;i++){
             product=1;
            for(int j=i;j<n;j++){
                product*=nums[j];
                maxproduct=Math.max(maxproduct,product);
              
            }
        }

    return maxproduct;
    }
}