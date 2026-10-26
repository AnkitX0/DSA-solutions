class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < routes.length; i++){
            adj.add(new ArrayList<>());
        }
        Queue<int[]> qu = new ArrayDeque<>();

        for(int i = 0; i < routes.length; i++){
            for(int j = i + 1; j < routes.length; j++){
                boolean common = false;
                for(int stop1 : routes[i]){
                    for(int stop2 : routes[j]){
                        if(stop1 == stop2){
                            common = true;
                            break;
                        }
                    }
                    if(common) break;
                }
                if(common){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }


        boolean visited[] = new boolean[routes.length];
        for(int i = 0; i < routes.length; i++){
            for(int stop : routes[i]){
                if(stop == source){
                    qu.add(new int[] {i, 1});
                    visited[i] = true;
                    break;
                }
            }
        }


        while(!qu.isEmpty()){
            int cur[] = qu.poll();
            int route = cur[0];
            int bus = cur[1];
            
            for(int stop : routes[route]){
                    if(stop == target) return bus;
                }

            for(int r : adj.get(route)){
                if(visited[r]) continue;
                visited[r] = true;
                qu.add(new int[] {r, bus+1});
            }
        }
        return -1;
    }
}