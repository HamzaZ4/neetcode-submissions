class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        ROWS, COLS = len(heights), len(heights[0])
        pac, atl = set(), set()

        def dfs(r,c, visit,prevHeight):
            if((r,c) in visit or
                r < 0 or c < 0 or
                r == ROWS or c == COLS or
                heights[r][c] < prevHeight):
                    return
            
            visit.add((r,c))

            dfs(r+1, c, visit, heights[r][c])
            dfs(r, c-1, visit, heights[r][c])
            dfs(r, c+1, visit, heights[r][c])
            dfs(r-1, c, visit, heights[r][c])

        for c in range(COLS):
            dfs(0, c, pac, heights[0][c]) # dfs for all the one
            # we know can attain the pacific (top)

            #this is to handle going from all the cells that
            # we know can attain the atlantic (bottom)
            dfs(ROWS-1, c, atl, heights[ROWS-1][c])

        for r in range(ROWS):
            #dfs for all the cells on the water from the left side ( pacific )
            dfs(r,0, pac, heights[r][0])
            #dfs for all the cells on the water from the right side ( atlantic )
            dfs(r,COLS-1, atl, heights[r][COLS-1])

        res = []

        for r in range(ROWS):
            for c in range(COLS):
                if (r,c) in pac and (r,c) in atl:
                    res.append([r,c])

        return res

