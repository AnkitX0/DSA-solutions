class Solution {
    int row, col, grid[][];
    public int orangesRotting(int[][] grid) {
        
        this.grid = grid;

        row = grid.length;
        col = grid[0].length;

        Queue<int[]> temp = new LinkedList<>();

        int min = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2) temp.add(new int[]{i, j, 0});
            }
        }
        int timeTaken = 0;

        // boolean visited[][] = new boolean[row][col];


        while(!temp.isEmpty()){
            int arr[] = temp.poll();
            int i = arr[0];
            int j = arr[1];
            int time = arr[2];

            if(grid[i][j] == 0) {
                continue;
            }

            if (i > 0 && grid[i - 1][j] == 1) {
                temp.add(new int[]{i - 1, j, time + 1});
                grid[i - 1][j] = 2;
            }
            if (j > 0 && grid[i][j - 1] == 1) {
                temp.add(new int[]{i, j - 1, time + 1});
                grid[i][j - 1] = 2;
            }
            if (i < row - 1 && grid[i + 1][j] == 1) {
                temp.add(new int[]{i + 1, j, time + 1});
                grid[i + 1][j] = 2;
            }
            if (j < col - 1 && grid[i][j + 1] == 1) {
                temp.add(new int[]{i, j + 1, time + 1});
                grid[i][j + 1] = 2;
            }
            grid[i][j] = 2;
            timeTaken = time;
        }

        for(int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){

                if(grid[i][j] == 1) return -1;
            }
        }
        return timeTaken;
    }
    
}