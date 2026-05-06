class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<>();
        backtrack(0, res, sub, nums, target);
        return res;
    }

    public void backtrack(int i, List<List<Integer>> res, List<Integer> sub, int[] nums, int target){
        // we'll do something where we have a dynamic target

        //base case
        if(target == 0){
            res.add(new ArrayList<>(sub));
            return;
        }
        if(i >= nums.length || target < 0){
            return;
        }

        //branch where we take it
        sub.add(nums[i]);
        //if we took it, we could either stay here again
        backtrack(i, res, sub, nums, target - nums[i]);

        //case where we don't want it
        sub.remove(sub.size()-1);
        //we go to the next number in nums
        backtrack(i+1, res, sub, nums, target);
    }
}
