class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) ->{
                
                if(Math.abs(a-x) != Math.abs(b-x)){
                    return Integer.compare(Math.abs(b-x), Math.abs(a-x));
                }
                return Integer.compare(b, a);
            }
        );

        for(int i : arr){
            pq.add(i);
            if(pq.size() > k) pq.poll();
        }

        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.sort(ans);
        return ans;
    }
}