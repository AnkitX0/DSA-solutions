class Solution {
    public int[] decompressRLElist(int[] nums) {
        
        ArrayList<Integer> lis = new ArrayList<>(); 
        for(int i = 0; i < nums.length; i+=2){
            while(nums[i]-- > 0) lis.add(nums[i + 1]);
        }

        int[] result = new int[lis.size()];
        for(int i = 0; i < lis.size(); i++){
            result[i] = lis.get(i);
        }

        return result;
    }
}