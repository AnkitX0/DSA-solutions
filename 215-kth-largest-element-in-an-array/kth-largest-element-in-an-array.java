class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : nums) pq.add(i);

        for(int i = 0; i < nums.length - k; i++){
            pq.poll();
        }
        return pq.poll();
    }
}