class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] ed : edges){
            List<Integer> ls1;
            if(map.containsKey(ed[0])){ 
                ls1 = map.get(ed[0]);
            }
            else {
                ls1 = new ArrayList<>();    
            }
            ls1.add(ed[1]);
            map.put(ed[0], ls1);

            List<Integer> ls2;
            if(map.containsKey(ed[1])){ 
                ls2 = map.get(ed[1]);
            }
            else {
                ls2 = new ArrayList<>();    
            }
            ls2.add(ed[0]);
            map.put(ed[1], ls2);
            
        }
        dfs(source, map, visited);
        if(visited[destination]) return true;
        return false;

    }

    public void dfs (int sour, HashMap<Integer, List<Integer>> map, boolean[] visited){

        visited[sour] = true;
        if(!map.containsKey(sour)) return;
        List<Integer> ls = map.get(sour);
        for (int s : ls){
            if(!visited[s]) {
                dfs (s, map, visited);
            }
        }
    }
}