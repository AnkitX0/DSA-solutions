class Solution {
    public int thirdMax(int[] nums) {

        HashSet <Integer> set = new HashSet<>();
        
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : nums){

            if(!set.contains(i)){
                set.add(i);
                pq.add(i);
            }            
        }   

        if(pq.size() <= 2) return pq.peek();

        int c = 2;
        while(c-- > 0) pq.poll() ;
        return pq.poll();
    }
}