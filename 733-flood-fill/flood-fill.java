class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        boolean[][] visited = new boolean[image.length][image[0].length];

        dfs(image, sr, sc, color, image[sr][sc], visited);

        return image;
    }

    public void dfs (int[][] image, int i, int j, int color, int prev, boolean[][] visited){

        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length) return;
        
        if(image[i][j] != prev) return;
        if(visited[i][j]) return;

        image[i][j] = color;
        visited[i][j] = true;
        dfs (image, i + 1, j, color, prev, visited);
        dfs (image, i - 1, j, color, prev, visited);
        dfs (image, i, j + 1, color, prev, visited);
        dfs (image, i, j - 1, color, prev, visited);

    }
}