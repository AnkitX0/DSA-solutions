class Solution {
    public long[] findPrefixScore(int[] nums) {

        long ans[]    = new long[nums.length];

        int max = nums[0];
        nums[0] = nums[0]*2;
        ans[0]  = nums[0];
        for(int i = 1;i < nums.length; i++){
            max     = Math.max(max, nums[i]);
            ans[i] += max + ans[i-1] + nums[i];
        }
        return ans;        
    }
}