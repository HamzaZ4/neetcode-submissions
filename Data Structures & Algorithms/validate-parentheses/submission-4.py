class Solution:
    def isValid(self, s: str) -> bool:
        
        st = []
        mapping = {")": "(", "}": "{", "]": "["}
        for c in s:
            if c in "({[":
                st.append(c)
            else:
                if not st or st.pop() != mapping[c]:
                    return False
                
        return len(st) == 0