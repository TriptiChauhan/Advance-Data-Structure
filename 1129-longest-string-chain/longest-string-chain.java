import java.util.*;

// class Solution {
//     public int longestStrChain(String[] words) {

    //     Arrays.sort(words, (a, b) -> a.length() - b.length());

    //     int n = words.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, 1);

    //     int maxLen = 1;

    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (isPredecessor(words[i], words[j])) {
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //         maxLen = Math.max(maxLen, dp[i]);
    //     }

    //     return maxLen;
    // }
    
    
   
    class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n=words.length;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(-1,0,words,dp);
    }
    private boolean isPredecessor(String a, String b) {
        if (a.length() != b.length() + 1) return false;

        int i = 0, j = 0;
        while (i < a.length()) {
            if (j <b.length() && a.charAt(i) == b.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == b.length();

    }
    int solve(int prev,int i,String words[],int dp[][]){
        if(i>=words.length)
        return 0;

        if(dp[i][prev+1]!=-1)
        return dp[i][prev+1];

        int take=0,skip;
        if(prev==-1||words[i].length()-words[prev].length()==1 && isPredecessor(words[i], words[prev]))
        take=1+solve(i,i+1,words,dp);
        skip=solve(prev,i+1,words,dp);
        dp[i][prev+1]=Math.max(take,skip);
        return dp[i][prev+1];
    }
    
}
