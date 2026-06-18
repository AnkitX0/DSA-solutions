class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left  = 0;
        int right = 0;

        for(int i : weights){
                left = Math.max(left, i); 
                right+= i;}
        int result = 0;

        while (left <= right){
            int mid = left + (right - left) / 2;

            int day = 1;
            int sum = 0;
            
            for(int w : weights){
                sum += w;
                if(sum > mid){
                    sum = w;
                    day ++;
                }
            }

            if(day <= days){
                result = mid;
                right = mid -1;
            }

            else left = mid + 1;
        }

        return result;
    }
}