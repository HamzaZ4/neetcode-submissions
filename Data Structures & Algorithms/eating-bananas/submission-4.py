class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)
        res = r
        while l <= r:
            mid = (r + l) // 2
            if self.canEat(mid, h, piles):
                r = mid - 1
                res = mid
            else:
                l = mid + 1
        
        return res
        


    def canEat(self,k, h, piles):
        for p in piles:
            h -= (p+k-1) // k
        
        return h >= 0