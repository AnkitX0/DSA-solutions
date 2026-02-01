class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        
        int mini = nums[0];

        Arrays.sort(nums, 1, n);

        mini += nums[1] +nums[2];

        return mini;

    }
}