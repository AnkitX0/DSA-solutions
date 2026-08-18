class Solution {
    public int splitArray(int[] nums, int k) {
        int left = nums[0];
        int right = 0;
        int ans = left;

        for(int i : nums){
            left = i > left ? i : left;
            right += i;
        }

        while(left <= right){
            int mid = left + (right-left) / 2;

            if(subArray(mid, nums, k))left = mid + 1;
            else{
                ans = mid;
                right = mid - 1;}
        }

        return ans;
    }

    private boolean subArray(int range, int[]nums,int k){
        int sum = 0;
        int counter = 1;

        for(int i : nums){
            sum+= i;

            if(sum > range){
                sum = i;
                counter++;
            }
        }

        return counter > k;
    }
}