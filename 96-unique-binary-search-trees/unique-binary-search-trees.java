class Solution {

    int dp[];

    public int numTrees(int n) {
        dp = new int[n + 1];
        return solve(n);
    }

    private int solve(int n) {
      
        if (n == 0 || n == 1)
            return 1;

       
        if (dp[n] != 0)
            return dp[n];

        int total = 0;

        
        for (int root = 1; root <= n; root++) {
            int left = solve(root - 1);
            int right = solve(n - root);
            total += left * right;
        }

        dp[n] = total; 
        return total;
    }
}
