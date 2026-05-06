class Solution {
    public int minCostConnectPoints(int[][] points) {
        int N = points.length;
        HashMap<Integer, List<int[]>> adj = new HashMap<>();

        for(int i = 0; i < N; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1; j < N; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{j, dist});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{i, dist});
            }
        }

        int res = 0;

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{0,0});

        while(visited.size() <  N){
            int[] curr = pq.poll();
            int cost = curr[1];
            int i = curr[0];

            if(visited.contains(i)) continue;
            res += cost;
            visited.add(i);
            for( int[] nei: adj.getOrDefault(i, new ArrayList<>())){
                int neiCost = nei[1];
                int neiIdx = nei[0];
                if(!visited.contains(neiIdx)){
                    pq.offer(new int[]{
                        neiIdx, neiCost
                    });
                }
            }
        }

        return res;

    }
}
