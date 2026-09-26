class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 0) continue;
                graph[i].add(j);
                graph[j].add(i);
            }
        }
        
        boolean[] visited = new boolean[n];
        int counter = 0;
        for (int i = 0; i < n; i++){
            if(!visited[i]){
                traverse(i, graph, visited);
                counter++;
            }
        }
        return counter;

    }

    public void traverse (int start, List<Integer>[]graph, boolean[]visited){

        visited[start] = true;
        for (int i : graph[start]){
            if(!visited[i]) traverse(i, graph, visited);
        }
    } 
}