class KthLargest {

   private PriorityQueue<Integer> pri = new PriorityQueue<>();
   private int k;

   public KthLargest(int k, int[] nums){

    this.k = k;
    for(int num : nums){
        pri.add(num);
        if(pri.size()>this.k){
            pri.remove();
        }
    }
   }

    public int add(int val){
        pri.add(val);
        if(pri.size()>this.k){
            pri.remove();
        }

        return pri.peek();
    }




}
