class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve (char[][] board){

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                if(board[i][j] == '.') {
                    for (char a = '1'; a <= '9'; a++){
                        if(check (board, i, j, a)){
                            board[i][j] = a;
                            if (solve(board)) return true;;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean check(char[][]board, int l, int m, char val){
        for (int i = 0; i < 9; i++){
            if (board[i][m] == val) return false;
            if (board[l][i] == val) return false;
        }
        l /= 3;
        m /= 3;
        
        for (int i = l*3; i < l*3+3; i++){
            for (int j = m*3; j < m*3 + 3; j++){
                if(board[i][j] == val) return false;
            }
        }
        return true;
    }
}