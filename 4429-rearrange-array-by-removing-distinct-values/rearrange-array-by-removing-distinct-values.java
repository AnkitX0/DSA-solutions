class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        
        int [] num = new int[101];
        for(int i : nums){
            num[i]++;
        }
        int idx = 0;
        while(n-- > 0){
            for(int i = 1; i <= 100; i++){
                if(num[i]-- > 0){
                    ans[idx++] = i;
                }
            }
        }
        return ans;
    }
}