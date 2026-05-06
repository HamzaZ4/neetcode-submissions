class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        alphab = [0]*128
        res = 0
        l = 0
        for r in range(len(s)):
            while alphab[ord('a') - ord(s[r])] != 0 and l<= r:
                alphab[ord('a') - ord(s[l])]-=1
                l+=1
            alphab[ord('a') - ord(s[r])]+=1
            res = max(res, r-l+1)


        return res

                