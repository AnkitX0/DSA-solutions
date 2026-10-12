class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        boolean visited[] = new boolean[n + 1];
        for(List<Integer> lis : edges){
            graph.get(lis.get(0)).add(lis.get(1));
            visited[lis.get(1)] = true;
        }

        
        List<Integer> ans = new ArrayList<>();
        
        for(List<Integer> lis : edges){
            int i = lis.get(0);
            if(visited[i]) continue;
            ans.add(i);
            visited[i] = true;
        }
        return ans;


    }
    
}