class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        int sum = 0;
        int c = 0;

        for(int i : nums){
            sum += i;

            c += map.getOrDefault(sum - goal, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return c;
    }
}