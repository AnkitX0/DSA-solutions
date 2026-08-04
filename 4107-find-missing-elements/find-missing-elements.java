class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        int min = 101, max = 0;
        for(int i : nums){
            if(i < min) min = i;
            if(i > max) max = i;
            set.add(i);
        }   

        for(; min < max; min++){
            if(!set.contains(min)) ans.add(min);
        }

        return ans;
    }
}