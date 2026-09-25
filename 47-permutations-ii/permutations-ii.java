class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permut (nums, visited,new ArrayList<>());

        for(List<Integer> s : set) result.add(s);
        return result;
    }

    public void permut (int[] nums, boolean[] visited, List<Integer>lis){

        if(lis.size() == nums.length)   set.add(new ArrayList<>(lis));
        if(lis.size() > nums.length) return;

        for (int j = 0; j < nums.length; j++){
            if(visited[j]) continue;

            visited[j] = true;
            lis.add(nums[j]);
            permut (nums, visited, lis);            
            visited[j] = false;
            lis.remove(lis.size() - 1);
        }
    }
}