class Solution {
    public boolean isHappy(int n) {

        while(n > 9){
            int newN = 0;
            while(n > 0){
                int rem = n %10;
                newN += rem * rem;
                n /= 10;
            }
            n = newN;
        }

        return n==1 || n == 7;
        
    }
}