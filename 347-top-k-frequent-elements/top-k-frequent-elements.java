class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue <int[]> pq = new PriorityQueue<>( (a, b) -> a[1] - b[1]);

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(int i : map.keySet()){
             pq.offer(new int []{i, map.get(i)} );

             if(pq.size() > k){
                pq.poll();
             }
        }

        int result[] = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll()[0];
        }
        return result;
    }
}