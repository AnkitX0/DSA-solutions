class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        
        while(k-- > 0){

            int temp  = grid[grid.length - 1][grid[0].length-1];

            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    int val = grid[i][j];
                    grid[i][j] = temp;
                    temp = val;
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int row[] : grid){
            List<Integer> r = new ArrayList<>();
            for(int i : row){
                r.add(i);
            }
            ans.add(r);
        }

        return ans;
    }
}