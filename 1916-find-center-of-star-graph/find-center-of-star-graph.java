class Solution {
    public int findCenter(int[][] edges) {
        int row = edges.length, col = edges[0].length;
        int[] count = new int[row + 2];

        for(int[] r : edges){
            for(int i : r){
                count[i]++;
                if(count[i] == row) return i;
            }
        }
        return 0;
        
    }
}