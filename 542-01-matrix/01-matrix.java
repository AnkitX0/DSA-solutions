class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        boolean [][] visited = new boolean[row][col];
        int [][] ans = new int[row][col];

        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 0){
                    visited[i][j] = true;
                    que.add(new int[]{i, j, 0});
                }
            }
        }

        while(!que.isEmpty()){
            int[] arr = que.poll();
            int i = arr[0];
            int j = arr[1];
            int step = arr[2];

            if(i > 0 && mat[i - 1][j] == 1 && !visited[i-1][j]){
                visited[i-1][j] =true;
                que.add(new int[] {i-1, j, step + 1});
            }

            if(j > 0 && mat[i][j - 1] == 1 && !visited[i][j -1]){
                visited[i][j - 1] = true;
                que.add(new int[] {i, j - 1, step + 1});
            }

            if(i < row-1 && mat[i + 1][j] == 1 && !visited[i+1][j]){
                visited[i  +1][j] = true;
                que.add(new int[] {i  +1, j, step  +1});
            }
            if(j < col -1 && mat[i][j + 1] == 1 && !visited[i][j + 1]){
                visited[i][j + 1] = true;
                que.add(new int[] {i, j + 1, step  +1});
            }

            ans[i][j] = step;
        }
        return ans;
    }

}