class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0 ; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
         
        for(int[] prereq : prerequisites){
            indegree[prereq[0]] += 1;
            adj.get(prereq[1]).add(prereq[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int finished = 0;


        while(!q.isEmpty()){
            int node = q.poll();
            finished++;
            for(int next: adj.get(node)){
                indegree[next] -= 1;
                if (indegree[next] == 0){
                    q.add(next);
                }
            }
        }

        return finished == numCourses;


    }
}
