class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        
        int row = matrix.length;
        int col = matrix[0].length;



        // row check
        for (int i = 0; i < col; i++){
            int x = 0;
            int y = i;
            int res = matrix[x][y];
            while( y < col && x < row){
                if(matrix[x][y] != res) return false;
                y++;
                x++;
            }

        }


        // Colums check

        for (int i = 1; i < row; i++){
            int x = i;
            int y = 0;
            int res = matrix[x][y];
            while( y < col && x < row){
                if(matrix[x][y] != res) return false;
                y++;
                x++;
            }

            
        }


        return true;

    }
}