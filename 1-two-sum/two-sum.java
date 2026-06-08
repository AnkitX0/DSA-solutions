class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        int start = 0;
        int i = 0;
        for(; i < nums.length; i++ ){
            
            if(map.containsKey(target - nums[i])){start = map.get(target - nums[i]); break;}
            map.put(nums[i], i);
        }

        return new int[] {start, i};
    }
}