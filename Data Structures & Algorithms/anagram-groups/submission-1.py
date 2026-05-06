class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        anags = {}

        for s in strs:
            sor = "".join(sorted(s))
            if sor in anags:
                anags[sor].append(s)
            else:
                anags[sor] = [s]

        res = [ s for _, s in anags.items() ] 

        return res