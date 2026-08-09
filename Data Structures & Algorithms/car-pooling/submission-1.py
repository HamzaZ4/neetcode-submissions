class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        curCapacity = capacity

        trips.sort(key=lambda x: x[1])


        min_heap = []
        size = 0

        for cap, orig, dest in trips:

            while min_heap and min_heap[0][0] <= orig:
                dropoff, passengers = heapq.heappop(min_heap)
                capacity += passengers

            capacity -= cap

            if capacity < 0:
                return False

            heapq.heappush(min_heap, (dest, cap))

        return True