class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int q = queries.length;

        int l = 0, r = q, ans = -1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (canZero(nums, queries, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private boolean canZero(int[] nums, int[][] queries, int k) {

        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if(r+1<n)
            diff[r + 1] -= val;
        }

        int curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];
            if (curr < nums[i])
             return false;
        }

        return true;
    }
}