class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        prices = [float("inf")] * n

        prices[src] = 0


        for i in range(k+1):
            updatedPrices = prices[:]
            for s, d, c in flights:
                if prices[s] == float("inf"):
                    continue

                if prices[s] + c < updatedPrices[d]:
                    updatedPrices[d] = prices[s] + c

            prices = updatedPrices

        return prices[dst] if prices[dst] != float("inf") else -1            