class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //result[i] = #days after ith day before a warmer temp appears
        //so result[i] = number of days until a temp is higher than temperatures[i] 

        // dynamic programming solution
        // break down in iterative sub-problems

        int n = temperatures.length;
        int[] res = new int[n]; //this is our answer
        // we iterate from the 
        for(int i = n - 2; i>=0; i--){

            // j represents the next day after the one currently being evaluated

            int j = i+1;
            
            // an operation to continue while either the temperature is greater than
            // the date being evaluated and as long as we're under n
            while( j < n && temperatures[j] <= temperatures[i] ) {

                
                // basically j is just going to end up pointing a higher temperature that follows
                // the ith one, or n if there are no hotter days coming

                // this is a case where, if we got to a temp that has no higher temp in the future
                // we'd only get this if temp[i] is bigger than temp[j]
                //at this point we just assume there is no temperature larger than temp[i]
                if(res[j] == 0){
                    j=n;
                    break;
                }
                
                //here we skip res[j] steps ( we know temp[i] is larger than temp[j], so
                // no reason to compare temp[i] with anyting up until temp[j+res[j]])
                j+=res[j];

            }

            // if smaller than n it means that there actually is a larger temperature
            if(j<n){
                res[i] = j - i;
            }

            
        }

        return res;
    }
}
