class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        Boolean dp[][]=new Boolean[len][len];
        return solve(s,0,len,dp);
    }




    String solve(String s,int i,int len,Boolean dp[][]){
        if(i==len)
        return "";

        String largest="";
        for(int j=i+1;j<=len;j++){
           if(palin(s,i,j-1,dp)){
           String curr=s.substring(i,j);
           if(curr.length()>largest.length())
           largest=curr;
           }
        }

        String next =solve(s,i+1,len,dp);
        if(largest.length()>next.length())
        return largest;
        else
        return next;
       
    }

    boolean palin(String s,int left,int right,Boolean dp[][]){
     
       if(left>=right)
       return true;
        if(dp[left][right]!=null)
        return dp[left][right];

    boolean result = (s.charAt(left) == s.charAt(right)) &&palin(s, left + 1, right - 1,dp);
       dp[left][right]=result;
      
      return result;

    }
}