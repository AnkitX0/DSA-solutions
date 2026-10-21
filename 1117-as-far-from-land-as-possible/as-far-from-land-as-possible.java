class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]>q = new ArrayDeque<>();

        for(int i = 0; i < m;i++){
            for(int j = 0; j < n;j ++){
                if(grid[i][j] == 1){
                     q.offer(new int[] {i, j});
                    }
            }
        }
        if(q.size() == m*n) return -1;

        
        int ans = -1;
        int dir[][] = new int[][] { {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        
        while(!q.isEmpty()){

            int size = q.size();
            while(size-- > 0){
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                for (int dr[] : dir){
                    int ni = i + dr[0];
                    int nj = j + dr[1];

                    if(ni < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] == 1) continue;
                    grid[ni][nj] = 1;
                    q.offer(new int[]{ni, nj});
                }
            }
            ans++;
        }
        return ans;
    }
}