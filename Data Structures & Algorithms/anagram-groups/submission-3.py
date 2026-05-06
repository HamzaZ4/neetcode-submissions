class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        
        anags = {}

        for st in strs:
            key = "".join(sorted(st)) 
            if key in anags:
                anags[key].append(st)
            else:
                anags[key] = [st]

        
        res = [s for _, s in anags.items()]
        return res