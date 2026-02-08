class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        int indegree[]=new int [numCourses];
       
        int e=prerequisites.length;
        for(int i=0;i<e;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            list.get(v).add(u);
            indegree[u]++;
        }
        return topologicalSort(indegree,numCourses,list);
    }
    int[] topologicalSort(int indegree[],int n,List<List<Integer>> list) {
        Queue<Integer> que=new LinkedList<>();
        int result[]=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int curr=que.poll();
            result[count++]=curr;
            for(int neigh:list.get(curr)){
                indegree[neigh]--;
               
                if(indegree[neigh]==0)
                {
                    que.add(neigh);
                }
            }
        }
        if(count==n)
        return result;
        else
        return new int[0];
        
    }
}