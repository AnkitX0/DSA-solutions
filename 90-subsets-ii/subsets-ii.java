class Solution {
    HashSet<List<Integer>> set = new HashSet<>(); 
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>());
        
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> lis : set){
            result.add(lis);
        }
        return result;
    }

    public void backtrack (int i, int[] nums, List<Integer>lis){
        set.add(new ArrayList<>(lis));
        for(int j = i;j < nums.length;j++){
            lis.add(nums[j]);
            backtrack (j + 1, nums, lis);
            lis.remove(lis.size() - 1);
        }
    }
}