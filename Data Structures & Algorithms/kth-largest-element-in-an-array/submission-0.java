class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pri = new PriorityQueue<>();

        for(int num: nums){
            pri.add(num);
            if(pri.size() > k){
                pri.poll();
            }
        }

        return pri.peek();

    }
}
