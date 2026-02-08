class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            list.get(v).add(u);
            indegree[u]++;
        }
        
        List<Integer> res=new ArrayList<>();

        Queue<Integer> que=new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
            que.add(i);
        }

        while(!que.isEmpty()){
            int curr=que.poll();
            res.add(curr);
            for(int neigh:list.get(curr)){
                indegree[neigh]--;

                if(indegree[neigh]==0)
                que.add(neigh);
            }
        }
        if(res.size()==numCourses)
        return true;

        return false;
    }
}