class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue< int[] > cap = new PriorityQueue<>( (a, b) -> {
            if(a[1] == b[1]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[1], b[1]);
        });
        PriorityQueue< int[] > pro = new PriorityQueue<>( (a, b) -> Integer.compare(b[0], a[0]));

        for(int i = 0; i < profits.length; i++){
            cap.add(new int[] {profits[i], capital[i]});
        }

        while(k-- > 0){
            while(!cap.isEmpty() && w >= cap.peek()[1]) {
                pro.add(cap.poll());
            }
            if(pro.isEmpty()) break;
            w += pro.poll()[0];
        }

        return w;
    }
}