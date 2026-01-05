class Solution {

    boolean canDistribute(int mid,int candies[],long k){
        long child=0;
        for(int x:candies){
            child+=x/mid;
            if(child>=k) 
            return true;
        }

        return false;

    }
    public int maximumCandies(int[] candies, long k) {
        int n=candies.length;

        int l=1,r=0;

        for(int i:candies){
            r=Math.max(r,i);
        }

        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canDistribute(mid,candies,k)){
                ans=mid;
                l=mid+1;
            }
            else
            r=mid-1;

        }
        return ans;
    }
}