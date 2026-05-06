class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pri = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int[] pt : points){
            int dist = pt[0]*pt[0] + pt[1]*pt[1];
            pri.add(new int[]{dist, pt[0], pt[1]});
        }

        int[][] results = new int[k][2];

        for(int i = 0; i < k; i++){
            int[] coor = pri.remove();
            results[i] = new int[]{coor[1], coor[2]};
        }

        return results;
    }

}
