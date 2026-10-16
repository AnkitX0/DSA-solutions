class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        for(int j = 0; j <= m; j++){
                if(grid[j][0] == 1) dfs(j, 0, grid);
                if(grid[j][n] == 1) dfs(j, n, grid); 
        }
        for(int j = 0; j <= n; j++){
            if(grid[0][j] == 1) dfs(0, j, grid);
            if(grid[m][j] == 1) dfs(m, j, grid);
        }

        int counter = 0;

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(grid[i][j] == 1) counter++;
            }
        }
        return counter;
    }

    public void dfs (int i, int j, int[][]grid){

        if( i < 0 ||  j < 0 || i >=grid.length || j >= grid[0].length) return;
        if(grid[i][j] == 0) return;

        int[][] dir = new int [][] {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        grid[i][j] = 0;
        for(int d[] : dir){
            dfs(i+d[0], j + d[1], grid);
        }
    }
}