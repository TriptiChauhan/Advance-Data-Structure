// class Solution {
//     public int findCenter(int[][] edges) {
//         int n=edges.length+1;
//         int e=edges.length;
//         int adj[][]=new int[n+1][n+1];
//         for(int i=0;i<e;i++){
//             {
//                 int u=edges[i][0];
//                 int v=edges[i][1];
//                 adj[u][v]=1;
//                 adj[v][u]=1;

                
//             }
//         }
//         for(int i=1;i<=n;i++){
//             int count=0;
//             for(int j=1;j<=n;j++){
//                 if(adj[i][j]==1)
//                 count++;
//             }
//             if(count==n-1)
//             return i;
//         }
//         return -1;
//     }
// }


class Solution {
    public int findCenter(int[][] edges) {
        int n=edges.length+1;
        int e=edges.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            {
                int u=edges[i][0];
                int v=edges[i][1];
                list.get(u).add(v);
                list.get(v).add(u);

                
            }
        }
        for(int i=1;i<=n;i++){
            
            if(list.get(i).size()==n-1)
           
            return i;
        }
        return -1;
    }
}