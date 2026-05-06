class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            int[] alpha = new int[26];
            for(char c : str.toCharArray()){
                alpha[c-'a']+=1;
            }
            String key = Arrays.toString(alpha);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());

    }
}
