class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        for(int i=0; i<n; i++){
            if(nums[i]>0){
                int val = i + nums[i];
                result[i] = nums[val%n];
            }
            else if(nums[i]<0){
                int val = i+nums[i];
                result[i] = nums[(val%n + n)%n];
            }
            else result[i] = nums[i];
        }
        return result;
    }
}