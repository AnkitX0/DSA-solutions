class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if( n == 1) return true;

        // while(n > 0){
        //     if( n % 2 != 0) return false;
        //     n /= 2;
        // }

        for(int i = 0; i*i <= n+1; i++){
            if((int) Math.pow(2, i) == n) return true;
            else if((int) Math.pow(2, i)  > n) break;
        }
        return false;
    }
}