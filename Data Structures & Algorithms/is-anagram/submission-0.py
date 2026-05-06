class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        letters = {}
        for n in s:
            if n in letters.keys():
                letters[n] = 1 + letters[n]
            else:
                letters.update({n:1})
        for j in t:
            if j in letters.keys():
                letters[j] = letters[j] - 1
            else:
                letters.update({j:1})
        
        for x in letters:
            if(letters[x]!=0):
                return False
        
        return True
