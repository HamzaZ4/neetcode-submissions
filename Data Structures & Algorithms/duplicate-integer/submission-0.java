class Solution {
    public boolean hasDuplicate(int[] nums) {

        int val = 0;
        for(int i =0;i<nums.length-1;i++){
            val=nums[i];
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]==val){
                    return true;
                }
            }
        }
        return false;
    }
}
