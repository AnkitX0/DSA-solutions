class Solution {
    public int minimumDeletions(int[] nums) {
        
        int minIdx = 0, maxIdx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > nums[maxIdx]) maxIdx = i;
            if(nums[i] < nums[minIdx]) minIdx = i;
        }
        int n = nums.length;
        return Math.min((Math.min(minIdx, maxIdx) + (n - Math.max(minIdx, maxIdx)) + 1), Math.min((Math.max(minIdx, maxIdx) + 1), (n - Math.min(minIdx, maxIdx))));
    }
} 