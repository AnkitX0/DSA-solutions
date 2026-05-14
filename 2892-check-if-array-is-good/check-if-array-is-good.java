class Solution {
    public boolean isGood(int[] nums) {
        Arrays.sort(nums);

        int size = nums.length;

        for(int i = 0; i < size-1; i++) {
            if(nums[i] != i + 1) return false;
        }

        return nums[size-1] == size-1;
    }

}