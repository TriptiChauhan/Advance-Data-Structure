
// Brute force--> Gives TLE on 3 testcases

// class Solution {
//     public int maxEvents(int[][] events) {
//         Arrays.sort(events,(a,b)->Integer.compare(a[1],b[1]));
//         int count=0;
//         boolean dayused[]=new boolean[100001];
//         for(int event[]:events){
//             int start=event[0];
//             int end=event[1];
//             for(int d=start;d<=end;d++){
//               if(!dayused[d]){
//                     dayused[d]=true;
//                     count++;
//                     break;
//                 }
//             }
//         }
//         return count;
//     }
// }



class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int i=0;
        int count=0;
        int n=events.length;

        for(int d=1;d<=100000;d++){

            while(i<n && events[i][0]==d){
                pq.add(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()<d){
                pq.poll();
            }

            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }

            if(i>=n && pq.isEmpty())
            break;
        }
        return count;
    }
}