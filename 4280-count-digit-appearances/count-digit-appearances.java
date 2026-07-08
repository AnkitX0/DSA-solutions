class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {

        int counter = 0;
        
        for(int n : nums){
            while(n > 0){
                 if(n%10 == digit) counter++;
                 n /= 10;
            }
        }
        return counter;
        
    }
}