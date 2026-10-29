class Solution {
    int[][] dp;
    int[][]grid;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        dp = new int[m][n];
        this.grid = grid;

        for(int d[] : dp) Arrays.fill(d, -1);
        dp[0][0] = grid[0][0];

        traverse(m-1, n-1, m, n);
        return dp[m-1][n-1];
    }

    public int traverse(int i, int j, int m, int n){

        if(i < 0 || j < 0 || i >= m || j >= n) return Integer.MAX_VALUE;

        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = grid[i][j] +Math.min(traverse(i - 1, j, m, n),traverse(i, j-1, m, n));        
    }
}