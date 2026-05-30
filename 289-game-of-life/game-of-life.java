class Solution {
    int m, n;
    public void gameOfLife(int[][] board) {
        
        this.n = board[0].length;
        this.m = board.length;

        // int[][] result = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int live = checkNeighbor(i, j, board);
                if(board[i][j] == 1) {
                    if((live == 2 || live == 3)){
                        board[i][j] = 3;
                    }   
                    else board[i][j] = 4;
             }
                else {
                    if (live == 3) {
                        board[i][j] = 2;
                    }
                    else board[i][j] = 5;
                }     
            }

        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                
                if(board[i][j] == 5) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
                else if (board[i][j] == 3) board[i][j] = 1;
                else board[i][j] = 0;
            }
        }

       

    }

    private int checkNeighbor(int i, int j, int[][]board){
        int counter = 0;

        
        if (i != m - 1 )  counter += wasAlive(board[i + 1][j]);
        if (i != 0 ) counter += wasAlive(board[i - 1][j]);
        
        if (j != n - 1) counter += wasAlive(board[i][j + 1]);
        if (j != 0 ) counter += wasAlive (board[i][j - 1]);

        if(i != 0 && j != 0 ) counter += wasAlive(board[i - 1][j - 1]);
        if(i != m - 1 && j != n - 1) counter += wasAlive(board[i + 1][j + 1]);

        if (i != 0 && j != n - 1 ) counter += wasAlive(board[i - 1][j + 1]);
        if (i != m - 1 && j != 0 ) counter += wasAlive(board[i + 1][j - 1]);

        return counter;
    }

    private int wasAlive(int val) {
    return (val == 1 || val == 3 || val == 4) ? 1 : 0;
    }
}