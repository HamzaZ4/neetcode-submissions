class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        // making our adjacency list ish jsut containing all the edges
        // including the weight and destination we can map to from source
        for(int[] e : times){
            adj
            .computeIfAbsent(e[0], key -> new ArrayList<>())
            .add(new int[]{e[1], e[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();

        for( int i = 1; i<n+1; i++) dist.put(i, Integer.MAX_VALUE);

        dfs(k, 0, dist, adj);
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;

    }

    private void dfs(int node, int time, Map<Integer, Integer> dist,
         HashMap<Integer, List<int[]>> adj
    ){

        if (time >= dist.get(node)) return;

        dist.put(node, time);

        if (!adj.containsKey(node)) return;

        for(int[] edge: adj.get(node)){
            dfs(edge[0], edge[1] + time, dist, adj);
        }
    }
}
