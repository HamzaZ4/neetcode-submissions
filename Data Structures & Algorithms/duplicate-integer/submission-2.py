class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        ma = defaultdict(bool)
        for n in nums:
            if ma[n] == True:
                return True
            else:
                ma[n]=True

        return False