class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long low = 1;
        long high = (long)time[0]*(long)totalTrips;

        while(low <= high){
            long mid = low + (high-low) / 2;

            if(checkTime(time, mid, totalTrips)){
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return low;
    }
    public boolean checkTime(int[] time, long t, long totalTrips){
        long trip = 0; 
        for(int i = 0; i < time.length; i++){
            trip += t / time[i];
            if(trip >= totalTrips) return true;
        }
        return false;
    }
}