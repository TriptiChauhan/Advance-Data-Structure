class Solution {
boolean caneat(int []piles,int mid,int h){
    long actualhour=0;
    for(int x:piles){
        actualhour+=x/mid;

        if(x%mid!=0){
            actualhour++;
        }
        if(actualhour>h)
        return false;
    }
    return actualhour<=h;
}

    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int l=1,r=0;
        

        for(int i=0;i<n;i++){
           r=Math.max(r,piles[i]);
        }

        int ans=r;
        
        while(l<=r){
            int mid=l+(r-l)/2;
            if(caneat(piles,mid,h)){
            ans=mid;
            r=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
}