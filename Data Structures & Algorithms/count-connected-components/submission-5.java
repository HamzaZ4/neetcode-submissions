class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i ++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i ++){
            if (!visited[i]){
                res+=1;
                connectAComponent(visited, adj, i);
            }
        }
        return res;
    
    }

    private void connectAComponent(boolean[] visited, List<List<Integer>> adj, int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;
        while (!q.isEmpty()){
            int cur = q.poll();
            for(int nei : adj.get(cur)){
                if (!visited[nei]){
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }
    }
}
