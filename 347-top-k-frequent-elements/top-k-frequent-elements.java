class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> []lis = new List[nums.length + 1];

        for(int i : nums){
            if (!map.containsKey(i)) map.put(i, 1);
            else map.put(i, map.get(i) + 1);
        }

        for(int key : map.keySet()){
            
            if(lis[(map.get(key))] == null){
                lis[map.get(key)] = new ArrayList<>();
            }
                lis[map.get(key)].add(key);
        }

        int [] result = new int[k];
        int counter = 0;

        for(int i = lis.length - 1; i >= 0 && counter < k; i--){
            if (lis[i] != null){
                for(int val : lis[i]){
                    result[counter++] = val;
                }
            }
        }

        return result;
    }
}