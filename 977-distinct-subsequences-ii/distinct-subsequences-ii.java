class Solution {
    public int distinctSubseqII(String s) {
        int n=s.length();
        long mod=1000000007;
        long dp[]=new long[n+1];

        HashMap<Character,Integer> last_occ=new HashMap<>();
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            dp[i]=(2*dp[i-1])%mod;

            char ch=s.charAt(i-1);
            if(last_occ.containsKey(ch)){
                int j=last_occ.get(ch);
                dp[i]=(dp[i]-dp[j-1]+mod)%mod;
            }

            last_occ.put(ch,i);
        }
        return (int)((dp[n]-1+mod)%mod);
    }
}