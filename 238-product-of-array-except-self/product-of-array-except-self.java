class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] result = new int[n];

        int temp = 1;
        for(int i=0; i<n; i++){
            prefix[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for(int i=n-1; i>=0; i--){
            postfix[i] = temp;
            temp *= nums[i];
        }
        for(int i=0; i<n; i++){
            result[i] = prefix[i]*postfix[i];
        }
        return result;
    }
}