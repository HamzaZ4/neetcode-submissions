class Solution {
    public boolean isValid(String s) {
        
        if(s.length()%2!=0 ){
            return false;
        }
        int length = s.length();
        
        HashMap<Character, Character> pairs = new HashMap<Character, Character>();
        Stack<Character> stack = new Stack<>();

        pairs.put('}','{');
        pairs.put(')','(');
        pairs.put(']','[');

        for(int i =0;i<s.length();i++){
            char par = s.charAt(i);
            if(pairs.containsKey(par)){
                if(!stack.isEmpty() && pairs.get(par).equals(stack.peek())){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(par);
            }
        }

    return stack.isEmpty();

    }
}
