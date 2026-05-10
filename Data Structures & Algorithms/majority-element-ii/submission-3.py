class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:

        if len(nums) == 1 or len(nums)==2:
            return nums

        cand1, cand2 = None, None
        ct1, ct2 = 0, 0


        for num in nums:
            if num == cand1:
                ct1+=1
            elif num == cand2:
                ct2+=1
            elif ct1 == 0:
                cand1 = num
                ct1 = 1
            elif ct2 == 0:
                cand2 = num
                ct2 = 1
            else:
                ct2-=1
                ct1-=1

        res = []
        n = len(nums)
        if nums.count(cand1) > n/3:
            res.append(cand1)
        if nums.count(cand2) > n/3:
            res.append(cand2)

        return res