class Solution {
    static int par[], size[];
    static int comp;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        par = new int[n];
        size = new int[n];
        comp = n; 

        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }

      
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        return comp;
    }

    // Find with path compression
    int findpar(int node) {
        if (node == par[node]) {
            return node;
        }
        return par[node] = findpar(par[node]);
    }

    void union(int x, int y) {
        int x_par = findpar(x);
        int y_par = findpar(y);

        if (x_par == y_par) return;

        if (size[x_par] > size[y_par]) {
            par[y_par] = x_par;
            size[x_par] += size[y_par];
        } else {
            par[x_par] = y_par;
            size[y_par] += size[x_par];
        }

        comp--; 
    }
}