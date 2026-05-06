"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
          # to minimize the number of days,
          # we need to maximize the number of intervals
          # per day
          # to do that we 

        if intervals == []:
            return 0
        maximum = max(i.end for i in intervals)
        difs = [0] * (maximum+1)
        for interval in intervals:
            difs[interval.start] += 1
            difs[interval.end] -= 1

        res = count = 0

        for dif in difs:
            count += dif
            res = max(res, count)
        
        return res
