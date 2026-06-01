class Solution {
    public int minimumCost(int[] cost) {
        
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());
        for(int i : cost) pq.add(i);

        int money = 0;
        int t = 0;

        while(!pq.isEmpty()){
            t++;
            if(t % 3 == 0)pq.poll();
            else money += pq.poll();
        }
        
        return money;
    }
}