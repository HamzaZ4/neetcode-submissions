class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int k;
//binary search tree seems better for some reason
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for(int num: nums){
            minHeap.offer(num);
            if(minHeap.size()>k){
                minHeap.poll(); // we dont need anything that is above the kth largest value
                // so we get rid of them ( no need for them )
            }
        }

    }
    
    public int add(int val) {
        minHeap.offer(val); // we add a value and check, 
        if(minHeap.size()>k){
            minHeap.poll(); // we reject the value if it is going beyond k ( we only want kth largest )
        }
        return minHeap.peek();
    }

}
