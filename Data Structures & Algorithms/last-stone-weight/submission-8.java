class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> n = new PriorityQueue<Integer>();

        for( int s : stones){
            n.add(-s);
        }
        while (n.size() > 1){
            int s1 = -n.remove();
            int s2 = -n.remove();

            if (s1==s2){
                continue;
            }
            else{
                if(s1 > s2){
                    n.add(-(s1-s2));
                }
                else{
                    n.add(-(s2-s1));
                }
            }
        }
        return n.size() == 1 ? -n.remove() : 0;
    }
}
