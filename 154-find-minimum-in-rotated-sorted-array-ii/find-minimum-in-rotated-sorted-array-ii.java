class Solution {
    public int findMin(int[] nums) {
        
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = high - (high - low) / 2;

            while(mid < high && nums[mid] == nums[high]) high--;

            if(nums[high] < nums[mid]) low = mid + 1;
            else high = mid - 1;
            ans = Math.min(nums[mid], ans);
        }

        return ans;
    }
}