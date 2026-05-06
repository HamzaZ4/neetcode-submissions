class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];
        // each index represents the number of occurences

        for(int i=0;i<freq.length;i++){
            freq[i] = new ArrayList<>();
        }

        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;

        for(int j= freq.length-1;j>0 && index < k;j--){
            for(int n : freq[j]){
                res[index++] = n;
                if(index ==k){
                    return res;
                }
            }
        }

        return res;


    }
}
