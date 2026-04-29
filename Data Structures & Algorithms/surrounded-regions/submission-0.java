class Solution {

    /** 
        Solution is to find border Os which is for sure 
        not surrounded and find adjacent Os and mark 
        all of them to temp char 'T'. At the end, 
        mark remaining Os to Xs and Ts back to Os.
     */ 

    private int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;

        for(int r=0; r<ROWS; r++) {
            if(board[r][0] == 'O')
                dfs(board, r, 0);
            
            if(board[r][COLS-1] == 'O')
                dfs(board, r, COLS-1);
        }

        for(int c=0; c<COLS; c++) {
            if(board[0][c] == 'O')
                dfs(board, 0, c);

            if(board[ROWS-1][c] == 'O')
                dfs(board, ROWS-1, c);
        }

        for(int r=0; r<ROWS; r++) {
            for(int c=0; c<COLS; c++) {
                if(board[r][c] == 'O')
                    board[r][c] = 'X';
                
                if(board[r][c] == 'T')
                    board[r][c] = 'O';
            }
        }
        
    }

    private void dfs(char[][] board, int r, int c) {
        if(r<0 || c<0 || r>=ROWS || c>=COLS 
            || board[r][c] != 'O') {
                return;
        }

        // Set to temp variable. Later set it back to 0 once found all border 0's
        board[r][c] = 'T';

        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);

    }
}
