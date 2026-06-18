class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(k == 1) return nums;
        int n = nums.length;

        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = 0;
        while(right < k){
            
            if(dq.isEmpty()) dq.addLast(right);
            else{
                while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) dq.pollLast();
                dq.addLast(right);
            }
            right++;
        }
        result.add(nums[dq.peekFirst()]);

        while(right < n){

            if(dq.peekFirst() == left) dq.pollFirst();
            left++;

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]) dq.pollLast();
            dq.addLast(right);

            result.add(nums[dq.peekFirst()]);
            right++;
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++) res[i] = result.get(i);
        return res;
    }
}