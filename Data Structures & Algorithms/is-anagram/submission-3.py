class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        alp = [0]*26

        for l in s:
            alp[ord('a') - ord(l)] +=1
        for n in t:
            alp[ord('a') - ord(n)] -=1

        return alp == [0]*26