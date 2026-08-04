class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        int[] set = new int[101];

        int min = 101, max = 0;
        for(int i : nums){
            if(i < min) min = i;
            if(i > max) max = i;
            set[i]++;
        }   

        for(; min < max; min++){

            if(set[min] == 0) ans.add(min);
        }

        return ans;
    }
}