class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        resIdx = 0
        maxL = 0

        def check(l, r):
            while l>=0 and r<len(s) and s[l] == s[r]:
                r+=1
                l-=1

            return s[l+1:r]

        for i in range(len(s)):
            odd = check(i-1, i+1)
            even = check(i, i+1)
            
            if len(odd) > maxL:
                maxL = len(odd)
                res = odd
            
            if len(even) > maxL:
                maxL = len(even)
                res = even


        return res


