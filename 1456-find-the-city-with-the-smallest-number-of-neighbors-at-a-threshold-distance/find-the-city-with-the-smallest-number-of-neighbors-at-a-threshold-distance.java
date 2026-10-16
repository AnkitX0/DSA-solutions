class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] mat = new int [n][n];

        int INF = 1000_000;
        for(int m[] : mat) Arrays.fill(m, INF);

        for(int i = 0; i < edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int val = edges[i][2];
            mat[a][b] = val;
            mat[b][a] = val;
        }

        for(int k = 0; k < n; k ++){
            for(int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){        
                    if(i == k) continue;
                    if ( i== j) {
                        mat[i][j] = 0;
                        continue;
                    }
                    if(mat[i][k] ==  INF || mat[k][j] == INF) continue;
                    mat[i][j] = Math.min(mat[i][j] , mat[i][k] + mat[k][j]);
                }
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                if(mat[i][j] <= distanceThreshold) sum ++;
            }
            if(sum > 0)map.put(i, sum);
        };

        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key) <= map.get(ans)) ans = key;
        }

        return ans;
    }

}