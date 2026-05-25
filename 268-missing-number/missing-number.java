class Solution {
    public int missingNumber(int[] nums) {
        
        HashSet <Integer> set = new HashSet<>();
        int n = nums.length;

        for(int i : nums){
            set.add(i);
        }
            
        if(!set.contains(0)) return 0;

        for(int i = 0; i < n; i++) if(!set.contains(nums[i]+1) && nums[i] != n) return nums[i]+1;

        return n + 1;

    }
}