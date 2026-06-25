class Solution {
    public int arrangeCoins(int n) {
        int res = 0;
        int left = 1;
        int right = n;

        while(left <= right){

            int mid = left + (right - left) / 2;
            long val = (long)mid *(long)(mid + 1) / 2; 
            
            if( val > n) right = mid -1;
            else if (val == n) return mid; 
            else{
                res= mid;
                left = mid + 1;
            }
        }
        return res ;
    }
}