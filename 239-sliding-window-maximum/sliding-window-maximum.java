// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
//         int ans[]=new int[n-k+1];

//         for(int i=0;i<=n-k;i++){
//             int max=0;
//             for(int j=i;j<i+k;j++){
//                 if(max<nums[j]){
//                     max=nums[j];
//                 }
//             }
//             ans[i]=max;
//         }
//         return ans;
//     }
// }


import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 1. Window ke bahar wale indices hata do
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2. Chhote elements ko peeche se hata do
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3. Current index add karo
            dq.offerLast(i);

            // 4. Jab first valid window ban jaye, answer store karo
            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return ans;
    }
}