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
    class pair{
        TreeNode node;
        int idx;
        pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }

    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;

        Queue<pair> que=new LinkedList<>();
        que.offer(new pair(root,0));
        int maxwidth=0;
        while(!que.isEmpty()){
            int size=que.size();
            int min_idx=que.peek().idx;
            int first=0,last=0;
            for(int i=0;i<size;i++){
                pair curr=que.poll();
                int curridx=curr.idx-min_idx;
                if(i==0)
                first=curridx;
                if(i==size-1)
                last=curridx;

                if(curr.node.left!=null)
                que.offer(new pair(curr.node.left,2*curridx+1));
                if(curr.node.right!=null)
                que.offer(new pair(curr.node.right,2*curridx+2));
            }
            maxwidth=Math.max(maxwidth,last-first+1);
        }
        return maxwidth;

    }
}