/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxi = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findmax(root);
        return maxi;
    }

    int findmax(TreeNode node) {
        if (node == null)
            return 0;

        int lh = Math.max(0,findmax(node.left));
        int rh = Math.max(0,findmax(node.right));

        maxi = Math.max(maxi, lh + rh + node.val);

        return node.val + Math.max(lh, rh);
    }
}