class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        dirs = [(1,0), (-1,0), (0,1), (0,-1)]
        ROWS, COLS = len(board), len(board[0])
        def backtrack(i, j, wIdx):
            if wIdx == len(word):
                return True
            
            if i < ROWS and i >= 0 and j < COLS and j >= 0 and board[i][j] == word[wIdx]:
                temp = board[i][j]
                board[i][j] = "#"
                for dr, dc in dirs:
                    if backtrack(i+dr, j+dc, wIdx + 1):
                        return True
                board[i][j] = temp
            return False

        for i in range(ROWS):
            for j in range(COLS):
                if backtrack(i, j, 0):
                    return True

        return False


            