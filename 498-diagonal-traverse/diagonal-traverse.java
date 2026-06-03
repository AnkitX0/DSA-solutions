class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int row = mat.length;
        int col = mat[0].length;

        if (row == 0 || col == 0) return new int[0];
        int[] result = new int[row * col];
        int index = 0;

        int i = 0;
        int j = 0;

        boolean up = true;

        while( i < row && j < col){

            if(up){
                while(i > 0 && j < col - 1){
                    result[index++] = mat[i][j];
                    i--;
                    j++;
                }
                result[index++] = mat[i][j];

                if(j == col - 1){
                    i ++;
                }
                else {
                    j++;
                }
            }

            else{

                while( j > 0 &&  i < row - 1){
                    result[index++] = mat[i][j];
                    j--;
                    i++;
                }
                result[index++] = mat[i][j];

                if(i == row - 1){
                    j++;
                }
                else {
                    i++;
                }
            }
            up = !up;
        }

        return result;       
                 

    }
}