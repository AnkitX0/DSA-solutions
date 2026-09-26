class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        boolean[] visited = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];
        
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        
        for (int[] ed : edges){
            int e = ed[0];
            int v = ed[1];
            
            graph[e].add(v);
            graph[v].add(e);            
        }
        dfs(source, graph, visited);
        if(visited[destination]) return true;
        return false;

    }

    public void dfs (int sour, List<Integer>[] graph, boolean[] visited){

        visited[sour] = true;
        for (int s : graph[sour]){
            if(!visited[s]) {
                dfs (s, graph, visited);
            }
        }
    }
}