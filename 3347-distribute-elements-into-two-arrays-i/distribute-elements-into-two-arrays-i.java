class Solution {
    public int[] resultArray(int[] nums) {
        
        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();

        num1.add(nums[0]);
        num2.add(nums[1]);

        for(int i = 2; i < nums.length; i++){
            if(num1.get(num1.size() - 1) > num2.get(num2.size() - 1)) num1.add(nums[i]);
            else num2.add(nums[i]);
        }
        num1.addAll(num2);

        int[] arr = new int[num1.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = num1.get(i);
        }
        return arr;
    }
}