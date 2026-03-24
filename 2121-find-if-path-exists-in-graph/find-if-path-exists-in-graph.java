class Solution {
    static int par[],rank[];

    // using DSU 

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
         par=new int[n];
         rank=new int[n];
         for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
        for(int edge[]:edges){
            int x=edge[0];
            int y=edge[1];
            union(x,y);
            
        }
        if(find(source)==find(destination))
        return true;
        return false;
    }
    int find(int node){
        if(node==par[node])
        return node;

        return par[node]=find(par[node]);
    }

    void union(int x,int y){
        int x_par=find(x);
        int y_par=find(y);
        if(x_par==y_par)
        return;

        if(rank[x_par]>rank[y_par])
            par[y_par]=x_par;
        else if(rank[y_par]>rank[x_par])
            par[x_par]=y_par;
        else
        {
            par[x_par]=y_par;
            rank[y_par]++;
        }
    }
}