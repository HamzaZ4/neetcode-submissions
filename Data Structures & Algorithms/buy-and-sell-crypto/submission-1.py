class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        lowest = prices[0]

        for price in prices[1:]:
            res = max(res, price-lowest)
            lowest = min(price, lowest)

        return res