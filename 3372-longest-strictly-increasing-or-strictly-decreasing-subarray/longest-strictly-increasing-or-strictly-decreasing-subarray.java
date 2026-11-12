class Solution {
    public int longestMonotonicSubarray(int[] nums) {

        int len = 0;
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            int count = 1;
            int t = i;
            while(t < n-1 && nums[t] < nums [t + 1]) {
                t++;
                count++;
            }
            len = len < count ? count : len;

            count = 1;
            t = i;
            while(t < n-1 && nums[t] > nums [t + 1]) {
                t++;
                count++;
            }
            len = len < count ? count : len;
        }   
        return len;
    }
}