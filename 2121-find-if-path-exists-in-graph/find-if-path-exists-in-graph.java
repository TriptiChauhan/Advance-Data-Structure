class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int e=edges.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        boolean visited[]=new boolean[n];
        for(int i=0;i<e;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }
        return bfs(source,destination,list,visited);
    }

    boolean bfs(int source,int destination, List<List<Integer>> list,boolean visited[]){

        Queue<Integer> que=new LinkedList<>();
        que.add(source);
        visited[source]=true;
        while(!que.isEmpty()){
            int curr=que.poll();
            if(curr==destination)
            return true;
            for(int neigh:list.get(curr)){
                if(visited[neigh]==false){
                que.add(neigh);
                visited[neigh]=true;
                
                
                }
            }
        
        }
        return false;
    }
}