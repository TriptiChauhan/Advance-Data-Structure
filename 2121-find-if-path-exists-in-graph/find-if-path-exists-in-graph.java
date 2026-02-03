class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> list=new ArrayList<>();
        int e=edges.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        boolean visited[]=new boolean[n];
        for(int i=0;i<e;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            list.get(u).add(v);
            list.get(v).add(u);
        }
        return dfs(n,source,destination,edges,list,visited);
    }
    boolean dfs(int n,int source,int destination,int edges[][], List<List<Integer>> list,boolean visited[]){
        if(source==destination)
        return true;
        if(visited[source]==true)
        return false;
        visited[source]=true;

        for(int neighbour:list.get(source)){
            if(dfs(n,neighbour,destination,edges,list,visited)==true)
            return true;
        }
        return false;
    }
}