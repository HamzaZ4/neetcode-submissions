class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        

        adj = [[] for _ in range(n)]

        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        visited = set()

        def dfs(node):
            for nei in adj[node]:
                if nei not in visited:
                    visited.add(nei)
                    dfs(nei)
        
        res = 0

        for node in range(n):
            if node not in visited:
                dfs(node)
                res+=1

        return res

