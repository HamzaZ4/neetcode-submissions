class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        if len(piles) > h:
            return -1
        n = max(piles)
        l, r = 1, n
        res = n


        while l <= r:
            m = (r + l)//2
            if self.canEat(piles, m, h):
                res = m
                r = m -1
            else:
                l = m + 1

        return res

    def canEat(self, piles, k, h):
        s = 0

        for p in piles:
            s += (p+k-1)//k
        
        return s <= h

