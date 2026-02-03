class Solution {
    public boolean isTrionic(int[] nums) {
        int indez = 0;
        int n = nums.length;

        if(n <= 3) return false;

        for(int i=0; i<n-1; i++){
            if(nums[i]>=nums[i+1]) break;
            indez++;
        }
        if (indez == 0 || indez == n - 1) return false;

        for(int i=indez; i<n-1; i++){
            if(nums[i]<=nums[i+1]) break;
            indez++;
        }
        if (indez == n - 1) return false;

        for(int i=indez; i<n-1; i++){
            if(nums[i]>=nums[i+1]) break;
            indez++;
        }

        if(indez == n-1) return true;
        return false;
    }
}