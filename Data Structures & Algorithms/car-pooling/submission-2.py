import heapq

class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        trips.sort(key=lambda x: x[1])

        min_heap = []

        for cap, orig, dest in trips:

            while min_heap and min_heap[0][0] <= orig:
                dropoff, passengers = heapq.heappop(min_heap)
                capacity += passengers

            if cap <= capacity:
                heapq.heappush(min_heap, (dest, cap))
                capacity -= cap
            else:
                return False

        return True