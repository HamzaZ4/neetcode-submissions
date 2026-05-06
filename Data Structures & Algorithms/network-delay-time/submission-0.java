class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for(int[] e : times){
            adj
            .computeIfAbsent(e[0], key -> new ArrayList<>())
            .add(new int[]{e[1], e[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        pq.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>();

        int t = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int w1 = curr[0];
            int node = curr[1];

            // we continue because if it was already added and
            // we're only just getting to this "node"
            // it means we are at a distance higher
            // previously found for this node
            if(visited.contains(node)) continue;

            visited.add(node);

            t = w1;

            // only if it has outgoing edges
            if(adj.containsKey(node)){
                for(int[] edge: adj.get(node)){
                    int next = edge[0], w2 = edge[1];
                    if(!visited.contains(next)){
                        pq.offer(new int[]{w2 + w1, next});
                    }
                }
            }
            

        }

        return visited.size() == n ? t : -1;





    }
}
