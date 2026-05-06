class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> done = new HashSet<>();
        List<Integer> res = new ArrayList<>();


        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] prereq : prerequisites){
            indegree[prereq[0]] += 1;
            adj.get(prereq[1]).add(prereq[0]);
        }       

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                q.add(i);
            }
        }
        
        int finished = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            finished+=1;
            for (int nei : adj.get(node)){
                indegree[nei] -=1;
                if (indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }

        if (finished != numCourses){
            return new int[0];
        }

        int[] out = new int[numCourses];

        for(int i =0; i< numCourses; i++){
            out[i] = res.get(i);
        }

        return out;
        
    
    }
}
