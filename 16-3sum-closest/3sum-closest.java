class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int sum = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1, k = nums.length -1;

            while(j < k){
                int add = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - add) <  Math.abs(target-sum)) sum = add;

                if(add > target) k--;
                else if(add < target) j++;
                else return add;

            }

        }
        return sum;
    }
}
