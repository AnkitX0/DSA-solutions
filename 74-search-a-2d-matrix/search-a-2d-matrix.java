class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        if(target > matrix[r -1][c -1] || target < matrix[0][0]) return false;

        int row = 0;

        while(row < r){
            if(target > matrix[row][matrix[0].length -1]) row++;
            else break;
        }

        int left = 0;
        int right = c -1 ;
        while(left <= right){

            int mid = left + (right - left) /2;

            if(target > matrix[row][mid]) left = mid + 1;

            else if( target < matrix[row][mid]) right = mid -1;

            else return true;
        }
        
        return false;
    }
}