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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        que.offer(root);

        boolean past=false;
        while(!que.isEmpty()){
            TreeNode curr=que.poll();

            if(curr==null){
                past=true;
            }else{
                if(past==true)
                return false;
            

            que.offer(curr.left);
            que.offer(curr.right);
            }

            
        }
    return true;
    }
}