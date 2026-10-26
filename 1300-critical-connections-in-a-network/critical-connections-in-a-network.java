class Solution {

    int low[];
    int dt[];
    int time = 1;
    List<List<Integer>> adj = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        low = new int[n];
        dt = new int[n];

        for(int i = 0; i < n; i++)  adj.add(new ArrayList<>());

        for(List<Integer> con : connections){
            adj.get(con.get(0)).add(con.get(1));
            adj.get(con.get(1)).add(con.get(0));
        }

        Arrays.fill(dt, -1);
        
        for(int i =0; i < n; i++){
            if(dt[i] == -1)dfs(i, -1);
        }

        return result;
    }

    public void dfs(int u, int parent){
        
        dt[u] = low[u] = time++;

        for(int v : adj.get(u)){
            
            if(v == parent) continue;

            if(dt[v] == -1){
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);

                if(low[v] > dt[u]) result.add(Arrays.asList(u, v));
            }
            else low[u] = Math.min(low[u], dt[v]);
        }
    }
}