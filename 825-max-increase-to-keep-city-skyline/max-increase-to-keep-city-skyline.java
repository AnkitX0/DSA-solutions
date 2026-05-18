class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

    //    ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> col = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < grid[0].length; i++){

            int rowmax = Integer.MIN_VALUE;
            int colmax = Integer.MIN_VALUE;

            for(int j = 0; j < grid.length; j++){                
                rowmax  = grid[i][j] > rowmax ? grid[i][j] : rowmax;
                colmax  = grid[j][i] > colmax ? grid[j][i] : colmax;
            }
            row.add(rowmax);
            col.add(colmax);
        }

        System.out.println(row.toString());
        System.out.println(col.toString());
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){ 

                sum += Math.abs(grid[i][j] - Math.min(row.get(i), col.get(j)));

            }
        }


        return sum;
        
    }
}