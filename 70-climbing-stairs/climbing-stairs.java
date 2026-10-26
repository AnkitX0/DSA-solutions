class Solution {
    public int climbStairs(int n) {
        
        if(n <= 2) return n;

        int [] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2; 
        recur(dp, n);

        return dp[n];
    }

    public int recur(int[] dp, int n){
        
        if(n <= 2) return n;
        if(dp[n]!=0) return dp[n];
        return dp[n] = recur(dp, n-1) + recur(dp, n-2);
        
    }

}