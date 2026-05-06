class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        res = []
        tasks = sorted([[t[0], t[1], i] for i, t in enumerate(tasks)])
        t = tasks[0][0]
        i = 0
        h = []

        while len(res) < len(tasks):
            while (i<len(tasks) and (tasks[i][0]<= t)):
                heapq.heappush(h, (tasks[i][1], tasks[i][2]))
                i+=1
            if h:
                t_diff, og_idx = heapq.heappop(h)

                t+=t_diff
                res.append(og_idx)
            elif i < len(tasks):
                t = tasks[i][0]

        return res

