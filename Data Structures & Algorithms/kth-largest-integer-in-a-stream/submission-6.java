class KthLargest {

    private PriorityQueue<Integer> pri = new PriorityQueue<Integer>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num: nums){
            pri.add(num);
            if (pri.size() >k){
                pri.remove();
            }
        }
    }
    
    public int add(int val) {
        pri.add(val);
        if (pri.size() > k){
            pri.remove();
        }
        return pri.peek();
    }
}
