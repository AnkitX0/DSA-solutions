class tower{
    int x;
    int y;
    int q;
    int sum;
    public tower(int x, int y, int sum, int q){
        this.x = x;
        this.y = y;
        this.sum = sum;
        this.q = q;
    }
}
class Solution {
    
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        
        PriorityQueue<tower> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.q != b.q ){
                    return Integer.compare(b.q, a.q);
                }
                
                if(a.x != b.x) return Integer.compare(a.x, b.x);
                
                return Integer.compare(a.y, b.y);
            }
        );

        for(int[] t : towers){
            int a = Math.abs(t[0] - center[0]);
            int b = Math.abs(t[1] - center[1]);

            if(a+b <= radius)   pq.add(new tower(t[0], t[1], a+b, t[2]));
        }

        if (pq.isEmpty()) return new int [] {-1, -1};

        tower tr = pq.poll();

        return new int[] {tr.x, tr.y};
    }
}