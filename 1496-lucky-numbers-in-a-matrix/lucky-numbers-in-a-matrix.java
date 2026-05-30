class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        
        int[] min = new int[matrix.length];
        int[] max = new int[matrix[0].length];
        Arrays.fill(min, Integer.MAX_VALUE);

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                    if(min[i] > matrix[i][j]) min[i] = matrix[i][j];

                    if(max[j] < matrix[i][j]) max[j] = matrix[i][j];
            }
        }

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(min[i] == max[j]) result.add(min[i]);
            }
        }
        return result;
    }
}