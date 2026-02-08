class Solution {
    public boolean isBipartite(int[][] graph) {

        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(color, graph, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int[] color, int[][] graph, int src, int currcolor) {

        color[src] = currcolor;

        for (int neigh : graph[src]) {

            if (color[neigh] == currcolor)
                return false;

            if (color[neigh] == -1) {
                if (!dfs(color, graph, neigh, 1 - currcolor))
                    return false;
            }
        }
        return true;
    }
}
