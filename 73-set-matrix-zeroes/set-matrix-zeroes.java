class Solution {
    public void setZeroes(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        boolean validation[][] = new boolean [row][col];

        int colIndex = 1;

        for(int i = 0; i < row; i++){

            if(matrix[i][0] == 0) colIndex = 0;
            
            for(int k = 1; k < col; k++){
                    if(matrix[i][k] == 0) {
                        matrix[0][k] = 0;
                        matrix[i][0] = 0;
                    }                
            }
        }

        System.out.println(Arrays.deepToString(matrix));
        
        for(int i = row - 1; i >= 0; i--){
            for(int k = col - 1; k >= 1; k--){
                if(matrix[i][0] == 0 || matrix[0][k] == 0){
                    matrix[i][k] = 0;
                }
            }
            
            if(colIndex == 0){
                matrix[i][0] = 0;
            }            
        }



      
    }
}