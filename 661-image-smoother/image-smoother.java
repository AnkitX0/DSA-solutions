class Solution {
    int[][]img;
    int row, col;

    public int[][] imageSmoother(int[][] img) {
        this.img = img;
        row = img.length;
        col = img[0].length;
        
        int[][] result = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result[i][j] = sum(i, j);
            }
        }

        return result;
    }

    private int sum (int i, int j){
        int sum = img[i][j];
        int count = 1;

        if(i > 0){
            sum+= img[i - 1][j];
            count++;
        } 
        if (j > 0){
            sum+= img[i][j - 1];
            count++;
        }

        
        if (i < row - 1 ){
            sum+= img[i + 1][j];
            count++;
        }
        if (j < col - 1){
            sum+= img[i][j + 1];
            count++;
        }

        if(i > 0 && j > 0){
            sum+= img[i - 1][j - 1];
            count++;
        } 
        if (j < col - 1 && i < row - 1){
            sum+= img[i + 1][j + 1];
            count++;
        }


        if(i > 0 && j < col - 1 ){
            sum+= img[i - 1][j + 1];
            count++;
        } 
        if (j > 0 && i < row - 1){
            sum+= img[i + 1][j - 1];
            count++;
        }

        return sum/count;
    }
}