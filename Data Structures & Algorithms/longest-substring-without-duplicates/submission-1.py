class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        seen = {}
        l = 0
        maxLen = 0

        for r, char in enumerate(s):
            if char in seen and seen[char] >= l:
                l = seen[char] + 1
            seen[char] = r
            maxLen = max(r-l+1, maxLen)

        return maxLen


