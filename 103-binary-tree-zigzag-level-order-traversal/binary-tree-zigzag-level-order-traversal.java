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


//  Approach 1-->reverse odd index
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if(root==null)
        return list;
        que.add(root);
        int levelIndex=0;
        while(!que.isEmpty()){
            int size=que.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                level.add(node.val);
                if(node.left!=null)
                que.add(node.left);
                if(node.right!=null)
                que.add(node.right);
            }

            if(levelIndex%2!=0)
            Collections.reverse(level);
            list.add(level);
            levelIndex++;
        }
        
        return list;
    }
}




























// class Solution {
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
        
//         if (root == null) return result;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
        
//         int levelIndex = 0;

//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             List<Integer> level = new ArrayList<>();

//             for (int i = 0; i < size; i++) {
//                 TreeNode node = queue.poll();
//                 level.add(node.val);

//                 if (node.left != null) queue.offer(node.left);
//                 if (node.right != null) queue.offer(node.right);
//             }

           
//             if (levelIndex % 2 == 1) {
//                 Collections.reverse(level);
//             }

//             result.add(level);
//             levelIndex++;
//         }

//         return result;
//     }
// }