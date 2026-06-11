class Solution {
    public int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int ans = 0;

        if(dividend == divisor) return 1;

        boolean sign = true;
        
        if(dividend <=0 && divisor > 0) sign = false;
        if(dividend > 0 && divisor < 0) sign  = false;

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        while(n >= d){
            int counter = 0;

            while( n >= (d<<(counter+1))){
                counter++;
            }

            ans += 1L << counter;
            n -= (d << counter);
        }

        return sign ? (int)ans : (int)-ans;
    }
}