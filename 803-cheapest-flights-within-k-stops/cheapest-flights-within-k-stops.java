class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

            List<List<int[]>> lis = new ArrayList<>();

            for (int i = 0; i < n ; i++){
                lis.add(new ArrayList<>());
            }
            for(int[]fl : flights){
                lis.get(fl[0]).add(new int[] {fl[1], fl[2]});
            }

            Queue<int[]> q = new ArrayDeque<>();
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            q.offer(new int[] {0, src, 0});
            dist[src] = 0;

            while(!q.isEmpty()){
                int[] curr = q.poll();

                int w = curr[0];
                int u = curr[1];
                int v = curr[2];

                if(w > k) continue;

                for(int[] it : lis.get(u)){
                    int nU = it[0];
                    int nV = it[1];

                    if(v+nV < dist[nU]){
                        dist[nU] = v+nV;

                        q.offer(new int[] {w + 1, nU, dist[nU]});
                    }
                }
            }
            return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }   
}