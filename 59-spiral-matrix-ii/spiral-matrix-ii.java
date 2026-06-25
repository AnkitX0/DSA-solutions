class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] mat = new int[n][n];

        int top = 0, bottom = n , right = n, left  = 0;
        int ele = 1;
        int i = 0; int j = 0;
        while(top <= bottom && left <= right){

            while(j < right){
                mat[i][j++] = ele;
                ele++;
            }
            j--;
            top++;
            i = top;

            while(i < bottom){
                mat[i++][right - 1] = ele;
                ele++;
            }
            right--;
            i = bottom - 1;
            j= right -1;

            while(j >= left){
                mat[bottom -1][j --] = ele;
                ele++;
            }
            bottom --;
            i = bottom - 1;
            j = left;
            
            while(i >= top){
                mat[i--][j] = ele;
                ele++;
            }
            left++;
            j  =left;
            i = top;

        }

        return mat;

    }
}