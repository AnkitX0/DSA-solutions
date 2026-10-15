class Solution {
    int counter = 0;
    public int minReorder(int n, int[][] connections) {
        
        List<List<Integer>> roads= new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) roads.add(new ArrayList<>());

        for(int[] con : connections){
            roads.get(con[0]).add(con[1]);
            roads.get(con[1]).add(con[0]);
            
            List<Integer> ls ;
            if(map.containsKey(con[0])) ls = map.get(con[0]);
            else ls = new ArrayList<>();
            ls.add(con[1]);
            map.put(con[0], ls);
        } 

        boolean[] visited = new boolean[n];

        traverse(roads, 0, visited, map);
        return counter;       
    }

    public void traverse (List<List<Integer>> roads, int i, boolean[] visited, HashMap<Integer, List<Integer>> map){

        if(visited[i]) return;

        visited[i] = true;

        for(int r : roads.get(i)){
            if(visited[r]) continue;
            boolean contain = false;
            if(map.containsKey(i)){
                for(int e : map.get(i)){
                    if(e == r){
                        contain = true;
                        break;
                    }
                }
            }
            if(contain) counter++;
            traverse(roads, r, visited, map);
        }
    }
}