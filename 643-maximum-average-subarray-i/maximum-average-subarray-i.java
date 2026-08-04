class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double sum = 0;
        for(int i = 0; i < k; i++){
            sum+= nums[i];
        }   
        int n = nums.length;
        double max = sum/k;    
        int idx = 0;
        for(int i = k; i < n; i++){
            sum = sum - nums[idx++] + nums[i];
            max = Math.max(sum/k, max);
        }

        return max;
    }
}