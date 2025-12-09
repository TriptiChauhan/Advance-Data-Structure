class Solution {

    public int numDecodings(String s) {
        Integer dp[] = new Integer[s.length()];
        return solve(0, s, dp);
    }

    private int solve(int index, String s, Integer  dp[]) {
        int n = s.length();

        
        if (index == n) return 1;

        
        if (dp[index] != null) return dp[index];

        int ways = 0;

        
        if (valid(s, index, index + 1)) {
            ways += solve(index + 1, s, dp);
        }

       
        if (valid(s, index, index + 2)) {
            ways += solve(index + 2, s, dp);
        }

        dp[index] = ways;
        return ways;
    }

   
    private boolean valid(String s, int l, int r) {
       
        if (r > s.length()) return false;

       
        if (s.charAt(l) == '0') return false;

        
        int num = Integer.parseInt(s.substring(l, r));

        return num >= 1 && num <= 26;
    }
}
