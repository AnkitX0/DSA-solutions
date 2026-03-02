class Solution {
    int[] nums;
    int n;
    int[] dp;
    public int jump(int[] nums) {
        this.nums = nums;
        n = nums.length-1;

        dp = new int[n+1];
        Arrays.fill(dp, -1);

        return steps(0);
    }

    private int steps(int i){
        if(i >= n) return 0;
        if(nums[i] == 0) return Integer.MAX_VALUE;
        if(dp[i] != -1) return dp[i];

        int step = Integer.MAX_VALUE;

        for(int j = nums[i]; j>0; j--){
            int res = steps(i+j);

            if(res != Integer.MAX_VALUE){
                step = Math.min(step,1+res);
            }
        }

        return dp[i] = step;
    }
}