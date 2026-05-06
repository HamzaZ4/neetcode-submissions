class Solution {
    public int numDecodings(String s) {

        if (s.length() == 0) return 0;

        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for(int i = 2;i<dp.length;i++){
            if(s.charAt(i-1) != '0' ){
                dp[i]+=dp[i-1];
            }
            int two = Integer.parseInt(s.substring(i-2, i));
            if(two<=26 && s.charAt(i-2)!='0'){
                dp[i] += dp[i-2];
            }
        }

        return dp[dp.length-1];
    }
}
