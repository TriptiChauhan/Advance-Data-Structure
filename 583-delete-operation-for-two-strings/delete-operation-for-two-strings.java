class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return solve(word1, word2, 0, 0, dp);
    }

    int solve(String word1, String word2, int i, int j, int dp[][]) {

        
        if (i == word1.length())
            return word2.length() - j;

        
        if (j == word2.length())
            return word1.length() - i;

        if (dp[i][j] != -1)
            return dp[i][j];

        
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve(word1, word2, i + 1, j + 1, dp);
        }

        
        int deleteFromWord1 = 1 + solve(word1, word2, i + 1, j, dp);
        int deleteFromWord2 = 1 + solve(word1, word2, i, j + 1, dp);

        return dp[i][j] = Math.min(deleteFromWord1, deleteFromWord2);
    }
}
