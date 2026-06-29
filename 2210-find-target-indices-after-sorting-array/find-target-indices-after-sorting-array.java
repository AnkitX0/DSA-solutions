class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        int count = 0;
        for(int i : nums){
            if(target == i) result.add(count);
            count++; 
        }
        return result;
    }
}