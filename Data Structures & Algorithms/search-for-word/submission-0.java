class Solution {
    private int ROWS, COLS;
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for(int n = 0; n< ROWS; n++){
            for(int m =0; m< COLS; m++){
                if(dfs(0, m, n, board, word)){
                    return true;
                }
            }
        }
        return false;


    }


    private boolean dfs(int i, int c, int r, char[][] board, String word){
        
        if(i == word.length()){
            return true;
        }

        if(r < 0 || c < 0 || c >= COLS || r >= ROWS
         || word.charAt(i) != board[r][c] || visited[r][c]){
            return false;
        }

        visited[r][c] = true;

        boolean res = 
        dfs(i+1, c+1, r, board, word)
        ||  dfs(i+1, c-1, r, board, word)
        ||  dfs(i+1, c, r+1, board, word)
        ||  dfs(i+1, c, r-1, board, word);
        visited[r][c] = false;

        return res;

    }
}
