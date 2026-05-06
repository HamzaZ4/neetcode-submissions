class Solution {
    String[] nums = {"", "", "abc","def","ghi","jkl", "mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;

    }

    public void backtrack(int i, String cur, String digits){
        
        if(i == digits.length()){
            res.add(cur);
            return;
        }
        String chars = nums[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()){
            backtrack(i+1, cur+c, digits);
        }

    }

}
