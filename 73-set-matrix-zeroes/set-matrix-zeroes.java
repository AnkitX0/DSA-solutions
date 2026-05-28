class Solution {
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        boolean validation[][] = new boolean [row][col];

        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){
                if(matrix[i][k] == 0) validation[i][k] = true;
            }
        }


        for(int i = 0; i < row; i++){
            for(int k = 0; k < col; k++){

                if( validation[i][k]) {
                    for(int j = 0; j < col; j++){
                    matrix[i][j] = 0;
                    }
                    for(int j = 0; j < row; j++){
                        matrix[j][k] = 0;
                    }
                }


                
            }


        }
        
    }
}