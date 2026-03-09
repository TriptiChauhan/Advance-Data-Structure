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
    int maxi;
    public int diameterOfBinaryTree(TreeNode root) {
       findmax(root);
        return maxi;
    }

    // Brute force
    int findmax(TreeNode node){
        if(node==null)
        return 0;

        int lh=findmax(node.left);
        int rh=findmax(node.right);

        maxi=Math.max(maxi,lh+rh);

        return 1+Math.max(lh,rh);
    }
}