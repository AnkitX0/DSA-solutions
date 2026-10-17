class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] dist = new int [n +1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        List<List<int[]>> graph = new ArrayList<>();
        for(int i =0; i <= n; i++) graph.add(new ArrayList<>());

        for(int[] t : times){
            graph.get(t[0]).add(new int[] {t[2], t[1]});
        }   

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        pq.offer(new int[] {0, k});

        while(!pq.isEmpty()){
            int curr[] = pq.poll();

            if(curr[0] > dist[curr[1]]) continue;

            for(int[] p : graph.get(curr[1])){

                if(curr[0] + p[0] < dist[p[1]]){
                    dist[p[1]] = p[0] + curr[0];

                    pq.offer(new int[] {curr[0]+p[0], p[1]});
                }
            }
        }
        int ans = 0;
        System.out.println(Arrays.toString(dist));
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            if(ans < dist[i]) ans = dist[i];
        }
        return ans;
    }
}