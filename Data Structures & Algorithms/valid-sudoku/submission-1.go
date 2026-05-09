func isValidSudoku(board [][]byte) bool {
    rows := make([]map[byte]bool, 9)
    cols := make([]map[byte]bool, 9)
    sq := make([]map[byte]bool, 9)

    for i := 0; i < 9; i++ {
        rows[i] = make(map[byte]bool)
        cols[i] = make(map[byte]bool)
        sq[i] = make(map[byte]bool)
    }

    ROWS, COLS := len(board), len(board[0])
    for r:=0; r< ROWS; r++ {
        for c:= 0; c < COLS; c++{
            if board[r][c] == '.' {
                continue
            }
            boxIndex := (r/3)*3 + (c/3)
            if rows[r][board[r][c]] || cols[c][board[r][c]] || sq[boxIndex][board[r][c]] {
                return false
            }
            rows[r][board[r][c]] = true
            cols[c][board[r][c]] = true
            sq[boxIndex][board[r][c]] = true
        }
    }

    return true
}
