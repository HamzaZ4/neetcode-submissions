class Solution {

    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //start by sorting everything
        Arrays.sort(candidates);
        // then we proceed to the same backtracking algorithm, it's always the dfs tree,
        // initialize all of the arrays I will need
        res = new ArrayList<>();
        backtrack(0, new ArrayList<>(), target, 0, candidates);
        return res;
    }

    public void backtrack(int i, List<Integer> sub, int target, int total, int[] candidates){
        
        if(target == total){
            res.add(new ArrayList<>(sub));
            return;
        }

        if(target < total || i >= candidates.length){
            return;
        }

        sub.add(candidates[i]);
        backtrack(i+1, sub, target, total+candidates[i], candidates);
        sub.remove(sub.size()-1);

        while(i < candidates.length -1 && candidates[i] == candidates[i+1] ){
            i++;
        }
        backtrack(i+1, sub, target, total, candidates);
    }


}
