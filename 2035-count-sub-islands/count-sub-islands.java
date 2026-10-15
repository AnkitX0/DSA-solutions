class Solution {

    
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        Queue<int[]> markZero = new LinkedList<>();

        int m = grid1.length;
        int n = grid1[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid1[i][j] == 0 && grid2[i][j] == 1) markZero.offer(new int []{i, j});
            }
        }

        int dir[][] = new int [][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!markZero.isEmpty()){
            int[] idx = markZero.poll();
            int i = idx[0], j = idx[1];

            if(i < 0 || j < 0 || i >= m || j >= n) continue;
            if(grid2[i][j] == 0) continue;
            grid2[i][j] = 0;            
            for (int[] d : dir){
                markZero.offer(new int[] {i+d[0], j+d[1]});
            }
        }

        int counter = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid2[i][j] == 1){
                    dfs(grid2, i, j);
                    counter ++;
                }
            }
        }


        return counter;
    }

    public void dfs (int [][] grid, int i, int j){
            if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return;
            if(grid[i][j] == 0) return;

            grid[i][j] = 0;
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);

    }
}