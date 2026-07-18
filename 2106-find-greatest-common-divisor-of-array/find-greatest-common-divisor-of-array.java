class Solution {
    public int findGCD(int[] nums) {
        
        int mini = nums[0];
        int maxi = nums[1];

        for(int i : nums){
            if(i < mini) mini = i;
            if(i > maxi) maxi = i;
        }

        while(mini != 0){
            int temp = mini;
            mini = maxi % mini;
            maxi = temp;
        }
        return maxi;
    }
}