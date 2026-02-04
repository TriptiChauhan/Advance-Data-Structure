
import java.util.*;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1);

        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == -1) {
                bfs(isConnected, visited, i, n);
                provinces++;
            }
        }

        return provinces;
    }

    void bfs(int[][] isConnected, int[] visited, int src, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 0; i < n; i++) {
                if (isConnected[curr][i] == 1 && visited[i] == -1) {
                    queue.add(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
