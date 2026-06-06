class Solution {
    public int heightChecker(int[] heights) {
        
        int[] expected = heights.clone();
        Arrays.sort(heights);

        int counter = 0;
        for (int i = 0; i < heights.length; i++){
            if(heights[i] != expected[i]) counter++;
        }
        return counter;
    }
}