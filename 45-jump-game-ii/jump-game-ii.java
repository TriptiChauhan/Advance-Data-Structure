import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

       
        Arrays.fill(dp, Integer.MAX_VALUE);

      
        dp[0] = 0;

        
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE)
                continue;
            int end = Math.min(i + nums[i], n - 1);
            for (int j = i + 1; j <= end; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }

        }

        return dp[n - 1];
    }
}
