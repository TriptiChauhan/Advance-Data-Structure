import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {

        int mod = 1_000_000_007;

        
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

       
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int t = roads[i][2];

            list.get(u).add(new int[]{v, t});
            list.get(v).add(new int[]{u, t});
        }

        long[] dis = new long[n];
        Arrays.fill(dis, Long.MAX_VALUE);

        long[] ways = new long[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
        );

        dis[0] = 0;
        ways[0] = 1;
        pq.add(new long[]{0, 0}); 

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long dist = curr[0];
            int node = (int) curr[1];

            if (dist > dis[node])
            continue;

            for (int[] neigh : list.get(node)) {
                int next = neigh[0];
                int time = neigh[1];

                long ndis = dist + time;

                if (ndis < dis[next]) {
                    dis[next] = ndis;
                    ways[next] = ways[node];
                    pq.add(new long[]{ndis, next});
                } 
                else if (ndis == dis[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }

        return (int)(ways[n - 1] % mod);
    }
}
