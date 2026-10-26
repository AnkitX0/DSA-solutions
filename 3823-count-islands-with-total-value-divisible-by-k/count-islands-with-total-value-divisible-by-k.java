class Solution {
    int m, n;
    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int counter = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0) {
                    long val = traverse(grid, i, j);

                    if(val % k == 0) counter++;
                }
            }
        }
        return counter;
    }

    public long traverse(int[][] grid, int i, int j){

        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) return 0;

        long sum = grid[i][j];
        grid[i][j] = 0;

        sum += traverse(grid, i, j -1);
        sum += traverse(grid, i, j + 1);
        sum += traverse(grid, i + 1, j);
        sum += traverse(grid, i - 1, j);

        return sum;
    }
}