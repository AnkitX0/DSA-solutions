class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones) pq.add(i);
        while(!pq.isEmpty()){
            int n1 = pq.poll();
            if(pq.isEmpty()) return n1;
            int n2 = pq.poll();

            if (n1 > n2) pq.add(n1 - n2);
            else pq.add(n2 - n1);
        }
        return 0;
    }
}