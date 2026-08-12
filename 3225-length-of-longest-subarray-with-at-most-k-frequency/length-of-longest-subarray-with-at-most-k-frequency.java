class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSize = 0;
        int size = 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            
            map.put(nums[j], map.getOrDefault((nums[j]), 0) + 1);
            while(map.get(nums[j]) > k){
                // maxSize = Math.max(maxSize, size);
                size--;
                map.put(nums[i], map.get(nums[i]) -1);
                i++;
            }
            size++;
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }
}