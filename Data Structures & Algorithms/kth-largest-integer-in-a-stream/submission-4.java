class KthLargest {

    private PriorityQueue<Integer> minH ;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.minH = new PriorityQueue<>();
        for(int num : nums){
            minH.offer(num);
            if(minH.size() > this.k){
                minH.poll();
            }
        }
    }
    
    public int add(int val) {
        this.minH.offer(val);
        if(minH.size()>this.k){
            minH.poll();
        }
        return minH.peek();
    }
}
