class Solution {
    public int longestSubsequence(int[] nums) {

        int num = 0;
        boolean check = false;

        for(int i = 0; i < nums.length; i++){
            num ^= nums[i];
            if(nums[i] != 0) check = true;
        }

        if(num != 0) return nums.length ;
        if(check) return nums.length - 1;
        return 0;
    }
}