class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] nums = new int[graph.length + 1];
        
        for(int i = 0; i < graph.length; i++)
            if (nums[i] == 0 && !traverse(graph, nums, i, 1)) return false;

        return true;
    }

    public boolean traverse (int graph[][], int[] nums, int i, int color){
        nums[i] = color;

        for(int l : graph[i]){
            if(nums[l] == 0 && !traverse(graph, nums, l, (color%2) +1)) return false;
            else if (nums[l] == color) return false;
        }
        return true;
    }
}