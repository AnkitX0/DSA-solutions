
class Solution {

    class edges{
        String node;
        double weight;
        public edges (double e,String n){
            node = n;
            weight = e;
        }
    }    

    HashMap<String, Integer> map = new HashMap<>();     
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        List<List<edges>> graph = new ArrayList<>();
        for (List<String> ls : equations){
            if(!map.containsKey(ls.get(0))){
                map.put(ls.get(0), map.size()+1);
                graph.add(new ArrayList<>());
            }
            if(!map.containsKey(ls.get(1))){
                map.put(ls.get(1), map.size()+1);
                graph.add(new ArrayList<>());
            }
        }
        int idx = 0;
        for (List<String> ls : equations){
            int idxi = map.get(ls.get(0))-1;
            int idxj = map.get(ls.get(1))-1;

            graph.get(idxi).add(new edges(values[idx], ls.get(1)));
            graph.get(idxj).add(new edges((1/values[idx]), ls.get(0)));
            idx++;
        }

        double[] ans = new double[queries.size()];
        idx = 0;
        for (List<String> ls : queries){
            boolean[] visited = new boolean[map.size()];
            
            if(!map.containsKey(ls.get(0))){
                ans[idx++] = -1.00000;
                continue;
            }
            if(!map.containsKey(ls.get(1))){
                ans[idx++] = -1.00000;
                continue;
            }
            
            ans[idx++] = dfs(graph, (ls.get(0)), (ls.get(1)), 1.0, visited, 1.0);
        }
        return ans;
    }

    public double dfs (List<List<edges>> graph, String start, String end, double prod, boolean[] visited, double prev){
        
        if(visited[map.get(start) -1]) return -1.00000;

        visited[map.get(start) -1] = true;
        prod *= prev;
        if(start.equals(end)){
            return prod;
        }
        for(edges str : graph.get(map.get(start) -1)){
            double sol = dfs(graph, str.node, end, prod, visited, str.weight);
            if(sol != -1.00000) return sol;
        }

        return  -1.00000;
    }
}