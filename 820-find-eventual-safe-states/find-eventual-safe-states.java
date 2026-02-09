class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int v=graph.length;
        
        List<Integer> result=new ArrayList<>();
        boolean safe[]=new boolean[v];
        boolean visit[]=new boolean[v];
        boolean path[]=new boolean[v];
        for(int i=0;i<v;i++){
             dfs(i,visit,path,graph,safe);
            
        }
        for(int i=0;i<v;i++){
            if(safe[i])
            result.add(i);
        }

        return result;
    }
    boolean dfs(int src,boolean visit[],boolean path[],int graph[][],boolean safe[]){
     
       if(visit[src])
       return safe[src];
       
        path[src]=true;
        visit[src]=true;

	for(int neigh:graph[src]){
	   if(path[neigh] || !dfs(neigh,visit,path,graph,safe)){
	   path[neigh]=false;
       safe[neigh]=false;
       return false;
        }
	
	}
path[src]=false;
safe[src]=true;
return true;
    }
}