class Solution {
    public int minCapability(int[] nums, int k) {

        int low = nums[0], high = low;

        for(int i : nums){
            low = i < low ? i : low;
            high = i > high ? i : high;
        }

        int result = high;
        while(low <= high){
            int mid = low + (high-low) / 2;

            if(check(nums, k, mid)){
                result = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return result;        
    }

    public boolean check(int[] nums, int k, int mid){
         int house = 0;

         for(int i = 0; i < nums.length; i++){
            if(nums[i] <= mid){
                house++;
                i++;
            }
        }
        return house >= k;
    }
}