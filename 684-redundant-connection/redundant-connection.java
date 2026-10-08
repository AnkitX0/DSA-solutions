class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        
        ArrayList<ArrayList<Integer>> lis = new ArrayList<>();
        for(int i = 0; i <= edges.length; i++){
            lis.add(new ArrayList<>());
        }

        for(int ed[] : edges){
            boolean visited[] = new boolean[lis.size()];
            if(isCycle(lis, visited, ed[0],ed[1])) return ed;
            lis.get(ed[0]).add(ed[1]);
            lis.get(ed[1]).add(ed[0]);
        }
        return edges[0];

    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> lis, boolean[] visited, int i,int j){

        if(i == j) return true;
        visited[i] = true;

        for(int idx : lis.get(i)){

            if(visited[idx]) continue;

            if(isCycle(lis, visited, idx, j)) return true;
        }

        return false;
    }
}