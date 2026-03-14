class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int diff[]=new int[n];
        for(int u[]:shifts){
            int l=u[0];
            int r=u[1];
            int dif=u[2];
            int x;
            if(dif==0)
                x=-1;
            else
                x=1;

            diff[l]+=x;
            if(r+1<n)
            diff[r+1]-=x;
        }
        for(int i=1;i<n;i++){
            diff[i]+=diff[i-1];
        }

        char arr[]=s.toCharArray();
        for(int i=0;i<n;i++){
            int shift=diff[i]%26;
            if(shift<0)
            shift+=26;
            
            arr[i]=(char)((arr[i]-'a'+ shift)%26+'a');
            
        }

        s=new String(arr);

        return s;
    }
}