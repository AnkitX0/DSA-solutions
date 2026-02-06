class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);
        // HashSet <Integer> set = new HashSet<>();

        int ans=n;

        int j = 0;
        for(int i = 0; i<n; i++){
            long sum = (long)k* nums[i];
            while(j < n && nums[j] <= sum) j++;
            ans = Math.min(ans, n-(j-i));
        }

        return ans;
    }
}