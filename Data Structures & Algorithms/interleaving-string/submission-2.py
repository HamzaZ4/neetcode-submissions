class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        if len(s1) + len(s2) != len(s3):
            return False

        dp = {}

        def backtrack(i, i1, i2):
            if i == len(s3):
                return (i1 == len(s1) and i2 == len(s2))
            
            if (i1,i2) in dp:
                return dp[(i1,i2)]

            res = False
            if i1 < len(s1) and s1[i1] == s3[i]:
                res = backtrack(i+1, i1+1, i2)

            if not res and i2 < len(s2) and s2[i2]==s3[i]:
                res = backtrack(i+1, i1, i2+1)

            dp[(i1,i2)] = res
            return res
 

        return backtrack(0,0,0)