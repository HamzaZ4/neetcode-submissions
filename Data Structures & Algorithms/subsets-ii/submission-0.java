class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtrack(List<Integer> sub, int i, int[] nums){
        if(i == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        backtrack(sub, i+1, nums);
        sub.remove(sub.size()-1);
        while(i+1< nums.length && nums[i]==nums[i+1]){
            i++;
        }
        backtrack(sub, i+1, nums);
    }
}
