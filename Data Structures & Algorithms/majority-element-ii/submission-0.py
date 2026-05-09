class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        res = []
        l = len(nums)
        m = {}
        for n in nums:
            m[n] = m.get(n, 0) + 1

        for k, v in m.items():
            if v > l/3:
                res.append(k)

        return res