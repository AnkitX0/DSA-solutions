class Solution {
    public int smallestNumber(int n) {
        
        int num = 0;
        int idx = 1;
        while(num <= n){
            num =  1 << (idx++);
        }
        return num-1;
    }
}