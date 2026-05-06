class Solution:
    def isAnagram(self, s: str, t: str) -> bool:

        if len(s) != len(t):
            return False

        abc = [0]*26

        for i in range(len(s)):
            abc[ord('a')-ord(s[i])]+=1
            abc[ord('a')-ord(t[i])]-=1


        for num in abc:
            if num:
                return False

        return True
