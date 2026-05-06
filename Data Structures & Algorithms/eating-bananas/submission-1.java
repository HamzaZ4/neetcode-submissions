class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        


        // upper bound for k is max(piles)
        //lets try the brute force approach

        // 1. find the largest pile
        int max = 0;
        for(int i =0;i<piles.length;i++){
            if(piles[i]>max){
                max = piles[i];
            }
        }

        int time=0;
        int k = Integer.MAX_VALUE;

        int min = 0;

        while(min<=max){
            int guess = (max+min) / 2;
            time = 0;
            for(int f=0; f<piles.length;f++){
                time += Math.ceil((double) piles[f]/guess);
            }
            if(k>guess && time<=h){
                k=guess;
            }
            if(time>h){
                min = guess+1;
            }else{
                max = guess-1;
            }
            
        }
        return k;
    }
}
