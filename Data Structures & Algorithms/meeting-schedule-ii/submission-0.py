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

        time = []
        for i in intervals:
            time.append((i.start, 1))
            time.append((i.end, -1))

        time.sort(key=lambda x : (x[0], x[1]))

        res = count = 0

        for t in time:
            # count = number of concurrent meetings we have
            count += t[1] # im in a meeting == +1, not in a meeting == -1
           
           # max number of concurrent meetings = min number of days we need
            res = max(res, count) #
        
        return res
