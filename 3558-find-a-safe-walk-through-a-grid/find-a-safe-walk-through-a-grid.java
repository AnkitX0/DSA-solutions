class Solution {
    
    List<List<Integer>> grid;
    int m, n;
    boolean visited[][];

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        this.grid = grid;
        m = grid.size();
        n = grid.get(0).size();

        int[][] healthMap = new int [m][n];
        for(int row[] : healthMap)Arrays.fill(row, -1);
        
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[] {0, 0, health});
  
        while(!que.isEmpty()){
        
            int[] arr = que.poll();
            int i = arr[0];
            int j = arr[1];
            health = arr[2];
            
            if (i < 0 || j < 0 || i >= m || j >= n) continue;
            if(grid.get(i).get(j) == 1) health--;
            
            if(health <= 0) continue;
            if(i == m - 1 && j == n - 1) return true;

            if(healthMap[i][j] < health) healthMap[i][j] = health;
            else continue; 

            que.add(new int[] {i + 1, j, health});
            que.add(new int[] {i, j + 1, health});
            que.add(new int[] {i - 1, j, health});
            que.add(new int[] {i, j -1, health});
        }
        return false;
    }
}