class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pri = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for(int[] coor : points){
            int dist = coor[0]*coor[0] + coor[1]*coor[1];
            pri.offer(new int[]{dist,coor[0],coor[1]});
        }
        int[][] result = new int[k][2];
        for(int i =0;i<k;i++){
            int[] aCoor = pri.poll();
            result[i] = new int[]{aCoor[1],aCoor[2]};
        }
        return result;
    }
}
