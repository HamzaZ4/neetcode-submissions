class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n-1 != edges.length){
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> set = new HashSet<>();

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, -1});
        set.add(0);

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int node = pair[0], parent = pair[1];

            for(int nei : adj.get(node)){
                if(nei == parent){
                    continue;
                }
                if (set.contains(nei)){
                    return false;
                }
                set.add(nei);
                q.offer(new int[]{nei, node});
            }
        }
        return set.size() == n;

    }
}
