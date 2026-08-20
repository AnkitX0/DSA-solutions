class Solution {
    public int[] resultArray(int[] nums) {
        
        List<Integer> num = new ArrayList<>();
        num.add(nums[0]);
        num.add(nums[1]);

        int idx1 = 0;
        int idx2 = 1;

        for(int i = 2; i < nums.length; i++){
            if(num.get(idx1) > num.get(idx2)) {
                idx1++;
                idx2++;
                num.add(idx1, nums[i]);
            }
            else {
                num.add(nums[i]);
                idx2++;
            }
        }

        int[] arr = new int[num.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = num.get(i);
        }
        return arr;
    }
}