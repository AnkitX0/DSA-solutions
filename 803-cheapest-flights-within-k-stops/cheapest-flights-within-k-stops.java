class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        

        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0; i <= k; i++){
            long[] temp = dist.clone();

            for(int[]ed : flights){
                int from = ed[0];
                int to = ed[1];
                int price = ed[2];

                if(dist[from] != Integer.MAX_VALUE && dist[from]+price < temp[to]){
                    temp[to] = dist[from]+price;
                }
            }
            dist = temp;
        }
        return (int)dist[dst] == Integer.MAX_VALUE? -1: (int)dist[dst];
    }
}