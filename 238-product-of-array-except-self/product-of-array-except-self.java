class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int ans[]=new int[n];
        

        //Brute Force
        // for(int i=0;i<n;i++){  // O(n^2)
        //     int product=1;
        //     for(int j=0;j<n;j++){
        //         if(i!=j)
        //         product=(product*nums[j]);
                
        //     }
        //     ans[i]=product;
        // }



        // Optimized Approach
        int product_left=1;
        int product_right=1;

        // Right side prduct
        for(int i=n-1;i>=0;i--){ //O(n)
            ans[i]=product_right;
            product_right*=nums[i];
        }

        // left Side product
        for(int i=0;i<n;i++){  // O(n)
            ans[i]=ans[i]*product_left;
            product_left*=nums[i];
        }

        return ans;
    }
}