class Solution {
    public long sumAndMultiply(int n) {
        
        long x = 0;
        long sum = 0;
        while(n > 0){
             long rem = n %10;
             if(rem != 0) {
                sum += rem;
                x =  x * 10 + rem;
                }
             n /= 10;
        }
        long revX = 0;
        while(x > 0){
            revX = revX * 10 + x %10;
            x /= 10;
        }
        return revX * sum;

    }
}