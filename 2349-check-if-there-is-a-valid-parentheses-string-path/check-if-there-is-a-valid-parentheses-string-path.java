class Solution {
    public boolean hasValidPath(char[][] grid) {
        if((grid.length + grid[0].length - 1) % 2 == 1) return false;

        int[][][] valid = new int[grid.length][grid[0].length][ (grid.length + grid[0].length)];

        return traverse(grid, 0, 0, 0, valid) == 1;
    }

    public int traverse(char[][] grid, int i, int j, int parentheses, int[][][] valid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return 2;


        
        if(grid[i][j] == '(') parentheses++;
        else parentheses--;

        if(parentheses < 0){
            return 2;
        }
        if(valid[i][j][parentheses] != 0) return valid[i][j][parentheses];

        if(i == grid.length-1 && j == grid[0].length-1){
            if(parentheses == 0) {
                valid[i][j][parentheses] = 1;
                return valid[i][j][parentheses];
            }
            else {
            valid[i][j][parentheses] = 2;
            return valid[i][j][parentheses];}
        }

        int down = traverse(grid, i + 1, j, parentheses, valid);
        int right = traverse(grid, i, j + 1, parentheses, valid);  

        if(down == 1 || right == 1) valid[i][j][parentheses] = 1;
        else valid[i][j][parentheses] = 2;

        return valid[i][j][parentheses];
    }
}