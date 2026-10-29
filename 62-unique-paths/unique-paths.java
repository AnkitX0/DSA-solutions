class Solution {
    int dp[][];
    
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int d[] : dp) Arrays.fill(d, -1);
        dp[0][0] = 1;
        traverse(m-1, n-1, m, n);

        return dp[m-1][n-1];
    }

    public int traverse(int i, int j, int m, int n){

        if(i < 0 || j < 0 || i >= m || j >= n) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = traverse(i - 1, j, m, n) + traverse(i, j-1, m, n);        
    }
}