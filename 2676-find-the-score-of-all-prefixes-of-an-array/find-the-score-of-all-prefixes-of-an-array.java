class Solution {
    public long[] findPrefixScore(int[] nums) {
        int max[]    = new int[nums.length];
        long conver[] = new long[nums.length];

        max[0] = nums[0];
        conver[0] = nums[0]*2;

        for(int i  = 1; i < nums.length; i++){
            max[i] = Math.max(max[i-1], nums[i]);
            conver[i] = nums[i] + max[i] + conver[i-1];
        }

        return conver;        
    }
}