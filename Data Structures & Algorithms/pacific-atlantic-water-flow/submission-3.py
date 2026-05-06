class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        
        ROWS, COLS = len(heights), len(heights[0])
        directions = [(1,0), (0,1), (-1,0), (0,-1)]

        pac = [[False]* COLS for _ in range(ROWS) ]
        atl = [[False]* COLS for _ in range(ROWS) ]

        def bfs(source, ocean):
            q = deque(source)
            while q:
                r, c = q.popleft()
                ocean[r][c] = True
                for dr, dc in directions:
                    nr, nc = dr+r, dc + c
                    if(0<= nr < ROWS and 0<=nc< COLS 
                    and not ocean[nr][nc] 
                    and heights[nr][nc] >= heights[r][c]):
                        q.append((nr,nc))

        pacific_coast = []
        atlantic_coast = []

        for r in range(ROWS):
            pacific_coast.append((r, 0))
            atlantic_coast.append((r, COLS-1))

        for c in range(COLS):
            pacific_coast.append((0,c))
            atlantic_coast.append((ROWS-1, c))

        bfs(pacific_coast, pac)
        bfs(atlantic_coast, atl)

        res = []
        for r in range(ROWS):
            for c in range(COLS):
                if pac[r][c] and atl[r][c]:
                    res.append([r,c])

        return res

                    



