class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = [[] for i in range(n)]
        visit = [False]*n

        for u,v in edges:
            adj[u].append(v)
            adj[v].append(u)
        

        def bfs(node):
            q = deque()
            visit[node] = True
            q.append(node)
            while q:
                cur = q.popleft()
                for nei in adj[cur]:
                    if visit[nei] == False:
                        visit[nei] = True
                        q.append(nei)

        total = 0
        for i in range(n):
            if visit[i] == False:
                visit[i] = True
                bfs(i)
                total+=1

        return total

