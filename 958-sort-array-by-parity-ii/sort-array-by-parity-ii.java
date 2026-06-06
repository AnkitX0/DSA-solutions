class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        
        int left = 0;
        int n = nums.length ;
        int right = 1;
        while(left < n && right < n){

            while ( (left < n) && nums[left] % 2 == 0 ) left += 2;
            while ( (right < n) && nums[right] % 2 == 1 ) right += 2;

            if( left < n && right < n){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
            }        
            
        }

        return nums;
    }
}