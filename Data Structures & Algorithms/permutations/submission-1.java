class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        backtrack(new ArrayList<>(), nums, new boolean[nums.length] );
        return res;
    }

    private void backtrack(List<Integer> cur, int[] nums, boolean[] pick ){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=0; i < nums.length; i++){
            if(!pick[i]){
                cur.add(nums[i]);
                pick[i] = true;
                backtrack(cur, nums, pick);
                pick[i] = false;
                cur.remove(cur.size() - 1);
            }
        }

    }
}
