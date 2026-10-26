class Solution {
    int m, n;
    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int counter = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]) {
                    long val = traverse(grid, i, j, visited);
                    if(val % k == 0) counter++;
                }
            }
        }
        return counter;
    }

    public long traverse(int[][] grid, int i, int j, boolean[][] visited){

        if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) return 0;

        visited[i][j] = true;

        long left = traverse(grid, i, j -1 , visited);
        long right = traverse(grid, i, j + 1, visited);
        long down = traverse(grid, i + 1, j, visited);
        long up = traverse(grid, i - 1, j, visited);

        return grid[i][j] + left + right + down + up;
    }
}