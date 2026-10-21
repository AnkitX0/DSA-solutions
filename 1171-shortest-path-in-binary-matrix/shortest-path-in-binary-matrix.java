class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        Queue<int[] > qu = new ArrayDeque<>();

        qu.offer(new int[]{0, 0, 1});
        // boolean visited = false;
        int dir[][] = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};      
        
        int path = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        
        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int i = cur[0];
            int j = cur[1];
            int step = cur[2];
            for(int[]d : dir){
                int ni = i+d[0];
                int nj = j+d[1];

                if(ni < 0 || nj < 0 || ni >= n || nj >= n || grid[ni][nj] == 1 || visited[ni][nj]) continue;
                visited[ni][nj] = true;
                qu.offer(new int[] {ni, nj, step +1});

            }    
            if(i == n-1 && j == n-1){
                path = Math.min(path, step);
            }
        }
        return path == Integer.MAX_VALUE ? -1 : path;
    }
}