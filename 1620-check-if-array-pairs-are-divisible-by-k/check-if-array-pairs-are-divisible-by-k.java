class Solution {
    public boolean canArrange(int[] arr, int k) {

        int[] rem = new int[k];

        for(int i : arr){
            int r = ((i % k) + k )%k;
            rem[r]++;
        }        
        if(rem[0] % 2 != 0) return false;

        for(int i = 1; i <= k/2; i++){
            int r = ((i % k) + k) % k;
            if(rem[r] != rem[k-r])    return false;
        }
        return true;        
    }
}