class Solution {
    int dp[][];
    int[][] obstacleGrid;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        this.obstacleGrid = obstacleGrid;
        if(obstacleGrid[0][0] == 1) return 0;
        // if(m == 1 && n == 1) return 1;
        dp = new int[m][n];
        
        dp[0][0] = 1;
        traverse(m-1, n-1, m, n);

        return dp[m-1][n-1];
    }

    public int traverse(int i, int j, int m, int n){

        if(i < 0 || j < 0 || i >= m || j >= n || obstacleGrid[i][j] == 1) return 0;

        if(dp[i][j] != 0) return dp[i][j];
        return dp[i][j] = traverse(i - 1, j, m, n) + traverse(i, j-1, m, n);        
    }
}