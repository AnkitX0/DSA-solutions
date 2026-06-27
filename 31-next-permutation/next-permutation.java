class Solution {

    private void reverse(int[] nums, int left, int right){
        while(left <= right){
             int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void nextPermutation(int[] nums) {
        int right = nums.length- 1;
        int left = right -1;
        while(left >= 0 && nums[left] >= nums[left+1]){
            left--;
        }

        if(left == -1) {reverse(nums, 0, right); return;}
        
        int idx = nums.length - 1;
       while(nums[idx] <= nums[left]) idx--;

        int temp = nums[left];
        nums[left] = nums[idx];
        nums[idx] = temp;
        reverse(nums, left + 1, nums.length -1);
        
    }
}