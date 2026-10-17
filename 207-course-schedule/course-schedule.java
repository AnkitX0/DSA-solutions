class Solution {
    public boolean canFinish(int n, int[][] pre) {
        if(pre.length == 0) return true;
        
        int[] inDegree = new int[n];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int[] p : pre){
            inDegree[p[0]]++;
            graph.get(p[1]).add(p[0]);
        }

        Queue <Integer> que = new ArrayDeque<>();
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0){
                que.offer(i);
                }
        }


        while(!que.isEmpty()){
            int cur = que.poll();
            counter++;

            for(int i : graph.get(cur)){
                inDegree[i] --;
                if(inDegree[i]==0) {
                    que.offer(i);
                }
            }
        }
        return counter == n;
    }
}