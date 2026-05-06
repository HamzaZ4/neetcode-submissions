class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n, cur = len(points), 0
        dist = [float('inf')]*n
        visited = [False]*n
        edges, res = 0, 0

        while edges<n-1:
            visited[cur] = True
            nextNode = -1

            for i in range(n):
                if visited[i]:
                    continue

                curDist = (abs(points[i][0] - points[cur][0]) +
                abs(points[cur][1] - points[i][1]))
                dist[i] = min(curDist, dist[i])

                if nextNode == -1 or dist[i] < dist[nextNode]:
                    nextNode = i

            res += dist[nextNode]
            cur = nextNode
            edges+=1

        return res