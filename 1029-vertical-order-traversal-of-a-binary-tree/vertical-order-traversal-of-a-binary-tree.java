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
    class Pair{
        TreeNode node;
        int vertical,level;
        Pair(TreeNode node,int vertical,int level){
            this.node=node;
            this.vertical=vertical;
            this.level=level;
        }

    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> nodes = new TreeMap<>();


        Queue<Pair> que=new LinkedList<>();
        que.offer(new Pair(root,0,0));

        while(!que.isEmpty()){
            Pair p=que.poll();
            TreeNode temp=p.node;
            int x=p.vertical;
            int y=p.level;


            nodes.putIfAbsent(x,new TreeMap<>());
            nodes.get(x).putIfAbsent(y,new PriorityQueue<>());
            nodes.get(x).get(y).offer(temp.val);

            if(temp.left!=null)
            que.offer(new Pair(temp.left,x-1,y+1));

            if(temp.right!=null)
            que.offer(new Pair(temp.right,x+1,y+1));
        }
            List<List<Integer>> ans=new ArrayList<>();

            for(TreeMap<Integer,PriorityQueue<Integer>> ys:nodes.values()){
                List<Integer> col=new ArrayList<>();
                for(PriorityQueue<Integer> y:ys.values()){
                    while(!y.isEmpty()){
                        col.add(y.poll());
                    }
                }
                ans.add(col);
            }
        
        return ans;
    }
}