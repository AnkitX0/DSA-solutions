class Solution {
    public int maxEnvelopes(int[][] env) {
        int n = env.length;

        Arrays.sort(env, ((a, b) -> {
            if(a[0]!=b[0]) return a[0]-b[0];
            return b[1]-a[1];
        }));

        List<Integer> tail = new ArrayList<>();
        tail.add(env[0][1]);

        for(int i = 1; i < n; i++){
            if(tail.get(tail.size()-1) < env[i][1]){
                tail.add(env[i][1]);
                continue;
            }

            int l = 0;
            int r = tail.size();
            while(l < r){
                int mid = l + (r - l) / 2;

                if(tail.get(mid) >= env[i][1]){
                    r = mid;
                }
                else l = mid+1;
            }
            tail.set(l, env[i][1]);
        }
        return tail.size();
    }
}