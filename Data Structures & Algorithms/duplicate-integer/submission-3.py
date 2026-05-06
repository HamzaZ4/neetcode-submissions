class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        ma = {}
        for n in nums:
            if n in ma:
                return True
            else:
                 ma[n] = 1

        return False