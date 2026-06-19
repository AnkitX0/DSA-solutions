class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        if( (long)m * k > bloomDay.length) return -1;

        int low = Integer.MAX_VALUE;
        int high = 0;

        for(int bloom : bloomDay){
            low  = Math.min(low, bloom);
            high = Math.max(high, bloom); 
        }
        int ans = -1;

        while(low <= high){
            
            int mid = low + (high - low) / 2;

            int bouq = 0;
            int flower = 0;
            
            for(int i : bloomDay){
                if(i <= mid)flower ++;
                else flower = 0;
                
                if(flower ==k){
                    bouq++;
                    flower = 0;
                }
            }

            if(bouq >= m){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
}