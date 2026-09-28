class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int dp[] = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(climbing(dp, 0, cost), climbing(dp, 1, cost));

    }
    public int climbing (int[] dp,int i, int[] cost){
        
        if(i >= cost.length) return 0;
        if(dp[i] != -1) return dp[i];
        dp[i] = cost[i] + Math.min(climbing(dp, i+1, cost), climbing(dp, i+2, cost));
        return dp[i];
    }
}