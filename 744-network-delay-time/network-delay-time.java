
class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<int[]>[] list = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            list[u].add(new int[]{v, w});
        }

        return dijkstra(n, list, k);
    }

    public int dijkstra(int n, List<int[]>[] list, int src) {

        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];

            if (d > dist[node]) continue;

            for (int[] edge : list[node]) {

                int next = edge[0];
                int weight = edge[1];

                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}
