class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];
            list.get(u).add(new int[]{v, w});
        }

      
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{0, src, 0});

        
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];
            int stop = curr[2];

            
            if(node == dst)
                return cost;

            if(stop > k || stop > stops[node])
                continue;

            stops[node] = stop;

            for(int[] neigh : list.get(node)){
                int next = neigh[0];
                int weight = neigh[1];

                pq.add(new int[]{cost + weight, next, stop + 1});
            }
        }

        return -1;
    }
}
