class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hmap = defaultdict(int)

        for num in nums:
            hmap[num] = 1 + hmap.get(num, 0)

        freq = []

        for num, fre in hmap.items():
            heapq.heappush(freq, (fre, num))
            if len(freq) > k:
                heapq.heappop(freq)

        res = [n for _, n in freq]

        return res



        


