class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int sumBananas = 0;
        int max =0;
        for (int pile : piles) {
            max = Math.max(max, pile);
            sumBananas+=pile;
        }

        //the minimum a monkey can spend on a pile is 
        // sumBananas / h
        // why is this : it is the minimum rate to be able to 
        // eat all of the bananas within the given time frame
        max = (int) Math.ceil((double)max/(h/piles.length));
        int min = sumBananas/h; // this is the minimum rate
        // we need to eat all bananas within h hours

        int k = max;
        while(min<=max){
            int guess = (max+min) / 2;
            int time = 0;
            for(int p: piles){
                time += Math.ceil((double) p/guess);
            }
            if(time<=h){
                k=guess;
                max = guess-1;
            }
            else{
                min = guess+1;
            }
            
        }
        return k;
    }
}
