class Solution {
    List<List<Integer>> triangle;
    int size;
    int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        this.triangle = triangle;
        this.size = triangle.size();
        dp = new int[size][size];
        for(int[] d : dp)Arrays.fill(d, Integer.MAX_VALUE);
        dp[0][0] = triangle.get(0).get(0);
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < triangle.get(size-1).size(); i++){
            int num = traverse(size-1, i);
            min = Math.min(min, num);
        }
        return min;        
    }

    private int traverse(int i, int j){
        if( i < 0 || j < 0 || j >= triangle.get(i).size()) return Integer.MAX_VALUE;

        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        return dp[i][j] = triangle.get(i).get(j)  
                        + Math.min(traverse(i - 1, j), traverse(i-1, j-1));

    }
}