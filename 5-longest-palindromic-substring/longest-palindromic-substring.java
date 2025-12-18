class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        return solve(s,0,len);
    }




    String solve(String s,int i,int len){
        if(i==len)
        return "";

        String largest="";
        for(int j=i+1;j<=len;j++){
           if(palin(s,i,j-1)){
           String curr=s.substring(i,j);
           if(curr.length()>largest.length())
           largest=curr;
           }
        }

        String next =solve(s,i+1,len);
        if(largest.length()>next.length())
        return largest;
        else
        return next;
       
    }

    boolean palin(String s,int left,int right){
      while(left<right){
        if(s.charAt(left)!=s.charAt(right))
        return false;
        left++;
        right--;
      }
      return true;

    }
}