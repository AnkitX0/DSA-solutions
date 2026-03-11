class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int left = 0;
        int right = 0;
        int n = nums.length;

        int sum = 0;
        int min = n+1;

        while(right < n || sum >=target){
            if(sum >= target && left <=right ) {
                // System.out.println(left+" "+right+" "+sum);
                min = Math.min(min, (right-left));
                sum -= nums[left++];
            }
            else {
                if(right < n){
                sum += nums[right];
                right++;
                }
            }
        }

        return min == n+1 ? 0 : min;
    }
}