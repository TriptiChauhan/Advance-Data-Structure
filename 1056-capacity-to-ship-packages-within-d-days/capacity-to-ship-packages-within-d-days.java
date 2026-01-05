class Solution {
    boolean days(int weights[],int mid,int days){
        int day=1,load=0;
        for(int x:weights){
            if(load+x>mid){
                day+=1;
                load=x;
            }else
            {
                load+=x;
            }
        }
        return day<=days;
    }


    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;

        int l=0,sum=0;
        for(int i:weights){
            l=Math.max(l,i);
            sum+=i;
        }
        int r=sum;
        int ans=r;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(days(weights,mid,days)){
                ans=mid;
                r=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
}