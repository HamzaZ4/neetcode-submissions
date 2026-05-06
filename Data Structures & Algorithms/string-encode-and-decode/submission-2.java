class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int start = 0;
        while(start<str.length()){
            int end = start;
            while (str.charAt(end)!='#'){
                end++; //indicates the end of the number
            }
            int len = Integer.parseInt(str.substring(start, end));

            start = end+1;
            end = start+len;
            strs.add(str.substring(start,end));
            start = end;

        }
        
        return strs;
    }
}
