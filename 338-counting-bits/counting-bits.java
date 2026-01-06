class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        

        // TC-O(n^2)
        // for(int i=0;i<=n;i++){

        //     int count=0;
        //     String s=Integer.toBinaryString(i);
        //     for(int j=0;j<s.length();j++){
        //     char c=s.charAt(j);
        //     if(c=='1')
        //     count++;
            
        //     }
        //     ans[i]=count;
            
        // }
        

        if(n==0)
        return ans;

        ans[0]=0;

        for(int i=1;i<=n;i++){
            if(i%2!=0){
                ans[i]=ans[i/2]+1;
            }else
            ans[i]=ans[i/2];
        }
        return ans;

    }
}