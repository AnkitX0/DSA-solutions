class Solution {
    public int dominantIndex(int[] nums) {
        
        int maxNum = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] > maxNum) {
                maxNum = nums[i];
                index = i;
            }
        }


        for(int i = 0; i < nums.length; i++){
            if(maxNum < 2*nums[i] && index != i) return -1;
        }

        return index;

    }
}       