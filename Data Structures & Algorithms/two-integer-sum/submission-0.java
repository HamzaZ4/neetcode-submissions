class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int diff=0;
        for(int i=0;i<nums.length;i++){
            diff = target-nums[i];
            if(map.containsKey(target-diff)){
                return new int[]{map.get(target-diff),i};
            }
            else{
                map.put(diff, i );
            }
        }
        return new int[2];
    }
}
