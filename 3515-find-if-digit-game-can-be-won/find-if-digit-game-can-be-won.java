class Solution {
    public boolean canAliceWin(int[] nums) {
        
        int sumSingle = 0;
        int sumDouble = 0;

        for(int i : nums){
            if(i < 10) sumSingle += i;
            else sumDouble +=i;
        }

        return sumSingle != sumDouble;
    }
}