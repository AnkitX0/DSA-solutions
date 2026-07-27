class Solution {
    public int maxProduct(int[] nums) {
        int max = 0,secondMax = 0;
        
        for(int rem : nums){
            if(rem > max){
                secondMax = max;
                max = rem;
            }
            else if(rem > secondMax) secondMax = rem;
        }
        return( max-1) * (secondMax-1);
        
    }
}