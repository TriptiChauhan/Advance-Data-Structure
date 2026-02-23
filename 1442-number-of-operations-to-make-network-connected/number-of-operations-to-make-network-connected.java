class Solution {
    int par[];
    int size[];
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
        return -1;
        int extra=0;
        par=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
            size[i]=1;
        }
        for(int i=0;i<connections.length;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            int ulp_u=findUpar(u);
            int ulp_v=findUpar(v);
            if(ulp_u==ulp_v)
            extra++;
            else
            unionBySize(ulp_u,ulp_v);
        }

        int no_con=0;
        for(int i=0;i<n;i++){
            if(findUpar(i)==i)
            no_con++;
        }
        int ans=no_con-1;
        if(extra>=ans)
        return ans;
        else
        return -1;
    }

    int findUpar(int node){
        if(node==par[node])
        return node;
        return par[node]=findUpar(par[node]);
    }

    void unionBySize(int u,int v){
        if(u==v)
        return;
        if(size[u]>size[v]){
        par[v]=u;
        size[u]+=size[v];
        }
        else
        {
            par[u]=v;
            size[v]+=size[u];
        }
    }
}