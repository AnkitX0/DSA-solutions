class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int counter = 0;
        map.put(0, 1);
        for(int i : nums){
            sum += i;
            int rem = ((sum%k) + k) % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        for(int i : map.values()){
            counter += (i * (i -1)) /2;
        }
        return counter;
    }
}