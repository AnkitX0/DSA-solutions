class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    public void backtrack (int i, int[] nums, List<Integer> lis){
        result.add(new ArrayList<>(lis));
        for(int j = i; j < nums.length; j++){
            lis.add(nums[j]);
            backtrack(j + 1, nums, lis);
            lis.remove(lis.size()-1);
        }
    }   
}