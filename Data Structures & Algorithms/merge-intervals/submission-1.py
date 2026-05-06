class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key = lambda pair: pair[0])
        out = [intervals[0]]

        for s, e in intervals:
            lastEnd = out[-1][1]

            if s <= lastEnd:
                out[-1][1] = max(e, lastEnd)
            else:
                out.append([s,e])

        return out