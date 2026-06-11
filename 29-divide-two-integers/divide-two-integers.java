class Solution {
    public int divide(int dividend, int divisor) {

        int MaxNum = Integer.MAX_VALUE ;
        int minNum = Integer.MIN_VALUE ;

        long ans = (long)dividend / (long)divisor;

        if(ans > MaxNum) return MaxNum;

        if(ans < minNum) return minNum;

        return (int)ans;
    }
}