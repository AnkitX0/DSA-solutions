class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        int size = 0;
        for(int i = 0; i < nums.length; i+= 2){
            size += nums[i];
        }
        System.out.println(size);

        int[] result = new int[size];
        int idx = 0;
        for(int i = 1; i < nums.length; i += 2){
            int t = nums[i - 1];
            while(t-- > 0) result[idx++] = nums[i];
        }   
        return result;
    }
}