class Solution:
    def isPalindrome(self, s: str) -> bool:
        l = 0

        for r in range(len(s)-1, -1, -1):
            if not s[r].isalnum():
                continue
            while not s[l].isalnum():
                l+=1

            if s[r].lower() != s[l].lower():
                return False

            l+=1


        return True