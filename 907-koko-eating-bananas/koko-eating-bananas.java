class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = 0;

        for(int i : piles)  if(end < i) end = i;

        int k = Integer.MAX_VALUE;

        while(start <= end){

            int mid = start + (end - start) / 2;

            Long hrs = 0L;
            for(int i : piles){
                hrs += (i + mid - 1L) / mid;
            }


            if(hrs > h) start = mid + 1;
            else {
                k = mid;
                end = mid - 1;}
        }  

        return k;
    }
}