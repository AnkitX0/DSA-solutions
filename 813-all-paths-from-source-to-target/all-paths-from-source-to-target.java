class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        findPath(new ArrayList<>(), 0, graph);
        return result;
    }

    public void findPath (List<Integer> lis, int i, int[][]graph){

        lis.add(i);

        if(i == graph.length - 1) result.add(new ArrayList<>(lis));
        
        for(int g : graph[i]){
            findPath(lis, g, graph);
        }
        lis.remove(Integer.valueOf(i));
    }
}