class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        for(String s: strs){
            int[] alpha = new int[26];
            for(char c : s.toCharArray()){
                alpha[c-'a']+=1;
            }
            String key = Arrays.toString(alpha);
            hmap.putIfAbsent(key, new ArrayList<>());
            hmap.get(key).add(s);
        }

        return new ArrayList<>(hmap.values());
    }

}
