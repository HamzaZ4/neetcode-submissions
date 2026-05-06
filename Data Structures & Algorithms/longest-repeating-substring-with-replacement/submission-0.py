class Solution:
    def characterReplacement(self, s: str, k: int) -> int:

        # this is a map that maps a letter to the count encountered
        count = {} 

        #pointer to the left side from where we count letter frequencies
        l = 0
        res = 0

        #max frequency encountered up until now
        maxf = 0

        for r in range(len(s)):
            
            # increasing the number of the right element encountered 
            count[s[r]] = 1 + count.get(s[r],0) #defaults to zero if it doesn't exist
            
            # update the max frequency
            maxf = max(maxf, count[s[r]])

            # if the number of non-unique chars in substring is larger than k
            # then we can't take this substring anymore so we undo the counter...
            while (r-l+1) - maxf > k:
                count[s[l]] -= 1
                l+=1
            # the response starts at 0 and increases as substring we can make increases
            res = max(res, r-l + 1)

        return res 