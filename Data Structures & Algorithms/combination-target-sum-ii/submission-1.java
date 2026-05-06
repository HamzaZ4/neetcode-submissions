class Solution {

    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        res = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;

    }


    private void backtrack(int[] candidates, int target, int i,
    List<Integer> cur, int total){
        if(target == total){
            res.add(new ArrayList<>(cur));
            return;
        }

        if(target < total || i >= candidates.length){
            return;
        }

        cur.add(candidates[i]);
        backtrack(candidates, target, i+1, cur, total+candidates[i]);
        cur.remove(cur.size()-1);

        while(i+1< candidates.length && candidates[i] == candidates[i+1]){
            i++;
        }

        backtrack(candidates, target, i+1, cur, total);
    }

}
