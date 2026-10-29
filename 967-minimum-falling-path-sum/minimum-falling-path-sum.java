class Solution {
    int dp[][];
    int matrix[][];
    int m, n;
    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int [m][n];
        for(int d[] : dp) Arrays.fill(d, 101);

        for(int i = 0; i < n ;i++){
            dp[0][i] = matrix[0][i];
        }

        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            minSum = Math.min(minSum, traverse(m-1, i));
        }
        return minSum;
    }

    public int traverse(int i, int j){

        if( i < 0 || j < 0 || i >= m || j >= n) return Integer.MAX_VALUE;

        if(dp[i][j] != 101) return dp[i][j];

        return dp[i][j] = matrix[i][j] 
                        + Math.min(traverse(i-1, j +1) , 
                          Math.min(traverse( i - 1, j), traverse(i - 1, j - 1)));
    }
}