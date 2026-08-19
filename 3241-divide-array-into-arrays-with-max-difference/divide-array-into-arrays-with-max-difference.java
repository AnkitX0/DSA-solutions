class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);

        int[][] ans = new int[nums.length / 3][3];

        int idx = 0;
        for(int i = 0; i < nums.length/3; i++){
            if(nums[idx+1] - nums[idx] <= k && nums[idx+2] - nums[idx] <= k && nums[idx+2] - nums[idx+1] <= k){
                for(int j = 0; j < 3; j++){
                    ans[i][j] = nums[idx++];
                }
            }
            else return new int[][]{};
        }

        return ans;
    }
}