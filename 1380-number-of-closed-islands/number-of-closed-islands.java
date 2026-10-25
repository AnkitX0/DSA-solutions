class Solution {
    int m, n;
    public int closedIsland(int[][] grid) {
        m = grid.length; n = grid[0].length;
        for(int j = 0; j < n; j++){
                if(grid[0][j] == 0)makeOne(grid, 0, j);
                if(grid[m-1][j] == 0)makeOne(grid, m-1, j);
        }
        for(int i = 0; i < m; i++){
                if(grid[i][0] == 0)makeOne(grid, i, 0);
                if(grid[i][n-1] == 0)makeOne(grid, i, n-1);
        }

        int counter = 0;
        for(int i = 0; i < m; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == 0){
                    makeOne(grid, i, j);
                    counter++;
                }
            }
        }
        return counter;
    }

    public void makeOne(int[][]grid, int i, int j){

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1) return;
        grid[i][j] = 1;

        makeOne(grid, i, j + 1);
        makeOne(grid, i, j - 1);
        makeOne(grid, i + 1, j);
        makeOne(grid, i - 1, j);
    }
}