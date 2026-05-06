class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        if not strs:
            return ".?$%"
        return "*&^)".join(strs)
    def decode(self, s: str) -> List[str]:

        if s == ".?$%":
            return []
        else:
            return s.split("*&^)")
        

        
        

