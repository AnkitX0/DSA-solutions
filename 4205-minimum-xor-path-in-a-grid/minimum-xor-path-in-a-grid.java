class Solution {
    
    int[][]grid;
    boolean[][][]dp;
    int m, n;

    public int minCost(int[][] grid) {
        
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        dp = new boolean[m][n][1024];
        dfs(0, 0, grid[0][0]);       
        
        for(int x = 0; x < 1024; x++){
            if(dp[m-1][n-1][x]){
                return x;
            }
        }      
        
        return -1;
    }


    public void dfs(int i, int j, int x){
        
        if(dp[i][j][x]) return;    
        dp[i][j][x] = true;
        
        if(i < m-1){
            int xor = x^grid[i+1][j];
            dfs(i+1, j, xor);
        }
        if(j < n-1){
            int xor = x^grid[i][j+1];
            dfs(i, j+1, xor);
        }
        
    }

    
}