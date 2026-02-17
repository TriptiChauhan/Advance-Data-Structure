class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int []> pq=new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        int n=heights.length;
        int m=heights[0].length;
        int dis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dis[i][j]=Integer.MAX_VALUE;
            }
        }
        dis[0][0]=0;
        pq.add(new int[]{0,0,0});

        int delrow[]={-1,0,1,0};
        int delcol[]={0,1,0,-1};

       while(!pq.isEmpty()){
        int curr[]=pq.poll();
        int diff=curr[0];
        int row=curr[1];
        int col=curr[2];

        if(row==n-1 && col==m-1)
        return diff;

            for(int i=0;i<4;i++){
                int newr=row+delrow[i];
                int newc=col+delcol[i];

                if(newr>=0 && newr<n && newc>=0 && newc<m){
                    int neweffort=Math.max(Math.abs(heights[row][col]-heights[newr][newc]),diff);
                if(neweffort<dis[newr][newc]){
                    dis[newr][newc]=neweffort;
                    pq.add(new int[]{neweffort,newr,newc});
                }
                }
        }
       }
    return 0;
        
    }
}