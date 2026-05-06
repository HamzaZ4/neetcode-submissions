class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

       for(int sellPrice : prices){
        maxP = Math.max(maxP,sellPrice - minBuy);
        minBuy = Math.min(minBuy, sellPrice);
       }

       return maxP;
    }
}
