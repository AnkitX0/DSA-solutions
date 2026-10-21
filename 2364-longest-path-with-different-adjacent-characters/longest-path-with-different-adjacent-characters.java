class Solution {

    int maxAns = 0;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ;i < n; i++) list.add(new ArrayList<>());

        for(int i = 1; i < n; i++){
            list.get(parent[i]).add(i);
        }   

        dfs(0, list, s);
        return maxAns;
    }

    public int dfs(int node, List<List<Integer>> list, String s){

        int left = 0;
        int right = 0;

        for(int li : list.get(node)){
            int path = dfs(li, list, s);
            if(s.charAt(li) == s.charAt(node)) continue;

            if(path > left){
                right = left;
                left = path;
            }
            else if(path > right){
                right = path;
            }
        }
        if(left+right+1 > maxAns) maxAns = left+right+1; 
        return left+1;
    }
}