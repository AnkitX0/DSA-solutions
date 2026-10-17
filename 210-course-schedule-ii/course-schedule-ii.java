class Solution {
    public int[] findOrder(int n, int[][] pre) {

        int[] inDegree = new int[n];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i < n; i++) graph.add(new ArrayList<>());
        for(int p[] : pre){
            inDegree[p[0]]++;
            graph.get(p[1]).add(p[0]);
        }

        Queue<Integer> que = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0) que.offer(i);
        }

        while(!que.isEmpty()){
            int cur = que.poll();
            ans.add(cur);

            for(int i : graph.get(cur)){
                inDegree[i]--;
                if(inDegree[i] == 0)que.offer(i);
            }
        }
        if(ans.size() != n) return new int[0];
        int[] arr = new int [ans.size()];
        for(int i = 0; i  < ans.size(); i++){
            arr[i] = ans.get(i);
        }
        
        return arr;
    }
}