class Solution {
    private void sorting(int[] arr){

        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        sorting(nums);
        List<Integer> result = new ArrayList<>();

        int count = 0;
        for(int i : nums){
            if(target == i) result.add(count);
            count++; 
        }
        return result;
    }
}