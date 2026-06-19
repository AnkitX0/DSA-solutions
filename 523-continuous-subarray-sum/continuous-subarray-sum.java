class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        

        int prefix[] = new int[nums.length];
        prefix[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            prefix[i] = prefix[i -1] + nums[i];
        }


        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for(int i = 0; i < nums.length; i++){
            int sum = (prefix[i]) % k;

            // sum = k == 0 ? prefix[i] : sum;

            if(!map.containsKey(sum)) map.put(sum, i);

            else if (i - map.get(sum) > 1) return true;
        }

        return false;
    }
}