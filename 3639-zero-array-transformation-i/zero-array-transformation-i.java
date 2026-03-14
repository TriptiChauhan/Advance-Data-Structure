class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
       
       // Brute force
        // for(int query[]:queries){  O(Q) --> no. of queries
        //     int l=query[0];
        //     int r=query[1];

        //     for(int i=l;i<=r;i++){ O(n)
        //         if(nums[i]!=0)
        //         nums[i]--;
        //     }
        // }

        // for(int i=0;i<n;i++){
        //     if(nums[i]>0)
        //     return false;
        // }



        // using difference array
        int diff[]=new int[n];
        for(int query[]:queries){  
            int l=query[0];
            int r=query[1];

            diff[l]+=1;
            if(r+1<n)
            diff[r+1]-=1;
        }
        int operation=diff[0];
        if(operation<nums[0]) return false;
        for(int i=1;i<n;i++){
            operation+=diff[i];
            if(operation<nums[i])
            return false;
        }

        
        return true;
    }
}