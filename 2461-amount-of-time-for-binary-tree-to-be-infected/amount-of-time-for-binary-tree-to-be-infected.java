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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,List<Integer>> graph=new HashMap<>();
        buildgraph(root,null,graph);

        Set<Integer> visited=new HashSet<>();
        Queue<Integer> que=new LinkedList<>();

        que.offer(start);
        visited.add(start);
        int time=-1;
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                int curr=que.poll();
                for(int neigh:graph.getOrDefault(curr,new ArrayList<>())){
                    if(!visited.contains(neigh)){
                        visited.add(neigh);
                        que.add(neigh);
                    }
                }

              
            }
              time++;
        }
        return time;

    }

    void buildgraph(TreeNode node,TreeNode parent,Map<Integer,List<Integer>> graph){
        if(node==null)
        return;

        graph.putIfAbsent(node.val,new ArrayList<>());

        if(parent!=null){
            graph.get(node.val).add(parent.val);
            graph.putIfAbsent(parent.val,new ArrayList<>());
            graph.get(parent.val).add(node.val);
        }
        buildgraph(node.left,node,graph);
        buildgraph(node.right,node,graph);
    }
    
}