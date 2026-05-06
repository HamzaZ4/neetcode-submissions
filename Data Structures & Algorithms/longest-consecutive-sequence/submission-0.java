class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for(int num: nums){
            numSet.add(num);
        }

        int longest = 0;

        for(int num: numSet){
            // we're trying to go straight to the 
            // possible starts of sequences ( has no precedent )
            if(!numSet.contains(num-1)){ 
                //we are at the first elemetn
                int length = 1;
                //keep increasing while we can
                while(numSet.contains(num+length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
