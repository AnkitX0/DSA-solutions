class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        
        int n = nums.length;
        int []prefix = new int[n];
        int []suffix = new int[n];

        HashSet<Integer> set = new HashSet<>();
        int unique = 0;
        for(int i = 0; i < n; i++){
            if(!set.contains(nums[i])){
                unique++;
            }
            set.add(nums[i]);
            prefix[i] = unique;
        }

        set.clear();
        unique = 0;
        for(int i = n - 1; i >= 0 ; i--){
            suffix[i] = unique;
            if(!set.contains(nums[i])){
                unique++;
            }
            set.add(nums[i]);
        }

        for(int i = 0; i < n; i++){
            nums[i] =  prefix[i] - suffix[i] ;
        }
        return nums;
    }
}