class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int max = Integer.MAX_VALUE;
        int idx = nums.length - 1;
        int left = 0;
        int right = idx;
        int result[] = new int[idx + 1];

        while(left <= right){
            int leftSqr = nums[left] * nums[left];
            int rightSqr = nums[right] * nums[right];

            if(leftSqr > rightSqr){
                result[idx--] = leftSqr;
                left++;
            }
            else{
                result[idx--] = rightSqr;
                right--;
            }
        }

        
        return result;
    }
}