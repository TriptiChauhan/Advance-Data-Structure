class Solution {
    int par[];
    int size[];
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> list=new ArrayList<>();
        int n=edges.length;
        par=new int[n+1];
        size=new int[n+1];

        for(int i=1;i<=n;i++){
            par[i]=i;
            size[i]=1;
        }
        for(int i=0;i<n;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            if(findUpar(u)==findUpar(v)){
            return new int[]{u,v};
        }
            unionBySize(u,v);
        }
        return new int[0];
    }

    int findUpar(int node){
        if(node==par[node])
        return node;
        return par[node]=findUpar(par[node]);
    }

    void unionBySize(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);

        if(ulp_u==ulp_v)
        return;

        if(size[ulp_u]<size[ulp_v]){
            par[ulp_u]=ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else{
            par[ulp_v]=ulp_u;
            size[ulp_u]+=size[ulp_v];
        }
    }
}