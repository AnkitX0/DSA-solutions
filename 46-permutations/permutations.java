class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];

            permut(0, nums, visited , new ArrayList<>());
        
        return result;
    }

    public void permut (int i, int[] nums, boolean[]visited, List<Integer> lis){

        if(lis.size() == nums.length)   result.add(new ArrayList<>(lis));
        if(lis.size() > nums.length) return;
        
        for (int j = 0; j < nums.length; j++){
            if(visited[j]) continue;
            lis.add(nums[j]);    
            visited[j] = true;
            permut(j+1, nums, visited, lis);
            lis.remove(lis.size() - 1);
            visited[j] = false;    
        }
    }
}